package org.pasa.sispasaint.carga.impl;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.core.enumeration.EnumOrigemInformacoes;
import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.core.enumeration.EnumTipoVinculoEmpregaticio;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Pessoa;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ModeloBenEndBeanImpl;
import org.pasa.sispasaint.bean.impl.MunicipioBeanImpl;
import org.pasa.sispasaint.bean.impl.NivelEscolaridadeBeanImpl;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEntidadeFuncionario {

    private Funcionario funcionario;
    private final CargaEntidadeBeneficiario cargaEntidadeBeneficiario;
    private final EmpresaBeanImpl empresaBean;
    private final ModeloBenEndBeanImpl modeloBenEndBean;
    private final FuncionarioBeanImpl funcionarioBean;
    private final NivelEscolaridadeBeanImpl nivelEscolaridadeBean;

    public CargaEntidadeFuncionario() {
        funcionarioBean = new FuncionarioBeanImpl();
        this.cargaEntidadeBeneficiario = new CargaEntidadeBeneficiario();
        this.empresaBean = new EmpresaBeanImpl();
        this.modeloBenEndBean = new ModeloBenEndBeanImpl();
        this.nivelEscolaridadeBean = new NivelEscolaridadeBeanImpl();
    }

    public boolean newFuncionario(ModeloBenEnd modeloBenEnd) {
        Empresa empresa = empresaBean.existe(modeloBenEnd.getEmpresa());
        if (null == empresa) {
            return false;
        } else {
            funcionario = new Funcionario();
            funcionario.setPessoa(new Pessoa());
            //EMPRESA
            funcionario.setEmpresa(empresa);
            //ENDERECO
            if (!(null == newEndereco(modeloBenEnd))) {
                funcionario.getPessoa().addEndereco(newEndereco(modeloBenEnd));
            }
            //DOCUMENTOS
            funcionario.getPessoa().setCpf(modeloBenEnd.getCpf());
            funcionario.getPessoa().addDocumento(newPis(modeloBenEnd));
            //TELEFONES
            funcionario.getPessoa().setTelefones(newTelefones(modeloBenEnd));
            //ATRIBUTOS 
            setAtributos(modeloBenEnd);
            //DADOS BANCARIOS
            funcionario.setDadosBancarios(newDadosBancarios(modeloBenEnd));
            //ORIGEM INFORMACOES
            funcionario.getPessoa().setOrigemInformacoes(newOrigemInformacoes());
            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio(modeloBenEnd));

            //MATRICULAS
            funcionario.setMatriculaOrigem(modeloBenEnd.getMatriculaPeople());//IMPORTANTE
            funcionario.setMatriculaAtualizadora(modeloBenEnd.getMatriculaAtulizador());
            funcionario.setMatriculaPasa(modeloBenEnd.getMatriculaPasa());

            //INSERT
            funcionario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            funcionario.getPessoa().setDataInclusaoSistema(DateUtil.obterDataAtual());

            funcionarioBean.cadastrar(funcionario);//gerar ID

            //BENEFICIARIOS
            List<ModeloBenEnd> benef = modeloBenEndBean.listarBeneficiarios(modeloBenEnd);
            for (ModeloBenEnd f : benef) {
                Beneficiario b = cargaEntidadeBeneficiario.newBeneficiario(f);
                if (null == b) {
                    return false;
                } else {
                    b.setFuncionario(funcionario);
                    if (f.getCodBeneficiario().equals("00")) {
                        b.setPessoa(funcionario.getPessoa());
                    }
                    funcionario.addBeneficiario(b);
                }
            }
            return funcionarioBean.atualizar(funcionario);
        }
    }

    private Endereco newEndereco(ModeloBenEnd modelo) {
        Estado estado = new EstadoBeanImpl().obter(modelo.getUf());
        Municipio municipio = new MunicipioBeanImpl().existe(modelo.getCidade());
        if (null == municipio) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setLogradouro(modelo.getEndereco());
        endereco.setBairro(modelo.getBairro());
        endereco.setCep(modelo.getCep());
        endereco.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        endereco.setIndAtivo(SisPasaIntCommon.ATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        return endereco;
    }

    private Documento newPis(ModeloBenEnd modelo) {
        Documento pis = new Documento();
        TipoDocumento tpPIS = new TipoDocumento();
        pis.setNumero(modelo.getPis());
        pis.setNumero(modelo.getPis());
        tpPIS.setId(EnumTipoDocumento.PIS_PASEP.getIndice());
        tpPIS.setDescricao(EnumTipoDocumento.PIS_PASEP.getDescricao());
        pis.setTipoDocumento(tpPIS);
        pis.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        pis.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        return pis;
    }

    private List<Telefone> newTelefones(ModeloBenEnd modelo) {
        List<Telefone> listaTelefones = new ArrayList<>();
        Telefone tel1 = new Telefone();
        tel1.setNumeroTelefone(modelo.getTelefone1());
        tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel1);

        Telefone tel2 = new Telefone();
        tel2.setNumeroTelefone(modelo.getTelefone2());
        tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel2.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel2);
        return listaTelefones;
    }

    private void setAtributos(ModeloBenEnd modelo) {
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

    private NivelEscolaridade newNivelEscolaridade(ModeloBenEnd modelo) {
        NivelEscolaridade nivelEscolaridade = nivelEscolaridadeBean.obter(modelo.getGrauEscolaridade());
        return nivelEscolaridade;
    }

    private DadosBancarios newDadosBancarios(ModeloBenEnd modelo) {
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

    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio(ModeloBenEnd modelo) {
        TipoVinculoEmpregaticio tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
        tipoVinculoEmpregaticio.setId(EnumTipoVinculoEmpregaticio.EmpregadoAtivo.getIndice());
        tipoVinculoEmpregaticio.setCodExterno(modelo.getVinculo());
        return tipoVinculoEmpregaticio;
    }

    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setId(EnumOrigemInformacoes.CARGA.getIndice());
        origemInformacoes.setDescricao(EnumOrigemInformacoes.CARGA.getDescricao());
        return origemInformacoes;
    }
}
