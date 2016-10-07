package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.Beneficiario;
import org.pasa.sispasaint.model.DadosBancarios;
import org.pasa.sispasaint.model.Documento;
import org.pasa.sispasaint.model.Empresa;
import org.pasa.sispasaint.model.Endereco;
import org.pasa.sispasaint.model.Estado;
import org.pasa.sispasaint.model.Funcionario;
import org.pasa.sispasaint.model.Municipio;
import org.pasa.sispasaint.model.Telefone;
import org.pasa.sispasaint.model.enun.TipoBeneficiario;
import org.pasa.sispasaint.model.enun.TipoDocumento;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaVLIBeanImpl implements CargaVLIBean {

    public CargaVLIBeanImpl() {
    }

    @Override
    public void cargaArquivosTemp() {
        cargaArquivosBenTemp();
        cargaArquivosEndTemp();
    }

    @Override
    public void mapearEntidades() {
        Long t = new ImpBenVLITempBeanImpl().contar();
        for (Long k = 1L; k < t; k++) {
            ModeloBenVLI modeloBenVLI = new ImpBenVLITempBeanImpl().obter(k);
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);
            if (modeloBenVLI.getId() != null) {
                if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
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
        impBenVLITempBeanImpl.carregarArquivo();
    }

    private void cargaArquivosEndTemp() {
        ImpEndVLITempBeanImpl impEndVLITempBeanImpl = new ImpEndVLITempBeanImpl();
        impEndVLITempBeanImpl.limparTbTemp();
        impEndVLITempBeanImpl.resetarIdentity();
        impEndVLITempBeanImpl.carregarArquivo();
    }

    private void handlerFuncionario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
        System.out.println(modeloBenVLI.getNomeBeneficiario());
        Funcionario funcionario = new FuncionarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula());
        if (funcionario == null) {
            funcionario = new Funcionario();
        }

        Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula(), modeloBenVLI.getCodBeneficiario());
        if (beneficiario == null) {
            beneficiario = new Beneficiario();
        }

        funcionario.setNome(modeloBenVLI.getNomeBeneficiario());
        funcionario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
        funcionario.setNomeMae(modeloBenVLI.getNomeDaMae());
        funcionario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
        funcionario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
        funcionario.setSexo(StringUtil.parseSexo(modeloBenVLI.getSexo()));
        funcionario.setNivelEscolaridade(StringUtil.parseEscolocaridade(modeloBenVLI.getGrauEscolaridade()));
        funcionario.setIndicadorConclusao(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));

        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setCodigoBanco(modeloBenVLI.getBanco());
        dadosBancarios.setNumeroAgencia(modeloBenVLI.getAgenciaBancaria());
        dadosBancarios.setNumeroConta(modeloBenVLI.getContaCorrente());
        funcionario.setDadosBancarios(dadosBancarios);

        Telefone tel1 = new Telefone();
        tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
        Telefone tel2 = new Telefone();
        tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
        funcionario.addTelefone(tel1);
        funcionario.addTelefone(tel2);

        //Docs
        Documento cpf = null;
        Documento pis = null;
        List<Documento> listaDocs = funcionario.getListaDocumentos();
        if (listaDocs.isEmpty()) {
            cpf = new Documento();
            cpf.setNumeroDocumento(modeloBenVLI.getCpf());
            pis = new Documento();
            pis.setNumeroDocumento(modeloBenVLI.getPis());
            funcionario.addDocumento(cpf);
            funcionario.addDocumento(pis);
        } else {
            for (Documento d : listaDocs) {
                if (d.getTipoDocumento() == TipoDocumento.CPF) {
                    cpf = d;
                }
                if (d.getTipoDocumento() == TipoDocumento.PIS) {
                    pis = d;
                }
            }
            funcionario.addDocumento(cpf);
            funcionario.addDocumento(pis);
        }
        //Endereco
        Estado estado = new EstadoBeanImpl().obter(modeloEndVLI.getUf());
        if (estado == null) {
            estado = new Estado();
        }
        estado.setUf(modeloEndVLI.getUf());

        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndVLI.getCidade());
        if (municipio == null) {
            municipio = new Municipio();
        }
        municipio.setNome(modeloEndVLI.getCidade());
        municipio.setEstado(estado);

        Endereco endereco = funcionario.getEndereco();
        if (endereco == null) {
            endereco = new Endereco();
        }
        endereco.setLogradouro(modeloEndVLI.getEndereco());
        endereco.setBairro(modeloEndVLI.getBairro());
        endereco.setCep(modeloEndVLI.getCep());
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        funcionario.setEndereco(endereco);

        //Funcionario
        Empresa empresa = funcionario.getEmpresa();
        if (empresa == null) {
            System.out.println("null");
            empresa = new Empresa();
        }
        empresa.setCodEmpresa(modeloBenVLI.getEmpresa());
        funcionario.setEmpresa(empresa);

        funcionario.setMatricula(modeloBenVLI.getMatricula());
        funcionario.setVinculo(modeloBenVLI.getVinculo());
        funcionario.setDireitoAbaterIR(StringUtil.parseBoolean(modeloBenVLI.getDireitoAbaterIR()));
        funcionario.setDataAdmissao(DateUtil.toDate(modeloBenVLI.getDataAdmissao()));
        funcionario.setFinanceira(modeloBenVLI.getFinanceira());
        funcionario.setContratoTrabalho(modeloBenVLI.getContratoTrabalho());
        funcionario.setEmpresaAtualizador(modeloBenVLI.getEmpresaAtualizador());
        funcionario.setMatriculaAtulizador(modeloBenVLI.getMatriculaAtulizador());
        funcionario.setCodigoDireitoPasa(modeloBenVLI.getCodigoDireitoPasa());
        funcionario.setMatriculaPasa(modeloBenVLI.getMatriculaPasa());
        funcionario.setEmpresaOrigem(modeloBenVLI.getEmpresaOrigem());
        funcionario.setMatriculaOrigem(modeloBenVLI.getMatriculaOrigem());
        funcionario.setEmpresaPeople(modeloBenVLI.getEmpresaPeople());
        funcionario.setMatriculaPeople(modeloBenVLI.getMatriculaPeople());
        funcionario.setUnidadeDeControle(modeloBenVLI.getUnidadeDeControle());
        funcionario.setCentroDeCusto(modeloBenVLI.getCentroDeCusto());
        funcionario.setBranco(modeloBenVLI.getBranco());
        funcionario.setCodigoFilialVLI(modeloBenVLI.getCodigoFilialVLI());

        funcionario.setStatus(SisPasaIntCommon.ATIVO);
        funcionario.setSituacao(SisPasaIntCommon.ATUALIZADO);
        new FuncionarioBeanImpl().atualizar(funcionario);
        
        //###
        //###
        //###
        
        FuncionarioBeanImpl funcionarioBeanImpl = new  FuncionarioBeanImpl();
        Funcionario funcBeneficiario = funcionarioBeanImpl.obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula());
        
        beneficiario.setMatricula(modeloBenVLI.getMatricula());
        beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());

        beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
        beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
        beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
        beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
        beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
        beneficiario.setSexo(StringUtil.parseSexo(modeloBenVLI.getSexo()));
        beneficiario.setNivelEscolaridade(StringUtil.parseEscolocaridade(modeloBenVLI.getGrauEscolaridade()));
        beneficiario.setIndicadorConclusao(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));
        beneficiario.setDireitoAMSCredenciamento(StringUtil.parseBoolean(modeloBenVLI.getDireitoAMSCredenciamento()));
        beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenVLI.getDataValidadeCredenciado()));
        beneficiario.setDireitoAmsReembolso(StringUtil.parseBoolean(modeloBenVLI.getDireitoAmsReembolso()));
        beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenVLI.getDataValidadeReembolso()));
        beneficiario.setDataDeAtualizacao(DateUtil.toDate(modeloBenVLI.getDataDeAtualizacao()));
        beneficiario.setCodigoCR(modeloBenVLI.getCodigoCR());
        beneficiario.setOrgaoPessoal(modeloBenVLI.getOrgaoPessoal());
        beneficiario.setFaixaNivel(modeloBenVLI.getFaixaNivel());
        beneficiario.setNucleoDaAms(modeloBenVLI.getNucleoDaAms());
        beneficiario.setTipoBeneficiario(TipoBeneficiario.Titular);
        beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
        beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
        beneficiario.setPlanoDeReciprocidadeCassi(StringUtil.parseBoolean(modeloBenVLI.getPlanoDeReciprocidadeCassi()));
        beneficiario.setCodigoNacionalDeSaude(modeloBenVLI.getCodigoNacionalDeSaude());
        beneficiario.setDeclaracaoNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
        beneficiario.setCassiData(modeloBenVLI.getCassiData());
        beneficiario.setPlano(modeloBenVLI.getPlano());

       
        beneficiario.setEndereco(funcBeneficiario.getEndereco());
        beneficiario.setListaDocumentos(funcBeneficiario.getListaDocumentos());
        beneficiario.setDadosBancarios(funcBeneficiario.getDadosBancarios());

        beneficiario.setStatus(SisPasaIntCommon.ATIVO);
        beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
        new BeneficiarioBeanImpl().atualizar(beneficiario);
    }

    private void handlerBeneficiario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
