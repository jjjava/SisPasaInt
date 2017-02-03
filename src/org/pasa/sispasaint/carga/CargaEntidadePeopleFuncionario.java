package org.pasa.sispasaint.carga;

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
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.NivelEscolaridadeBeanImpl;
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

    public CargaEntidadePeopleFuncionario() {
        cargaEntidadePeopleBeneficiario = new CargaEntidadePeopleBeneficiario();
        empresaBean = new EmpresaBeanImpl();
        funcionarioBean = new FuncionarioBeanImpl();
        impBenPeopleTempBeanImpl = new ImpBenPeopleTempBeanImpl();
        impEndPeopleTempBeanImpl = new ImpEndPeopleTempBeanImpl();
        estadoBeanImpl = new EstadoBeanImpl();
        municipioBeanImpl = new MunicipioBeanImpl();
        nivelEscolaridadeBean = new NivelEscolaridadeBeanImpl();
    }

    public boolean newFuncionario(ModeloBenPeople modelo) {
        Empresa empresa = empresaBean.existe(modelo.getEmpresa());
        if (empresa == null) {
            return false;
        } else {
            funcionario = new Funcionario();
            funcionario.setEmpresa(empresa);
            //ENDERECO
            if (newEndereco(modelo) == null) {
                return false;
            } else {
                funcionario.addEndereco(newEndereco(modelo));
            }
            //DOCUMENTOS
            funcionario.setCpf(modelo.getCpf());
            funcionario.addDocumento(newPis(modelo));
            //TELEFONES
            funcionario.setTelefones(newTelefones(modelo));
            //ATRIBUTOS 
            setAtributos(modelo);
            //DADOS BANCARIOS
            funcionario.setDadosBancarios(newDadosBancarios(modelo));
            //ORIGEM INFORMACOES
            funcionario.setOrigemInformacoes(newOrigemInformacoes());
            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio(modelo));
            //BENEFICIARIOS
            
            
            //MATRICULAS
            funcionario.setMatriculaOrigem(modelo.getMatriculaPeople());//IMPORTANTE
            funcionario.setMatriculaAtualizadora(modelo.getMatriculaAtulizador());
            funcionario.setMatriculaPasa(modelo.getMatriculaPasa());

            //INSERT
            funcionario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            funcionario.setDataInclusaoSistema(DateUtil.obterDataAtual());
            
            funcionarioBean.cadastrar(funcionario);
            
            List<ModeloBenPeople> benef = impBenPeopleTempBeanImpl.listarBeneficiarios(modelo);
            for (ModeloBenPeople f : benef) {
                Beneficiario b = cargaEntidadePeopleBeneficiario.newBeneficiario(f);
                if (b == null) {
                    return false;
                } else {
                    b.setFuncionario(funcionario);
                    if(f.getCodBeneficiario().equals("00")){
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
        funcionario.setNome(modelo.getNomeBeneficiario());
        funcionario.setNomeAbreviado(modelo.getNomeBeneficiarioAbreviado());
        funcionario.setNomeMae(modelo.getNomeDaMae());
        funcionario.setSexo(modelo.getSexo());
        funcionario.setDataNascimento(DateUtil.toDate(modelo.getDataNascimento()));
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
        funcionario.setNivelEscolaridade(newNivelEscolaridade(modelo));
        funcionario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modelo.getIndicadorConclusao()));
    }

    private Documento newPis(ModeloBenPeople modelo) {
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

    private List<Telefone> newTelefones(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        List<Telefone> listaTelefones = new ArrayList<>();

        Telefone tel1 = new Telefone();
        tel1.setNumeroTelefone(modeloEndPeople.getTelefone1());
        tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel1);

        Telefone tel2 = new Telefone();
        tel2.setNumeroTelefone(modeloEndPeople.getTelefone2());
        tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel2.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel2);
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

    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio(ModeloBenPeople modelo) {
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
