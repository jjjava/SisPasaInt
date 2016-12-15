package org.pasa.sispasaint.carga;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.pasa.sispasa.core.enumeration.*;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.Operadora;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.BeneficiarioBeanImpl;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenVLITempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndVLITempBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.bean.impl.MunicipioBeanImpl;
import org.pasa.sispasaint.bean.impl.PlanoBeanImpl;
import org.pasa.sispasaint.model.enun.EnunNivelEscolaridade;
import org.pasa.sispasaint.model.enun.EnunOperadora;
import org.pasa.sispasaint.model.enun.EnunTipoBeneficiario;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaVLIBeanImpl implements CargaVLIBean {

    private Long id;
    private Log log;
    private LogBeanImpl logBeanImpl;

    public CargaVLIBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        logBeanImpl = new LogBeanImpl();
    }

    @Override
    public void cargaArquivosTemp() {
        System.out.println("ini temp");
      //  cargaArquivosBenTemp();
        System.gc();
       /// cargaArquivosEndTemp();
        System.out.println("end temp");
    }

    @Override
    public void mapearEntidades() {
        Long t = new ImpBenVLITempBeanImpl().contar();

        ImpBenVLITempBeanImpl benBean = new ImpBenVLITempBeanImpl();
        ImpEndVLITempBeanImpl endBean = new ImpEndVLITempBeanImpl();

        for (Long k = 1L; k < t; k++) {
            ModeloBenVLI modeloBenVLI = benBean.obter(k);
            ModeloEndVLI modeloEndVLI = endBean.obterPorMatricula(modeloBenVLI);
            if (modeloBenVLI.getId() != null) {
                if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    handlerFuncionario(modeloBenVLI, modeloEndVLI);
                } else {
                   // handlerBeneficiario(modeloBenVLI, modeloEndVLI);
                }
            }
        }
        logBeanImpl.cadastrar(log);
    }

    private void cargaArquivosBenTemp() {
        ImpBenVLITempBeanImpl impBenVLITempBeanImpl = new ImpBenVLITempBeanImpl();
        impBenVLITempBeanImpl.limparTbTemp();
        impBenVLITempBeanImpl.resetarIdentity();
        impBenVLITempBeanImpl.carregarArquivo(id);
    }

    private void cargaArquivosEndTemp() {
        ImpEndVLITempBeanImpl impEndVLITempBeanImpl = new ImpEndVLITempBeanImpl();
        impEndVLITempBeanImpl.limparTbTemp();
        impEndVLITempBeanImpl.resetarIdentity();
        impEndVLITempBeanImpl.carregarArquivo(id);
    }

    private void handlerFuncionario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        try {
            Funcionario funcionario = new FuncionarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula());
            if (funcionario == null) {
                newFuncionario(modeloBenVLI, modeloEndVLI);
            } else {

            }
        } catch (Exception e) {
            System.err.println(e);
            System.err.println(e.getMessage());
        }
    }

    private void newFuncionario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        Funcionario funcionario = new Funcionario();
        Empresa empresa = new EmpresaBeanImpl().existe(modeloBenVLI.getEmpresa());
        if (empresa == null) {
            log.addErrosAssoc();
        } else {
            funcionario.setEmpresa(empresa);

            //ENDERECO
            if (newEndereco(modeloEndVLI) != null) {
                System.out.println("func");
                funcionario.addEndereco(newEndereco(modeloEndVLI));
            } else {
                System.out.println("sem endereco");
                log.addErrosAssoc();
                return;
            }
            //DOCUMENTOS
            funcionario.setCpf(modeloBenVLI.getCpf());
            funcionario.addDocumento(newPis(modeloBenVLI));

            //TELEFONES
            funcionario.setTelefones(newTelefones(modeloEndVLI));
            //ATRIBUTOS 
            funcionario.setNome(modeloBenVLI.getNomeBeneficiario());
            funcionario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
            funcionario.setNomeMae(modeloBenVLI.getNomeDaMae());
            funcionario.setSexo(modeloBenVLI.getSexo());
            funcionario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
            funcionario.setDireitoAbaterIR(modeloBenVLI.getDireitoAbaterIR());
            funcionario.setDataAdmissao(DateUtil.toDate(modeloBenVLI.getDataAdmissao()));
            funcionario.setFinanceira(modeloBenVLI.getFinanceira());
            funcionario.setContratoTrabalho(modeloBenVLI.getContratoTrabalho());
            funcionario.setEmpresaAtualizadora(modeloBenVLI.getEmpresaAtualizador());
            funcionario.setMatriculaAtualizadora(modeloBenVLI.getMatriculaAtulizador());
            funcionario.setCodDireitoPasa(modeloBenVLI.getCodigoDireitoPasa());
            funcionario.setMatriculaPasa(modeloBenVLI.getMatriculaPasa());
            funcionario.setMatriculaOrigem(modeloBenVLI.getMatriculaOrigem());
            funcionario.setMatriculaPasa(modeloBenVLI.getMatricula());
            funcionario.setUnidadeControle(modeloBenVLI.getUnidadeDeControle());
            funcionario.setCentroCusto(modeloBenVLI.getCentroDeCusto());
            funcionario.setNivelEscolaridade(newNivelEscolaridade(modeloBenVLI));
            funcionario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));

            //DADOS BANCARIOS
            funcionario.setDadosBancarios(new DadosBancarios());
            funcionario.setDadosBancarios(newDadosBancarios(modeloBenVLI));

            //ORIGEM INFORMACOES
            funcionario.setOrigemInformacoes(newOrigemInformacoes());

            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio(modeloBenVLI));

            //INSERT
            funcionario.setIdUsuario(1L);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            new FuncionarioBeanImpl().atualizar(funcionario);
            log.addAssocIncluidos();
            
            List<ModeloBenVLI> modeloBenVLIs = new ImpBenVLITempBeanImpl().listar(modeloBenVLI.getEmpresa(),modeloBenVLI.getMatricula());
            List<ModeloEndVLI> modeloEndVLIs = new ImpEndVLITempBeanImpl().list(modeloBenVLI.getEmpresa(),modeloBenVLI.getMatricula());
            
            
            
            newBeneficiario(modeloBenVLI, modeloEndVLI);
        }
    }

    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio(ModeloBenVLI modeloBenVLI) {
        TipoVinculoEmpregaticio tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
        tipoVinculoEmpregaticio.setId(EnumTipoVinculoEmpregaticio.EmpregadoAtivo.getIndice());
        tipoVinculoEmpregaticio.setCodExterno(modeloBenVLI.getVinculo());
        return tipoVinculoEmpregaticio;
    }

    private DadosBancarios newDadosBancarios(ModeloBenVLI modeloBenVLI) {
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setCodBanco(modeloBenVLI.getBanco());
        dadosBancarios.setAgencia(modeloBenVLI.getAgenciaBancaria());
        dadosBancarios.setConta(modeloBenVLI.getContaCorrente());
        dadosBancarios.setTipoConta(SisPasaIntCommon.CONTACORRENTE);
        dadosBancarios.setIndAtivo(SisPasaIntCommon.ATIVO);
        dadosBancarios.setDataAtulizacao(new Date());
        dadosBancarios.setIdUsuario(1L);
        return dadosBancarios;
    }

    private Endereco newEndereco(ModeloEndVLI modeloEndVLI) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(modeloEndVLI.getEndereco());
        endereco.setBairro(modeloEndVLI.getBairro());
        endereco.setCep(modeloEndVLI.getCep());
        endereco.setIdUsuario(1L);
        endereco.setIndAtivo(SisPasaIntCommon.ATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());

        Estado estado = new EstadoBeanImpl().obter(modeloEndVLI.getUf());
        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndVLI.getCidade());

        if (municipio == null) {
            log.addErrosAssoc();
            return null;
        }
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        return endereco;
    }

    private NivelEscolaridade newNivelEscolaridade(ModeloBenVLI modeloBenVLI) {
        NivelEscolaridade nivelEscolaridade = new NivelEscolaridade();
        nivelEscolaridade.setId(Long.parseLong(modeloBenVLI.getGrauEscolaridade()));
        return nivelEscolaridade;
    }

    private Plano newPlano(ModeloBenVLI modeloBenVLI) {
        Plano plano = new Plano();
        Operadora operadora = new Operadora();
        operadora.setIndAtivo(SisPasaIntCommon.ATIVO);
        operadora.setDataUltAtulizacao(DateUtil.obterDataAtual());
        operadora.setNome(EnunOperadora.AMS.getDescricao());
        plano.setCodPlano(modeloBenVLI.getPlano());
        plano.setOperadora(operadora);
        plano.setIdUsuario(1L);
        plano.setDataUltAtulizacao(DateUtil.obterDataAtual());
        return plano;
    }

    private Documento newPis(ModeloBenVLI modeloBenVLI) {
        Documento pis = new Documento();
        TipoDocumento tpPIS = new TipoDocumento();
        pis.setNumero(modeloBenVLI.getPis());
        pis.setNumero(modeloBenVLI.getPis());
        tpPIS.setId(EnumTipoDocumento.PIS_PASEP.getIndice());
        tpPIS.setDescricao(EnumTipoDocumento.PIS_PASEP.getDescricao());
        pis.setTipoDocumento(tpPIS);
        pis.setIdUsuario(1L);
        pis.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        return pis;
    }

    private List<Telefone> newTelefones(ModeloEndVLI modeloEndVLI) {
        List<Telefone> listaTelefones = new ArrayList<>();
        Telefone tel1 = new Telefone();
        Telefone tel2 = new Telefone();
        tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
        tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
        tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel1.setIdUsuario(1L);
        tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel2.setIdUsuario(1L);
        listaTelefones.add(tel1);
        listaTelefones.add(tel2);
        return listaTelefones;
    }

    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setId(EnumOrigemInformacoes.CARGA.getIndice());
        origemInformacoes.setDescricao(EnumOrigemInformacoes.CARGA.getDescricao());
        return origemInformacoes;
    }

    private void handlerBeneficiario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula(), modeloBenVLI.getCodBeneficiario());
        if (beneficiario == null) {
            newBeneficiario(modeloBenVLI, modeloEndVLI);
        } else {
        }
    }

    private void newBeneficiario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        Beneficiario beneficiario = new Beneficiario();
        Empresa empresa = new EmpresaBeanImpl().existe(modeloBenVLI.getEmpresa());
        if (empresa == null) {
            log.addErrosAssoc();
        } else {
            //ENDERECO
            if (newEndereco(modeloEndVLI) != null) {
                System.out.println("func");
                beneficiario.addEndereco(newEndereco(modeloEndVLI));
            } else {
                System.out.println("sem endereco");
                log.addErrosAssoc();
                return;
            }
            //DOCUMENTOS
            beneficiario.setCpf(modeloBenVLI.getCpf());
            beneficiario.addDocumento(newPis(modeloBenVLI));

            //TELEFONES
            beneficiario.setTelefones(newTelefones(modeloEndVLI));

            //Atributos
            beneficiario.setMatriculaAMS(modeloBenVLI.getMatricula());
            beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());
            beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
            beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
            beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
            beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
            beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
            beneficiario.setSexo(modeloBenVLI.getSexo());
            beneficiario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));
            beneficiario.setDireitoAMSReenbolso(modeloBenVLI.getDireitoAMSCredenciamento());
            beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenVLI.getDataValidadeCredenciado()));
            beneficiario.setDireitoAMSReenbolso(modeloBenVLI.getDireitoAmsReembolso());
            beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenVLI.getDataValidadeReembolso()));
            beneficiario.setDataUltimaAtulizacao(DateUtil.toDate(modeloBenVLI.getDataDeAtualizacao()));
            beneficiario.setCodCR(modeloBenVLI.getCodigoCR());
            beneficiario.setOrgaoPessoal(modeloBenVLI.getOrgaoPessoal());
            beneficiario.setFaixaNivel(modeloBenVLI.getFaixaNivel());
            beneficiario.setNucleoAMS(modeloBenVLI.getNucleoDaAms());

            if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(EnunTipoBeneficiario.Titular.getDescricao())) {
                beneficiario.setTipoBeneficiario(EnunTipoBeneficiario.Titular.getDescricao());
            } else {
                beneficiario.setTipoBeneficiario(EnunTipoBeneficiario.Dependente.getDescricao());
            }

            beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
            beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
            beneficiario.setPlanoReciprocidadeCassi(modeloBenVLI.getPlanoDeReciprocidadeCassi());
            beneficiario.setCns(modeloBenVLI.getCodigoNacionalDeSaude());
            beneficiario.setDeclNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
            beneficiario.setDataFimPlanoCassi(DateUtil.toDate(modeloBenVLI.getCassiData()));

            //PLANO
            System.out.println(modeloBenVLI);
            beneficiario.setPlano(newPlano(modeloBenVLI));

            beneficiario.setIdUsuario(1L);
            beneficiario.setIndAtivo(SisPasaIntCommon.ATIVO);
            // beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
            beneficiario.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
            new BeneficiarioBeanImpl().cadastar(beneficiario);
        }
    }
}
