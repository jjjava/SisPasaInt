package org.pasa.sispasaint.carga.impl;

import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleTempBeanImpl;
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
import org.pasa.sispasaint.bean.impl.NivelEscolaridadeBeanImpl;
import org.pasa.sispasaint.bean.impl.TipoDocumentoBeanImpl;
import org.pasa.sispasaint.bean.impl.TipoVinculoEmpregaticioBeanImpl;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEntidadePeopleFuncionario {

    private Funcionario funcionario;
    private final ImpBenPeopleTempBeanImpl impBenPeopleTempBeanImpl;
    private final ImpEndPeopleTempBeanImpl impEndPeopleTempBeanImpl;
    private final CargaEntidadePeopleBeneficiario cargaEntidadePeopleBeneficiario;
    private final EmpresaBeanImpl empresaBean;
    private final FuncionarioBeanImpl funcionarioBean;
    private final EstadoBeanImpl estadoBeanImpl;
    private final MunicipioBeanImpl municipioBeanImpl;
    private final NivelEscolaridadeBeanImpl nivelEscolaridadeBean;
    private final TipoDocumentoBeanImpl tipoDocumentoBean;
    private final TipoVinculoEmpregaticioBeanImpl tipoVinculoEmpregaticioBean;

    public CargaEntidadePeopleFuncionario() {
        this.cargaEntidadePeopleBeneficiario = new CargaEntidadePeopleBeneficiario();
        this.empresaBean = new EmpresaBeanImpl();
        this.funcionarioBean = new FuncionarioBeanImpl();
        this.impBenPeopleTempBeanImpl = new ImpBenPeopleTempBeanImpl();
        this.impEndPeopleTempBeanImpl = new ImpEndPeopleTempBeanImpl();
        this.estadoBeanImpl = new EstadoBeanImpl();
        this.municipioBeanImpl = new MunicipioBeanImpl();
        this.nivelEscolaridadeBean = new NivelEscolaridadeBeanImpl();
        this.tipoDocumentoBean = new TipoDocumentoBeanImpl();
        this.tipoVinculoEmpregaticioBean = new TipoVinculoEmpregaticioBeanImpl();
    }

    public boolean newFuncionario(ModeloBenPeople modelo) {
        Empresa empresa = empresaBean.existe(modelo.getEmpresa());
        if (empresa == null) {
            return false;
        } else {
            if (empresa.getCodEmpresaVale().equalsIgnoreCase("90")) {
                System.out.println("PASA");
            }
            funcionario = new Funcionario();
            funcionario.setPessoa(new Pessoa());
            funcionario.setEmpresa(empresa);
            //ENDERECO
            if (!(newEndereco(modelo) == null)) {
               funcionario.getPessoa().addEndereco(newEndereco(modelo));
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
                if (b == null) {
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

    private Endereco newEndereco(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        if(modeloEndPeople == null){
            return null;
        }
        Estado estado = estadoBeanImpl.obter(modeloEndPeople.getUf());
        Municipio municipio = municipioBeanImpl.existe(modeloEndPeople.getCidade());
        if (municipio == null) {
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
            tel1.setNumeroTelefone(StringUtil.truncTelefone(modeloEndPeople.getTelefone1().replaceAll(" ", "")));
            tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
            tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            listaTelefones.add(tel1);
        }

        if (!modeloEndPeople.getTelefone2().trim().equals("")) {
            Telefone tel2 = new Telefone();
            tel2.setNumeroTelefone(StringUtil.truncTelefone(modeloEndPeople.getTelefone2().replaceAll(" ", "")));
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
}