//        Beneficiario beneficiario = new Beneficiario();
//
//        beneficiario.setMatricula(modeloBenVLI.getMatricula());
//        beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());
//        
//        beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
//        beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
//        beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
//        beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
//        beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
//        beneficiario.setSexo(StringUtil.parseSexo(modeloBenVLI.getSexo()));
//        beneficiario.setNivelEscolaridade(StringUtil.parseEscolocaridade(modeloBenVLI.getGrauEscolaridade()));
//        beneficiario.setIndicadorConclusao(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));
//
//        beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());
//        beneficiario.setDireitoAMSCredenciamento(StringUtil.parseBoolean(modeloBenVLI.getDireitoAMSCredenciamento()));
//        beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenVLI.getDataValidadeCredenciado()));
//        beneficiario.setDireitoAmsReembolso(StringUtil.parseBoolean(modeloBenVLI.getDireitoAmsReembolso()));
//        beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenVLI.getDataValidadeReembolso()));
//        beneficiario.setDataDeAtualizacao(DateUtil.toDate(modeloBenVLI.getDataDeAtualizacao()));
//        beneficiario.setCodigoCR(modeloBenVLI.getCodigoCR());
//        beneficiario.setOrgaoPessoal(modeloBenVLI.getOrgaoPessoal());
//        beneficiario.setFaixaNivel(modeloBenVLI.getFaixaNivel());
//        beneficiario.setNucleoDaAms(modeloBenVLI.getNucleoDaAms());
//        beneficiario.setTipoBeneficiario(TipoBeneficiario.Titular);
//        beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
//        beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
//        beneficiario.setPlanoDeReciprocidadeCassi(StringUtil.parseBoolean(modeloBenVLI.getPlanoDeReciprocidadeCassi()));
//        beneficiario.setCodigoNacionalDeSaude(modeloBenVLI.getCodigoNacionalDeSaude());
//        beneficiario.setDeclaracaoNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
//        beneficiario.setCassiData(modeloBenVLI.getCassiData());
//
//        //Docs
//        DadosBancarios dadosBancarios = new DadosBancarios();
//        dadosBancarios.setCodigoBanco(modeloBenVLI.getBanco());
//        dadosBancarios.setNumeroAgencia(modeloBenVLI.getAgenciaBancaria());
//        dadosBancarios.setNumeroConta(modeloBenVLI.getContaCorrente());
//        Documento cpf = new Documento();
//        cpf.setNumeroDocumento(modeloBenVLI.getCpf());
//        Documento pis = new Documento();
//        pis.setNumeroDocumento(modeloBenVLI.getPis());
//        beneficiario.addDocumento(cpf);
//        beneficiario.addDocumento(pis);
//        beneficiario.setDadosBancarios(dadosBancarios);
//
//        new BeneficiarioBeanImpl().atualizar(beneficiario);
//
//        Estado estado = new Estado();
//        estado.setUf(modeloEndVLI.getUf());
//        Municipio municipio = new Municipio();
//        municipio.setNome(modeloEndVLI.getCidade());
//        municipio.setEstado(estado);
//        Endereco endereco = new Endereco();
//        endereco.setLogradouro(modeloEndVLI.getEndereco());
//        endereco.setBairro(modeloEndVLI.getBairro());
//        endereco.setCep(modeloEndVLI.getCep());
//        endereco.setEstado(estado);
//        endereco.setMunicipio(municipio);
//        beneficiario.setEndereco(endereco);
//
//        GrauParentesco grauParentesco = new GrauParentesco();
//        grauParentesco.setGrauParentesco(modeloBenVLI.getGrauParentesco());
//        beneficiario.setGrauParentesco(grauParentesco);
//
//        Telefone tel1 = new Telefone();
//        tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
//        Telefone tel2 = new Telefone();
//        tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
//        beneficiario.addTelefone(tel1);
//        beneficiario.addTelefone(tel2);
//
//        beneficiario.setStatus(SisPasaIntCommon.ATIVO);
//        new BeneficiarioBeanImpl().atualizar(beneficiario);
    }
}
