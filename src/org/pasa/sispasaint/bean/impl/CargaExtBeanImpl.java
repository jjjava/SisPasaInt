package org.pasa.sispasaint.bean.impl;

import java.util.Date;
import java.util.List;
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
import org.pasa.sispasaint.bean.CargaExtBean;
import org.pasa.sispasaint.model.enun.EnunTipoBeneficiario;
import org.pasa.sispasaint.model.enun.EnunTipoDocumento;
import org.pasa.sispasaint.model.intg.ModeloBenExt;
import org.pasa.sispasaint.model.intg.ModeloEndExt;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaExtBeanImpl implements CargaExtBean {

    public CargaExtBeanImpl() {
    }

    @Override
    public void cargaArquivosTemp() {
        cargaArquivosBenTemp();
        cargaArquivosEndTemp();
    }

    @Override
    public void mapearEntidades() {

        Long t = new ImpBenExtTempBeanImpl().contar();
        for (Long k = 1L; k < t; k++) {
            ModeloBenExt modeloBenExt = new ImpBenExtTempBeanImpl().obter(k);
            ModeloEndExt modeloEndExt = new ImpEndExtTempBeanImpl().obterPorMatricula(modeloBenExt);
            if (modeloBenExt.getId() != null) {
                if (modeloBenExt.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    handlerFuncionario(modeloBenExt, modeloEndExt);
                } else {
                    handlerBeneficiario(modeloBenExt, modeloEndExt);
                }
            }
        }
    }

    private void cargaArquivosBenTemp() {
        ImpBenExtTempBeanImpl impBenExtTempBeanImpl = new ImpBenExtTempBeanImpl();
        impBenExtTempBeanImpl.limparTbTemp();
        impBenExtTempBeanImpl.resetarIdentity();
        impBenExtTempBeanImpl.carregarArquivo();
    }

    private void cargaArquivosEndTemp() {
        ImpEndExtTempBeanImpl impEndExtTempBeanImpl = new ImpEndExtTempBeanImpl();
        impEndExtTempBeanImpl.limparTbTemp();
        impEndExtTempBeanImpl.resetarIdentity();
        impEndExtTempBeanImpl.carregarArquivo();
    }

    private void handlerFuncionario(ModeloBenExt modeloBenExt, ModeloEndExt modeloEndExt) {
        try {
            Funcionario funcionario = new FuncionarioBeanImpl().obter(modeloBenExt.getEmpresa(), modeloBenExt.getMatricula());
            if (funcionario == null) {
                funcionario = new Funcionario();
            }

            Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenExt.getEmpresa(), modeloBenExt.getMatricula(), modeloBenExt.getCodBeneficiario());
            if (beneficiario == null) {
                beneficiario = new Beneficiario();
            }

            funcionario.setNome(modeloBenExt.getNomeBeneficiario());
            funcionario.setNomeAbreviado(modeloBenExt.getNomeBeneficiarioAbreviado());
            funcionario.setNomeMae(modeloBenExt.getNomeDaMae());
            funcionario.setDataNascimento(DateUtil.toDate(modeloBenExt.getDataNascimento()));
            funcionario.setDataObito(DateUtil.toDate(modeloBenExt.getDataFalecimento()));
            funcionario.setSexo(modeloBenExt.getSexo());

            NivelEscolaridade nivelEscolaridade = funcionario.getNivelEscolaridade();
            if (nivelEscolaridade == null) {
                nivelEscolaridade = new NivelEscolaridade();
            }

            nivelEscolaridade.setCodExterno(modeloBenExt.getGrauEscolaridade());
            funcionario.setNivelEscolaridade(nivelEscolaridade);
            funcionario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenExt.getIndicadorConclusao()));

            DadosBancarios dadosBancarios = funcionario.getDadosBancarios();
            if (dadosBancarios == null) {
                dadosBancarios = new DadosBancarios();
            }
            dadosBancarios.setCodBanco(modeloBenExt.getBanco());
            dadosBancarios.setAgencia(modeloBenExt.getAgenciaBancaria());
            dadosBancarios.setConta(modeloBenExt.getContaCorrente());
            dadosBancarios.setTipoConta(SisPasaIntCommon.CONTACORRENTE);
            dadosBancarios.setIndAtivo(SisPasaIntCommon.ATIVO);
            dadosBancarios.setDataAtulizacao(new Date());
            dadosBancarios.setIdUsuario(1L);
            funcionario.setDadosBancarios(dadosBancarios);

            Telefone tel1 = null;
            Telefone tel2 = null;
            List<Telefone> listaTelefones = funcionario.getTelefones();
            if (listaTelefones.isEmpty()) {
                tel1 = new Telefone();
                tel2 = new Telefone();
                tel1.setNumeroTelefone(modeloEndExt.getTelefone1());
                tel2.setNumeroTelefone(modeloEndExt.getTelefone2());
                tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
                tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
                funcionario.addTelefone(tel1);
                funcionario.addTelefone(tel2);
            } else {
                tel1 = new Telefone();
                tel2 = new Telefone();
                tel1.setNumeroTelefone(modeloEndExt.getTelefone1());
                tel2.setNumeroTelefone(modeloEndExt.getTelefone2());
                tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
                tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
                listaTelefones.clear();
                funcionario.addTelefone(tel1);
                funcionario.addTelefone(tel2);
                funcionario.setTelefones(listaTelefones);
            }

            //Docs
            funcionario.setCpf(modeloBenExt.getCpf());

            Documento pis = null;
            List<Documento> listaDocs = funcionario.getDocumentos();
            if (listaDocs.isEmpty()) {
                pis = new Documento();
                pis.setNumero(modeloBenExt.getPis());
                TipoDocumento tpPIS = new TipoDocumento();
                tpPIS.setDescricao(EnunTipoDocumento.PIS.getDescricao());
                pis.setTipoDocumento(tpPIS);
            } else {
                for (Documento d : listaDocs) {
                    if (d.getTipoDocumento().getDescricao().equalsIgnoreCase(EnunTipoDocumento.PIS.getDescricao())) {
                        pis = new Documento();
                        pis.setNumero(modeloBenExt.getPis());
                    }
                }
            }
            pis.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
            funcionario.addDocumento(pis);
            //Endereco
            Estado estado = new EstadoBeanImpl().obter(modeloEndExt.getUf());
            if (estado == null) {
                estado = new Estado();
            }
            estado.setId(modeloEndExt.getUf());

            Municipio municipio = new MunicipioBeanImpl().existe(modeloEndExt.getCidade());
            if (municipio == null) {
                municipio = new Municipio();
            }
            municipio.setNome(modeloEndExt.getCidade());
            municipio.setEstado(estado);

            Endereco endereco = null;
            List<Endereco> enderecos = funcionario.getEnderecos();
            if (enderecos.isEmpty()) {
                endereco = new Endereco();
                endereco.setLogradouro(modeloEndExt.getEndereco());
                endereco.setBairro(modeloEndExt.getBairro());
                endereco.setCep(modeloEndExt.getCep());
                endereco.setEstado(estado);
                endereco.setMunicipio(municipio);
                endereco.setNumero("");
                endereco.setDataAtulizacao(DateUtil.obterDataAtual());
                funcionario.addEndereco(endereco);
            } else {
                enderecos.get(0).setLogradouro(modeloEndExt.getEndereco());
                enderecos.get(0).setBairro(modeloEndExt.getBairro());
                enderecos.get(0).setCep(modeloEndExt.getCep());
                enderecos.get(0).setEstado(estado);
                enderecos.get(0).setMunicipio(municipio);
                enderecos.get(0).setNumero("");
                enderecos.get(0).setDataAtulizacao(DateUtil.obterDataAtual());

                funcionario.addEndereco(enderecos.get(0));
            }

            //Funcionario
            Empresa empresa = new EmpresaBeanImpl().existe(modeloBenExt.getEmpresa());
            if (empresa == null) {
                empresa = new Empresa();
            }
            empresa.setCodEmpresaVale(modeloBenExt.getEmpresa());
            empresa.setIndAtivo(SisPasaIntCommon.ATIVO);
            empresa.setDataAtulizacao(new Date());
            empresa.setIdUsuario(1L);
            funcionario.setEmpresa(empresa);
            funcionario.setMatriculaOrigem(modeloBenExt.getMatricula());

            TipoVinculoEmpregaticio tipoVinculoEmpregaticio = funcionario.getTipoVinculoEmpregaticio();
            if (tipoVinculoEmpregaticio == null) {
                tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
            }
            tipoVinculoEmpregaticio.setCodExterno(modeloBenExt.getVinculo());
            funcionario.setTipoVinculoEmpregaticio(tipoVinculoEmpregaticio);

            funcionario.setDireitoAbaterIR(modeloBenExt.getDireitoAbaterIR());
            funcionario.setDataAdimissao(DateUtil.toDate(modeloBenExt.getDataAdmissao()));
            funcionario.setFinanceira(modeloBenExt.getFinanceira());
            funcionario.setContratoTrabalho(modeloBenExt.getContratoTrabalho());
            funcionario.setEmpresaAtualizadora(modeloBenExt.getEmpresaAtualizador());
            funcionario.setMatriculaAtualizadora(modeloBenExt.getMatriculaAtulizador());
            funcionario.setCodDireitoPasa(modeloBenExt.getCodigoDireitoPasa());
            funcionario.setMatriculaPasa(modeloBenExt.getMatriculaPasa());

            funcionario.setMatriculaOrigem(modeloBenExt.getMatriculaOrigem());
            //   funcionario.setEmpresaPeople(modeloBenExt.getEmpresaPeople());
            //    funcionario.setMatriculaPeople(modeloBenExt.getMatriculaPeople());
            funcionario.setUnidadeControle(modeloBenExt.getUnidadeDeControle());
            funcionario.setCentroCusto(modeloBenExt.getCentroDeCusto());
            //  funcionario.setBranco(modeloBenExt.getBranco());
            //  funcionario.setCodigoFilialVLI(modeloBenExt.getCodigoFilialVLI());

            OrigemInformacoes origemInformacoes = funcionario.getOrigemInformacoes();
            if (origemInformacoes == null) {
                origemInformacoes = new OrigemInformacoes();
            }

            origemInformacoes.setDescricao("CARGA");
            funcionario.setOrigemInformacoes(origemInformacoes);

            funcionario.setIdUsuario(1L);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            // funcionario.setSituacao(SisPasaIntCommon.ATUALIZADO);
            funcionario.setDataUltAtulizacao(DateUtil.obterDataAtual());
            new FuncionarioBeanImpl().atualizar(funcionario);

