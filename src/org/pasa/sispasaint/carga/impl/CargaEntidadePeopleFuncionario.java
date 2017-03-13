package org.pasa.sispasaint.carga.impl;

import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleBeanImpl;
import org.pasa.sispasaint.bean.impl.MunicipioBeanImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.core.enumeration.EnumOrigemInformacoes;
import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.core.enumeration.EnumTipoVinculoEmpregaticio;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Pessoa;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.bean.impl.NivelEscolaridadeBeanImpl;
import org.pasa.sispasaint.bean.impl.TipoDocumentoBeanImpl;
import org.pasa.sispasaint.bean.impl.TipoVinculoEmpregaticioBeanImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.SisPasaIntErro;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEntidadePeopleFuncionario {

    private final Log log;
    private Funcionario funcionario;
    private final LogBeanImpl logBean;
    private final ImpBenPeopleBeanImpl impBenPeopleTempBeanImpl;
    private final ImpEndPeopleBeanImpl impEndPeopleTempBeanImpl;
    private final CargaEntidadePeopleBeneficiario cargaEntidadePeopleBeneficiario;
    private final EmpresaBeanImpl empresaBean;
    private final FuncionarioBeanImpl funcionarioBean;
    private final EstadoBeanImpl estadoBeanImpl;
    private final MunicipioBeanImpl municipioBeanImpl;
    private final NivelEscolaridadeBeanImpl nivelEscolaridadeBean;
    private final TipoDocumentoBeanImpl tipoDocumentoBean;
    private final TipoVinculoEmpregaticioBeanImpl tipoVinculoEmpregaticioBean;

    public CargaEntidadePeopleFuncionario(Log log) {
        this.log = log;
        this.logBean = new LogBeanImpl();
        this.empresaBean = new EmpresaBeanImpl();
        this.estadoBeanImpl = new EstadoBeanImpl();
        this.municipioBeanImpl = new MunicipioBeanImpl();
        this.funcionarioBean = new FuncionarioBeanImpl();
        this.tipoDocumentoBean = new TipoDocumentoBeanImpl();
        this.nivelEscolaridadeBean = new NivelEscolaridadeBeanImpl();
        this.impBenPeopleTempBeanImpl = new ImpBenPeopleBeanImpl();
        this.impEndPeopleTempBeanImpl = new ImpEndPeopleBeanImpl();
        this.tipoVinculoEmpregaticioBean = new TipoVinculoEmpregaticioBeanImpl();
        this.cargaEntidadePeopleBeneficiario = new CargaEntidadePeopleBeneficiario(log);
    }

    public boolean newFuncionario(ModeloBenPeople modelo) {
        Empresa empresa = empresaBean.existe(modelo.getEmpresa());
        if (null == empresa) {
            log.addMatriculaErro(modelo.getEmpresa(), modelo.getMatriculaPeople(),
                    modelo.getCodBeneficiario(), modelo.getCpf(), SisPasaIntErro.TP_LOG_1,
                    SisPasaIntErro.ERRO_EMPRESA);
            logBean.atualizar(log);
            return false;
        } else {
            funcionario = new Funcionario();
            funcionario.setPessoa(new Pessoa());
            funcionario.setEmpresa(empresa);
            //ENDERECO
            if (!(null == newEndereco(modelo))) {
                funcionario.getPessoa().addEndereco(newEndereco(modelo));
            } else {
                log.addMatriculaErro(modelo.getEmpresa(), modelo.getMatriculaPeople(),
                        modelo.getCodBeneficiario(), modelo.getCpf(), SisPasaIntErro.TP_LOG_1,
                        SisPasaIntErro.ERRO_ENDERECO);
                logBean.atualizar(log);
                funcionario.getPessoa().addEndereco(fakeAdress());
            }
            //DOCUMENTOS
            funcionario.getPessoa().setCpf(modelo.getCpf());
            funcionario.getPessoa().addDocumento(newPis(modelo));
            //TELEFONES
            funcionario.getPessoa().setTelefones(newTelefones(modelo));
            //ATRIBUTOS 
            this.setAtributos(modelo);
            //DADOS BANCARIOS
            funcionario.setDadosBancarios(newDadosBancarios(modelo));
            //ORIGEM INFORMACOES
            funcionario.getPessoa().setOrigemInformacoes(newOrigemInformacoes());
            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio());
            //MATRICULAS
            funcionario.setMatriculaOrigem(modelo.getMatriculaPeople());//IMPORTANTE
            funcionario.setMatriculaAtualizadora(modelo.getMatriculaAtulizador());
            funcionario.setMatriculaPasa(modelo.getMatriculaPasa());
            //ATRIBUTOS CARGA
            funcionario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            funcionario.getPessoa().setDataInclusaoSistema(DateUtil.obterDataAtual());
            //PERSISTIR
            funcionarioBean.cadastrar(funcionario);//gerar ID
            //BENEFICIARIOS
            List<ModeloBenPeople> benef = impBenPeopleTempBeanImpl.listarBeneficiarios(modelo);
            for (ModeloBenPeople f : benef) {
                Beneficiario b = cargaEntidadePeopleBeneficiario.newBeneficiario(f);
                if (null == b) {
                    return false;
                } else {
                    b.setFuncionario(funcionario);
                    if (f.getCodBeneficiario().equals("00")) {
                        b.setId(funcionario.getId());
                    }
                    funcionario.addBeneficiario(b);
                }
            }
            return funcionarioBean.atualizar(funcionario);
        }
    }

    public Funcionario funcionarioFromModelo(ModeloBenPeople modelo) {
        Empresa empresa = empresaBean.existe(modelo.getEmpresa());
        funcionario = new Funcionario();
        funcionario.setPessoa(new Pessoa());
        funcionario.setEmpresa(empresa);
        //ENDERECO
        funcionario.getPessoa().addEndereco(newEndereco(modelo));
        //DOCUMENTOS
        funcionario.getPessoa().setCpf(modelo.getCpf());
        funcionario.getPessoa().addDocumento(newPis(modelo));
        //TELEFONES
        funcionario.getPessoa().setTelefones(newTelefones(modelo));
        //ATRIBUTOS 
        this.setAtributos(modelo);
        //DADOS BANCARIOS
        funcionario.setDadosBancarios(newDadosBancarios(modelo));
        //ORIGEM INFORMACOES
        funcionario.getPessoa().setOrigemInformacoes(newOrigemInformacoes());
        //VINCULO
        funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio());
        //MATRICULAS
        funcionario.setMatriculaOrigem(modelo.getMatriculaPeople());//IMPORTANTE
        funcionario.setMatriculaAtualizadora(modelo.getMatriculaAtulizador());
        funcionario.setMatriculaPasa(modelo.getMatriculaPasa());
        //ATRIBUTOS CARGA
        funcionario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
        funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        funcionario.getPessoa().setDataInclusaoSistema(DateUtil.obterDataAtual());
        //PERSISTIR
        funcionarioBean.cadastrar(funcionario);//gerar ID
        //BENEFICIARIOS
        List<ModeloBenPeople> benef = impBenPeopleTempBeanImpl.listarBeneficiarios(modelo);
        for (ModeloBenPeople f : benef) {
            Beneficiario b = cargaEntidadePeopleBeneficiario.newBeneficiario(f);
            b.setFuncionario(funcionario);
            if (f.getCodBeneficiario().equals("00")) {
                b.setId(funcionario.getId());
            }
            funcionario.addBeneficiario(b);
        }
        return funcionario;
    }

    private Endereco newEndereco(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        if (modeloEndPeople.getId() == -1L) {
            return fakeAdress();
        }
        Estado estado = estadoBeanImpl.obter(modeloEndPeople.getUf());
        if (null == estado) {
            log.addMatriculaErro(mBen.getEmpresa(), mBen.getMatriculaPeople(), mBen.getCodBeneficiario(),
                    mBen.getCpf(), SisPasaIntErro.TP_LOG_1, SisPasaIntErro.ERRO_UF);
            logBean.atualizar(log);
            return null;
        }
        Municipio municipio = municipioBeanImpl.existe(modeloEndPeople.getCidade());
        if (null == municipio) {
            log.addMatriculaErro(mBen.getEmpresa(), mBen.getMatriculaPeople(), mBen.getCodBeneficiario(),
                    mBen.getCpf(), SisPasaIntErro.TP_LOG_1, SisPasaIntErro.ERRO_CIDADE);
            logBean.atualizar(log);
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setLogradouro(modeloEndPeople.getEndereco());
        endereco.setBairro(modeloEndPeople.getBairro());
        endereco.setCep(modeloEndPeople.getCep());
        endereco.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        endereco.setIndAtivo(SisPasaIntCommon.ATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        return endereco;
    }

    private void setAtributos(ModeloBenPeople modelo) {
        //ATRIBUTOS 
        funcionario.getPessoa().setNome(modelo.getNomeBeneficiario());
        funcionario.getPessoa().setNomeAbreviado(modelo.getNomeBeneficiarioAbreviado());
        funcionario.getPessoa().setNomeMae(modelo.getNomeDaMae());
        funcionario.getPessoa().setSexo(modelo.getSexo());
        funcionario.getPessoa().setDataNascimento(DateUtil.toDate(modelo.getDataNascimento()));
        funcionario.setDireitoAbaterIR(modelo.getDireitoAbaterIR());
        funcionario.setDataAdmissao(DateUtil.toDate(modelo.getDataAdmissao()));
        funcionario.setFinanceira(modelo.getFinanceira());
        funcionario.setContratoTrabalho(modelo.getContratoTrabalho());
        funcionario.setEmpresaAtualizadora(modelo.getEmpresaAtualizador());
        funcionario.setMatriculaAtualizadora(modelo.getMatriculaAtulizador());
        funcionario.setCodDireitoPasa(modelo.getCodigoDireitoPasa());
        funcionario.setMatriculaPasa(modelo.getMatriculaPasa());
        funcionario.setMatriculaOrigem(modelo.getMatriculaOrigem());
        funcionario.setMatriculaPasa(modelo.getMatricula());
        funcionario.setUnidadeControle(modelo.getUnidadeDeControle());
        funcionario.setCentroCusto(modelo.getCentroDeCusto());
        funcionario.getPessoa().setNivelEscolaridade(newNivelEscolaridade(modelo));
        funcionario.getPessoa().setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modelo.getIndicadorConclusao()));
    }

    private Documento newPis(ModeloBenPeople modelo) {
        Documento pis = new Documento();
        TipoDocumento tpPIS = tipoDocumentoBean.obter(EnumTipoDocumento.PIS_PASEP.getIndice());
        pis.setNumero(modelo.getPis());
        pis.setTipoDocumento(tpPIS);
        pis.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        pis.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        return pis;
    }

    private List<Telefone> newTelefones(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        List<Telefone> listaTelefones = new ArrayList<>();

        if (!modeloEndPeople.getTelefone1().trim().equals("")) {
            Telefone tel1 = new Telefone();
            String auxTel1 = modeloEndPeople.getTelefone1().replaceAll(" ", "");
            if (auxTel1.length() > 18) {
                auxTel1 = StringUtil.truncTelefone(auxTel1);
            }
            tel1.setNumeroTelefone(auxTel1);
            tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
            tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            listaTelefones.add(tel1);
        }

        if (!modeloEndPeople.getTelefone2().trim().equals("")) {
            Telefone tel2 = new Telefone();
            String auxTel2 = modeloEndPeople.getTelefone1().replaceAll(" ", "");
            if (auxTel2.length() > 18) {
                auxTel2 = StringUtil.truncTelefone(auxTel2);
            }
            tel2.setNumeroTelefone(auxTel2);
            tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
            tel2.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            tel2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            listaTelefones.add(tel2);
        }
        return listaTelefones;
    }

    private NivelEscolaridade newNivelEscolaridade(ModeloBenPeople modelo) {
        NivelEscolaridade nivelEscolaridade = nivelEscolaridadeBean.obter(modelo.getGrauEscolaridade());
        return nivelEscolaridade;
    }

    private DadosBancarios newDadosBancarios(ModeloBenPeople modelo) {
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setCodBanco(modelo.getBanco());
        dadosBancarios.setAgencia(modelo.getAgenciaBancaria());
        dadosBancarios.setConta(modelo.getContaCorrente());
        dadosBancarios.setTipoConta(SisPasaIntCommon.CONTACORRENTE);
        dadosBancarios.setIndAtivo(SisPasaIntCommon.ATIVO);
        dadosBancarios.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        dadosBancarios.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        return dadosBancarios;
    }

    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio() {
        TipoVinculoEmpregaticio tipoVinculoEmpregaticio = tipoVinculoEmpregaticioBean.obter(EnumTipoVinculoEmpregaticio.EmpregadoAtivo.getIndice());
        return tipoVinculoEmpregaticio;
    }

    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setId(EnumOrigemInformacoes.CARGA.getIndice());
        origemInformacoes.setDescricao(EnumOrigemInformacoes.CARGA.getDescricao());
        return origemInformacoes;
    }

    private Endereco fakeAdress() {
        Estado estado = estadoBeanImpl.obter("RJ");
        Municipio municipio = municipioBeanImpl.existe("RIO DE JANEIRO");
        System.out.println(municipio.getId());
        Endereco endereco = new Endereco();
        endereco.setLogradouro("SEM ENDERECO");
        endereco.setBairro("SEM ENDERECO");
        endereco.setCep("0000000");
        endereco.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        endereco.setIndAtivo(SisPasaIntCommon.INATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        return endereco;
    }
}
