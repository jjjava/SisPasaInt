package org.pasa.sispasaint.carga;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
import org.pasa.sispasaint.model.enun.EnunOperadora;
import org.pasa.sispasaint.model.enun.EnunTipoBeneficiario;
import org.pasa.sispasaint.model.enun.EnunTipoDocumento;
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
        // cargaArquivosBenTemp();
        System.gc();
        // cargaArquivosEndTemp();
    }

    @Override
    public void mapearEntidades() {
        Long t = new ImpBenVLITempBeanImpl().contar();
        for (Long k = 1L; k < t; k++) {
            ModeloBenVLI modeloBenVLI = new ImpBenVLITempBeanImpl().obter(k);
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);
            if (modeloBenVLI.getId() != null) {
                if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    System.out.println("func");
                    handlerFuncionario(modeloBenVLI, modeloEndVLI);
                } else {
                    handlerBeneficiario(modeloBenVLI, modeloEndVLI);
                }
            }
        }
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
                log.addRegistro();
                System.out.println("handler");
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
            log.addRegistro();
            funcionario.setEmpresa(empresa);

            //DOCUMENTOS
            funcionario.setCpf(modeloBenVLI.getCpf());
            funcionario.addDocumento(newPis(modeloBenVLI));

            //TELEFONES
            funcionario.setTelefones(newTelefones(modeloEndVLI));
            //ATRIBUTOS 
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

            //ENDERECO
            funcionario.addEndereco(newEndereco(modeloEndVLI));

            //DADOS BANCARIOS
            funcionario.setDadosBancarios(newDadosBancarios(modeloBenVLI));

            //ORIGEM INFORMACOES
            funcionario.setOrigemInformacoes(newOrigemInformacoes());
            
            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio(modeloBenVLI));
            
            //INSERT
            funcionario.setIdUsuario(1L);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            new FuncionarioBeanImpl().cadastar(funcionario);
        }
    }
    
    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio(ModeloBenVLI modeloBenVLI){
        TipoVinculoEmpregaticio tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
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

        Estado estado = new EstadoBeanImpl().obter(modeloEndVLI.getUf());
        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndVLI.getCidade());

        if (estado == null) {
            log.addErrosAssoc();
            return null;
        }
        if (municipio == null) {
            log.addErrosAssoc();
            return null;
        }

        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);

        return endereco;
    }

    private Plano newPlano(ModeloBenVLI modeloBenVLI) {
        Plano plano = new Plano();
        Operadora operadora = new Operadora();
        operadora.setIndAtivo(SisPasaIntCommon.ATIVO);
        operadora.setDataUltAtulizacao(DateUtil.obterDataAtual());
        operadora.setNome(EnunOperadora.AMS.getDescricao());
        plano.setCodPlano(modeloBenVLI.getPlano());
        plano.setOperadora(operadora);
        plano.setDataUltAtulizacao(DateUtil.obterDataAtual());
        return plano;
    }

    private Documento newPis(ModeloBenVLI modeloBenVLI) {
        Documento pis = new Documento();
        pis.setNumero(modeloBenVLI.getPis());
        TipoDocumento tpPIS = new TipoDocumento();
        pis.setNumero(modeloBenVLI.getPis());
        tpPIS.setDescricao(EnunTipoDocumento.PIS.getDescricao());
        pis.setTipoDocumento(tpPIS);
        pis.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
        return pis;
    }

    private List<Telefone> newTelefones(ModeloEndVLI modeloEndVLI) {
        List<Telefone> listaTelefones = new ArrayList<>();
        Telefone tel1 = new Telefone();
        Telefone tel2 = new Telefone();

        tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
        tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
        tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel2.setIndAtivo(SisPasaIntCommon.ATIVO);

        listaTelefones.add(tel1);
        listaTelefones.add(tel2);

        return listaTelefones;
    }
    
    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setDescricao("CARGA");
        return origemInformacoes;
    }

    private void handlerBeneficiario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula(), modeloBenVLI.getCodBeneficiario());
        if (beneficiario == null) {
            log.addRegistro();
            beneficiario = new Beneficiario();
        }

        beneficiario.setMatriculaAMS(modeloBenVLI.getMatricula());
        beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());

        beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
        beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
        beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
        beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
        beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
        beneficiario.setSexo(modeloBenVLI.getSexo());

        NivelEscolaridade nivelEscolaridade = beneficiario.getNivelEscolaridade();
        if (nivelEscolaridade == null) {
            nivelEscolaridade = new NivelEscolaridade();
        }

        nivelEscolaridade.setCodExterno(modeloBenVLI.getGrauEscolaridade());
        beneficiario.setNivelEscolaridade(nivelEscolaridade);
        beneficiario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));

        beneficiario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));
        beneficiario.setDireitoAMSReenbolso(modeloBenVLI.getDireitoAMSCredenciamento());
        beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenVLI.getDataValidadeCredenciado()));
        beneficiario.setDireitoAMSReenbolso(modeloBenVLI.getDireitoAmsReembolso());
        beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenVLI.getDataValidadeReembolso()));
        beneficiario.setDataAtulizacao(DateUtil.toDate(modeloBenVLI.getDataDeAtualizacao()));
        beneficiario.setCodCR(modeloBenVLI.getCodigoCR());
        beneficiario.setOrgaoPessoal(modeloBenVLI.getOrgaoPessoal());
        beneficiario.setFaixaNivel(modeloBenVLI.getFaixaNivel());
        beneficiario.setNucleoAMS(modeloBenVLI.getNucleoDaAms());
        beneficiario.setTipoBeneficiario(EnunTipoBeneficiario.Titular.getDescricao());
        beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
        beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
        beneficiario.setPlanoReciprocidadeCassi(modeloBenVLI.getPlanoDeReciprocidadeCassi());
        beneficiario.setCns(modeloBenVLI.getCodigoNacionalDeSaude());
        beneficiario.setDeclNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
        beneficiario.setDataFimPlanoCassi(DateUtil.toDate(modeloBenVLI.getCassiData()));

        Endereco enderecoBen = beneficiario.getEnderecos().get(0);
        if (enderecoBen == null) {
            enderecoBen = new Endereco();
        }

        Estado estado = new EstadoBeanImpl().obter(modeloEndVLI.getUf());
        if (estado == null) {
            estado = new Estado();
        }
        estado.setId(modeloEndVLI.getUf());

        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndVLI.getCidade());
        if (municipio == null) {
            municipio = new Municipio();
        }
        municipio.setNome(modeloEndVLI.getCidade());
        municipio.setEstado(estado);

        enderecoBen.setLogradouro(modeloEndVLI.getEndereco());
        enderecoBen.setBairro(modeloEndVLI.getBairro());
        enderecoBen.setCep(modeloEndVLI.getCep());
        enderecoBen.setEstado(estado);
        enderecoBen.setMunicipio(municipio);
        enderecoBen.setNumero("");
        enderecoBen.setDataAtulizacao(DateUtil.obterDataAtual());

        beneficiario.addEndereco(enderecoBen);

        //Docs
        beneficiario.setCpf(modeloBenVLI.getCpf());

        Documento pis = null;
        List<Documento> listaDocs = beneficiario.getDocumentos();
        if (listaDocs.isEmpty()) {
            pis = new Documento();
            pis.setNumero(modeloBenVLI.getPis());
            TipoDocumento tpPIS = new TipoDocumento();
            tpPIS.setDescricao(EnunTipoDocumento.PIS.getDescricao());
            pis.setTipoDocumento(tpPIS);
        } else {
            for (Documento d : listaDocs) {
                if (d.getTipoDocumento().getDescricao().equalsIgnoreCase(EnunTipoDocumento.PIS.getDescricao())) {
                    pis = new Documento();
                    pis.setNumero(modeloBenVLI.getPis());
                }
            }
        }
        pis.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
        beneficiario.addDocumento(pis);

        Plano plano = new PlanoBeanImpl().existe(modeloBenVLI.getPlano());
        Operadora operadora = null;
        if (plano == null) {
            plano = new Plano();
            operadora = new Operadora();
            operadora.setIndAtivo(SisPasaIntCommon.ATIVO);
            operadora.setDataUltAtulizacao(DateUtil.obterDataAtual());
            operadora.setNome("AMS");
        }
        plano.setCodPlano(modeloBenVLI.getPlano());
        plano.setOperadora(operadora);
        plano.setDataUltAtulizacao(DateUtil.obterDataAtual());
        beneficiario.setPlano(plano);

        OrigemInformacoes origemInformacoes = beneficiario.getOrigemInformacoes();
        if (origemInformacoes == null) {
            origemInformacoes = new OrigemInformacoes();
        }

        origemInformacoes.setDescricao("CARGA");
        beneficiario.setOrigemInformacoes(origemInformacoes);

        beneficiario.setIdUsuario(1L);
        beneficiario.setIndAtivo(SisPasaIntCommon.ATIVO);
        // beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
        beneficiario.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
        new BeneficiarioBeanImpl().atualizar(beneficiario);
    }
}