//------------------------------------------------------------------------------
            Funcionario funcBeneficiario = new FuncionarioBeanImpl().obter(modeloBenExt.getEmpresa(), modeloBenExt.getMatricula());
            beneficiario.setMatriculaAMS(modeloBenExt.getMatricula());
            beneficiario.setCodBeneficiario(modeloBenExt.getCodBeneficiario());

            beneficiario.setNome(modeloBenExt.getNomeBeneficiario());
            beneficiario.setNomeAbreviado(modeloBenExt.getNomeBeneficiarioAbreviado());
            beneficiario.setNomeMae(modeloBenExt.getNomeDaMae());
            beneficiario.setDataNascimento(DateUtil.toDate(modeloBenExt.getDataNascimento()));
            beneficiario.setDataObito(DateUtil.toDate(modeloBenExt.getDataFalecimento()));
            beneficiario.setSexo(modeloBenExt.getSexo());
            beneficiario.setNivelEscolaridade(funcBeneficiario.getNivelEscolaridade());
            beneficiario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenExt.getIndicadorConclusao()));
            beneficiario.setDireitoAMSReenbolso(modeloBenExt.getDireitoAMSCredenciamento());
            beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenExt.getDataValidadeCredenciado()));
            beneficiario.setDireitoAMSReenbolso(modeloBenExt.getDireitoAmsReembolso());
            beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenExt.getDataValidadeReembolso()));
            beneficiario.setDataAtulizacao(DateUtil.toDate(modeloBenExt.getDataDeAtualizacao()));
            beneficiario.setCodCR(modeloBenExt.getCodigoCR());
            beneficiario.setOrgaoPessoal(modeloBenExt.getOrgaoPessoal());
            beneficiario.setFaixaNivel(modeloBenExt.getFaixaNivel());
            beneficiario.setNucleoAMS(modeloBenExt.getNucleoDaAms());
            beneficiario.setTipoBenneficiario(EnunTipoBeneficiario.Titular.getDescricao());
            beneficiario.setMatriculaParticipante(modeloBenExt.getMatriculaParticipante());
            beneficiario.setMatriculaRepresentanteLegal(modeloBenExt.getMatriculaRepresentanteLegal());
            beneficiario.setPlanoReciprocidadeCassi(modeloBenExt.getPlanoDeReciprocidadeCassi());
            beneficiario.setCns(modeloBenExt.getCodigoNacionalDeSaude());
            beneficiario.setDeclNascidoVivo(modeloBenExt.getDeclaracaoNascidoVivo());
            beneficiario.setDataFimPlanoCassi(DateUtil.toDate(modeloBenExt.getCassiData()));

            beneficiario.setEndereco(funcBeneficiario.getEnderecos());
            beneficiario.setDocumentos(funcBeneficiario.getDocumentos());

            Plano plano = new PlanoBeanImpl().existe(modeloBenExt.getPlano());
            Operadora operadora = null;
            if (plano == null) {
                plano = new Plano();
                operadora = new Operadora();
                operadora.setIndAtivo(SisPasaIntCommon.ATIVO);
                operadora.setDataUltAtulizacao(DateUtil.obterDataAtual());
                operadora.setNome("AMS");
            }
            plano.setCodPlano(modeloBenExt.getPlano());
            plano.setOperadora(operadora);
            beneficiario.setPlano(plano);

            origemInformacoes.setDescricao("CARGA");
            beneficiario.setOrigemInformacoes(origemInformacoes);

            beneficiario.setIdUsuario(1L);
            beneficiario.setIndAtivo(SisPasaIntCommon.ATIVO);
            // beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
            beneficiario.setDataUltAtulizacao(DateUtil.obterDataAtual());
            new BeneficiarioBeanImpl().atualizar(beneficiario);
        } catch (Exception e) {
            System.err.println(e);
            System.err.println(e.getMessage());
        }
    }

    private void handlerBeneficiario(ModeloBenExt modeloBenExt, ModeloEndExt modeloEndExt) {
//        Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenExt.getEmpresa(), modeloBenExt.getMatricula(), modeloBenExt.getCodBeneficiario());
//        if (beneficiario == null) {
//            beneficiario = new Beneficiario();
//        }
//
//        beneficiario.setMatricula(modeloBenExt.getMatricula());
//        beneficiario.setCodBeneficiario(modeloBenExt.getCodBeneficiario());
//        beneficiario.setNome(modeloBenExt.getNomeBeneficiario());
//        beneficiario.setNomeAbreviado(modeloBenExt.getNomeBeneficiarioAbreviado());
//        beneficiario.setNomeMae(modeloBenExt.getNomeDaMae());
//        beneficiario.setDataNascimento(DateUtil.toDate(modeloBenExt.getDataNascimento()));
//        beneficiario.setDataObito(DateUtil.toDate(modeloBenExt.getDataFalecimento()));
//        beneficiario.setSexo(StringUtil.parseSexo(modeloBenExt.getSexo()));
//        beneficiario.setNivelEscolaridade(StringUtil.parseEscolocaridade(modeloBenExt.getGrauEscolaridade()));
//        beneficiario.setIndicadorConclusao(StringUtil.parserIndicadorConclusao(modeloBenExt.getIndicadorConclusao()));
//        beneficiario.setCodBeneficiario(modeloBenExt.getCodBeneficiario());
//        beneficiario.setDireitoAMSCredenciamento(StringUtil.parseBoolean(modeloBenExt.getDireitoAMSCredenciamento()));
//        beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenExt.getDataValidadeCredenciado()));
//        beneficiario.setDireitoAmsReembolso(StringUtil.parseBoolean(modeloBenExt.getDireitoAmsReembolso()));
//        beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenExt.getDataValidadeReembolso()));
//        beneficiario.setDataDeAtualizacao(DateUtil.toDate(modeloBenExt.getDataDeAtualizacao()));
//        beneficiario.setCodigoCR(modeloBenExt.getCodigoCR());
//        beneficiario.setOrgaoPessoal(modeloBenExt.getOrgaoPessoal());
//        beneficiario.setFaixaNivel(modeloBenExt.getFaixaNivel());
//        beneficiario.setNucleoDaAms(modeloBenExt.getNucleoDaAms());
//        beneficiario.setTipoBeneficiario(EnunTipoBeneficiario.Dependente);
//        beneficiario.setMatriculaParticipante(modeloBenExt.getMatriculaParticipante());
//        beneficiario.setMatriculaRepresentanteLegal(modeloBenExt.getMatriculaRepresentanteLegal());
//        beneficiario.setPlanoDeReciprocidadeCassi(StringUtil.parseBoolean(modeloBenExt.getPlanoDeReciprocidadeCassi()));
//        beneficiario.setCodigoNacionalDeSaude(modeloBenExt.getCodigoNacionalDeSaude());
//        beneficiario.setDeclaracaoNascidoVivo(modeloBenExt.getDeclaracaoNascidoVivo());
//        beneficiario.setCassiData(modeloBenExt.getCassiData());
//
//        //Docs
//        DadosBancarios dadosBancarios = beneficiario.getDadosBancarios();
//        if (dadosBancarios == null) {
//            dadosBancarios = new DadosBancarios();
//        }
//        dadosBancarios.setCodigoBanco(modeloBenExt.getBanco());
//        dadosBancarios.setNumeroAgencia(modeloBenExt.getAgenciaBancaria());
//        dadosBancarios.setNumeroConta(modeloBenExt.getContaCorrente());
//
//        Telefone tel1 = null;
//        Telefone tel2 = null;
//        List<Telefone> listaTelefones = beneficiario.getListaTelefone();
//        if (listaTelefones.isEmpty()) {
//            tel1 = new Telefone();
//            tel2 = new Telefone();
//            tel1.setNumeroTelefone(modeloEndExt.getTelefone1());
//            tel2.setNumeroTelefone(modeloEndExt.getTelefone2());
//            beneficiario.addTelefone(tel1);
//            beneficiario.addTelefone(tel2);
//        } else {
//            tel1 = listaTelefones.get(0);
//            tel2 = listaTelefones.get(1);
//            tel1.setNumeroTelefone(modeloEndExt.getTelefone1());
//            tel2.setNumeroTelefone(modeloEndExt.getTelefone2());
//        }
//
//        Documento cpf = null;
//        Documento pis = null;
//        List<Documento> listaDocs = beneficiario.getListaDocumentos();
//        if (listaDocs.isEmpty()) {
//            cpf = new Documento();
//            cpf.setNumeroDocumento(modeloBenExt.getCpf());
//            cpf.setTipoDocumento(EnunTipoDocumento.CPF);
//            pis = new Documento();
//            pis.setNumeroDocumento(modeloBenExt.getPis());
//            pis.setTipoDocumento(EnunTipoDocumento.PIS);
//            beneficiario.addDocumento(cpf);
//            beneficiario.addDocumento(pis);
//        } else {
//            for (Documento d : listaDocs) {
//                if (d.getTipoDocumento() == EnunTipoDocumento.CPF) {
//                    cpf = new Documento();
//                    cpf.setNumeroDocumento(modeloBenExt.getCpf());
//                }
//                if (d.getTipoDocumento() == EnunTipoDocumento.PIS) {
//                    pis = new Documento();
//                    pis.setNumeroDocumento(modeloBenExt.getPis());
//                }
//            }
//            beneficiario.addDocumento(cpf);
//            beneficiario.addDocumento(pis);
//        }
//
//        //Endereco
//        Estado estado = new EstadoBeanImpl().obter(modeloEndExt.getUf());
//        if (estado == null) {
//            estado = new Estado();
//        }
//        estado.setUf(modeloEndExt.getUf());
//
//        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndExt.getCidade());
//        if (municipio == null) {
//            municipio = new Municipio();
//        }
//        municipio.setNome(modeloEndExt.getCidade());
//        municipio.setEstado(estado);
//
//        Endereco endereco = beneficiario.getEndereco();
//        if (endereco == null) {
//            endereco = new Endereco();
//        }
//        endereco.setLogradouro(modeloEndExt.getEndereco());
//        endereco.setBairro(modeloEndExt.getBairro());
//        endereco.setCep(modeloEndExt.getCep());
//        endereco.setEstado(estado);
//        endereco.setMunicipio(municipio);
//        beneficiario.setEndereco(endereco);
//
//        GrauParentesco grauParentesco = new GrauParentescoBeanImpl().existe(modeloBenExt.getGrauParentesco());
//        if (grauParentesco == null) {
//            grauParentesco = new GrauParentesco();
//        }
//        grauParentesco.setGrauParentesco(modeloBenExt.getGrauParentesco());
//        grauParentesco.setDescricao(StringUtil.parseParentesco(grauParentesco.getGrauParentesco()));
//        beneficiario.setGrauParentesco(grauParentesco);
//
//        Plano plano = new PlanoBeanImpl().existe(modeloBenExt.getPlano());
//        if (plano == null) {
//            plano = new Plano();
//        }
//        plano.setCodPlano(modeloBenExt.getPlano());
//        beneficiario.setPlano(plano);
//
//        beneficiario.setStatus(SisPasaIntCommon.ATIVO);
//        beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
//        new BeneficiarioBeanImpl().atualizar(beneficiario);
    }
}
