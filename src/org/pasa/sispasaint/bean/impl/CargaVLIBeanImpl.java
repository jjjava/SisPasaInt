package org.pasa.sispasaint.bean.impl;

import java.util.List;
import java.util.Date;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.EstadoCivil;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.GrauParentesco;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.Operadora;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.enun.EnunTipoBeneficiario;
import org.pasa.sispasaint.model.enun.EnunTipoDocumento;
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
        try {
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
            funcionario.setSexo(modeloBenVLI.getSexo());

            NivelEscolaridade nivelEscolaridade = funcionario.getNivelEscolaridade();
            if (nivelEscolaridade == null) {
                nivelEscolaridade = new NivelEscolaridade();
            }

            nivelEscolaridade.setCodExterno(modeloBenVLI.getGrauEscolaridade());
            funcionario.setNivelEscolaridade(nivelEscolaridade);
            funcionario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));

            DadosBancarios dadosBancarios = funcionario.getDadosBancarios();
            if (dadosBancarios == null) {
                dadosBancarios = new DadosBancarios();
            }
            dadosBancarios.setCodBanco(modeloBenVLI.getBanco());
            dadosBancarios.setAgencia(modeloBenVLI.getAgenciaBancaria());
            dadosBancarios.setConta(modeloBenVLI.getContaCorrente());
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
                tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
                tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
                tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
                tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
                funcionario.addTelefone(tel1);
                funcionario.addTelefone(tel2);
            } else {
                tel1 = new Telefone();
                tel2 = new Telefone();
                tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
                tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
                tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
                tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
                listaTelefones.clear();
                funcionario.addTelefone(tel1);
                funcionario.addTelefone(tel2);
                funcionario.setTelefones(listaTelefones);
            }

            //Docs
            Documento cpf = null;
            Documento pis = null;
            List<Documento> listaDocs = funcionario.getDocumentos();
            if (listaDocs.isEmpty()) {
                cpf = new Documento();
                cpf.setNumero(modeloBenVLI.getCpf());
                TipoDocumento tpCPF = new TipoDocumento();
                tpCPF.setDescricao(EnunTipoDocumento.CPF.getDescricao());
                cpf.setTipoDocumento(tpCPF);

                pis = new Documento();
                pis.setNumero(modeloBenVLI.getPis());
                TipoDocumento tpPIS = new TipoDocumento();
                tpPIS.setDescricao(EnunTipoDocumento.PIS.getDescricao());
                pis.setTipoDocumento(tpPIS);
            } else {
                for (Documento d : listaDocs) {
                    if (d.getTipoDocumento().getDescricao().equalsIgnoreCase(EnunTipoDocumento.CPF.getDescricao())) {
                        cpf = new Documento();
                        cpf.setNumero(modeloBenVLI.getCpf());
                    }
                    if (d.getTipoDocumento().getDescricao().equalsIgnoreCase(EnunTipoDocumento.PIS.getDescricao())) {
                        pis = new Documento();
                        pis.setNumero(modeloBenVLI.getPis());
                    }
                }
            }
            cpf.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
            pis.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
            funcionario.addDocumento(cpf);
            funcionario.addDocumento(pis);
            //Endereco
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

            Endereco endereco = null;
            List<Endereco> enderecos = funcionario.getEnderecos();
            if (enderecos.isEmpty()) {
                endereco = new Endereco();
                endereco.setLogradouro(modeloEndVLI.getEndereco());
                endereco.setBairro(modeloEndVLI.getBairro());
                endereco.setCep(modeloEndVLI.getCep());
                endereco.setEstado(estado);
                endereco.setMunicipio(municipio);
                endereco.setNumero("");
                endereco.setDataAtulizacao(DateUtil.obterDataAtual());
                funcionario.addEndereco(endereco);
            } else {
                enderecos.get(0).setLogradouro(modeloEndVLI.getEndereco());
                enderecos.get(0).setBairro(modeloEndVLI.getBairro());
                enderecos.get(0).setCep(modeloEndVLI.getCep());
                enderecos.get(0).setEstado(estado);
                enderecos.get(0).setMunicipio(municipio);
                enderecos.get(0).setNumero("");
                enderecos.get(0).setDataAtulizacao(DateUtil.obterDataAtual());

                funcionario.addEndereco(enderecos.get(0));
            }

            //Funcionario
            Empresa empresa = new EmpresaBeanImpl().existe(modeloBenVLI.getEmpresa());
            if (empresa == null) {
                empresa = new Empresa();
            }
            empresa.setCodEmpresaVale(modeloBenVLI.getEmpresa());
            empresa.setIndAtivo(SisPasaIntCommon.ATIVO);
            empresa.setDataAtulizacao(new Date());
            empresa.setIdUsuario(1L);
            funcionario.setEmpresa(empresa);
            funcionario.setMatriculaOrigem(modeloBenVLI.getMatricula());

            TipoVinculoEmpregaticio tipoVinculoEmpregaticio = funcionario.getTipoVinculoEmpregaticio();
            if (tipoVinculoEmpregaticio == null) {
                tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
            }
            tipoVinculoEmpregaticio.setCodExterno(modeloBenVLI.getVinculo());
            funcionario.setTipoVinculoEmpregaticio(tipoVinculoEmpregaticio);

            funcionario.setDireitoAbaterIR(modeloBenVLI.getDireitoAbaterIR());
            funcionario.setDataAdimissao(DateUtil.toDate(modeloBenVLI.getDataAdmissao()));
            funcionario.setFinanceira(modeloBenVLI.getFinanceira());
            funcionario.setContratoTrabalho(modeloBenVLI.getContratoTrabalho());
            funcionario.setEmpresaAtualizadora(modeloBenVLI.getEmpresaAtualizador());
            funcionario.setMatriculaAtualizadora(modeloBenVLI.getMatriculaAtulizador());
            funcionario.setCodDireitoPasa(modeloBenVLI.getCodigoDireitoPasa());
            funcionario.setMatriculaPasa(modeloBenVLI.getMatriculaPasa());

            funcionario.setMatriculaOrigem(modeloBenVLI.getMatriculaOrigem());
            //   funcionario.setEmpresaPeople(modeloBenVLI.getEmpresaPeople());
            //    funcionario.setMatriculaPeople(modeloBenVLI.getMatriculaPeople());
            funcionario.setUnidadeControle(modeloBenVLI.getUnidadeDeControle());
            funcionario.setCentroCusto(modeloBenVLI.getCentroDeCusto());
            //  funcionario.setBranco(modeloBenVLI.getBranco());
            //  funcionario.setCodigoFilialVLI(modeloBenVLI.getCodigoFilialVLI());

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
            Funcionario funcBeneficiario = new FuncionarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula());
            beneficiario.setMatriculaAMS(modeloBenVLI.getMatricula());
            beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());

            beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
            beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
            beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
            beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
            beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
            beneficiario.setSexo(modeloBenVLI.getSexo());
            beneficiario.setNivelEscolaridade(funcBeneficiario.getNivelEscolaridade());
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
            beneficiario.setTipoBenneficiario(EnunTipoBeneficiario.Titular.getDescricao());
            beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
            beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
            beneficiario.setPlanoReciprocidadeCassi(modeloBenVLI.getPlanoDeReciprocidadeCassi());
            beneficiario.setCns(modeloBenVLI.getCodigoNacionalDeSaude());
            beneficiario.setDeclNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
            beneficiario.setDataFimPlanoCassi(DateUtil.toDate(modeloBenVLI.getCassiData()));

            beneficiario.setEndereco(funcBeneficiario.getEnderecos());
            beneficiario.setDocumentos(funcBeneficiario.getDocumentos());

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

    private void handlerBeneficiario(ModeloBenVLI modeloBenVLI, ModeloEndVLI modeloEndVLI) {
//        Beneficiario beneficiario = new BeneficiarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula(), modeloBenVLI.getCodBeneficiario());
//        if (beneficiario == null) {
//            beneficiario = new Beneficiario();
//        }
//
//        beneficiario.setMatricula(modeloBenVLI.getMatricula());
//        beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());
//        beneficiario.setNome(modeloBenVLI.getNomeBeneficiario());
//        beneficiario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
//        beneficiario.setNomeMae(modeloBenVLI.getNomeDaMae());
//        beneficiario.setDataNascimento(DateUtil.toDate(modeloBenVLI.getDataNascimento()));
//        beneficiario.setDataObito(DateUtil.toDate(modeloBenVLI.getDataFalecimento()));
//        beneficiario.setSexo(StringUtil.parseSexo(modeloBenVLI.getSexo()));
//        beneficiario.setNivelEscolaridade(StringUtil.parseEscolocaridade(modeloBenVLI.getGrauEscolaridade()));
//        beneficiario.setIndicadorConclusao(StringUtil.parserIndicadorConclusao(modeloBenVLI.getIndicadorConclusao()));
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
//        beneficiario.setTipoBeneficiario(EnunTipoBeneficiario.Dependente);
//        beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
//        beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
//        beneficiario.setPlanoDeReciprocidadeCassi(StringUtil.parseBoolean(modeloBenVLI.getPlanoDeReciprocidadeCassi()));
//        beneficiario.setCodigoNacionalDeSaude(modeloBenVLI.getCodigoNacionalDeSaude());
//        beneficiario.setDeclaracaoNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
//        beneficiario.setCassiData(modeloBenVLI.getCassiData());
//
//        //Docs
//        DadosBancarios dadosBancarios = beneficiario.getDadosBancarios();
//        if (dadosBancarios == null) {
//            dadosBancarios = new DadosBancarios();
//        }
//        dadosBancarios.setCodigoBanco(modeloBenVLI.getBanco());
//        dadosBancarios.setNumeroAgencia(modeloBenVLI.getAgenciaBancaria());
//        dadosBancarios.setNumeroConta(modeloBenVLI.getContaCorrente());
//
//        Telefone tel1 = null;
//        Telefone tel2 = null;
//        List<Telefone> listaTelefones = beneficiario.getListaTelefone();
//        if (listaTelefones.isEmpty()) {
//            tel1 = new Telefone();
//            tel2 = new Telefone();
//            tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
//            tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
//            beneficiario.addTelefone(tel1);
//            beneficiario.addTelefone(tel2);
//        } else {
//            tel1 = listaTelefones.get(0);
//            tel2 = listaTelefones.get(1);
//            tel1.setNumeroTelefone(modeloEndVLI.getTelefone1());
//            tel2.setNumeroTelefone(modeloEndVLI.getTelefone2());
//        }
//
//        Documento cpf = null;
//        Documento pis = null;
//        List<Documento> listaDocs = beneficiario.getListaDocumentos();
//        if (listaDocs.isEmpty()) {
//            cpf = new Documento();
//            cpf.setNumeroDocumento(modeloBenVLI.getCpf());
//            cpf.setTipoDocumento(EnunTipoDocumento.CPF);
//            pis = new Documento();
//            pis.setNumeroDocumento(modeloBenVLI.getPis());
//            pis.setTipoDocumento(EnunTipoDocumento.PIS);
//            beneficiario.addDocumento(cpf);
//            beneficiario.addDocumento(pis);
//        } else {
//            for (Documento d : listaDocs) {
//                if (d.getTipoDocumento() == EnunTipoDocumento.CPF) {
//                    cpf = new Documento();
//                    cpf.setNumeroDocumento(modeloBenVLI.getCpf());
//                }
//                if (d.getTipoDocumento() == EnunTipoDocumento.PIS) {
//                    pis = new Documento();
//                    pis.setNumeroDocumento(modeloBenVLI.getPis());
//                }
//            }
//            beneficiario.addDocumento(cpf);
//            beneficiario.addDocumento(pis);
//        }
//
//        //Endereco
//        Estado estado = new EstadoBeanImpl().obter(modeloEndVLI.getUf());
//        if (estado == null) {
//            estado = new Estado();
//        }
//        estado.setUf(modeloEndVLI.getUf());
//
//        Municipio municipio = new MunicipioBeanImpl().existe(modeloEndVLI.getCidade());
//        if (municipio == null) {
//            municipio = new Municipio();
//        }
//        municipio.setNome(modeloEndVLI.getCidade());
//        municipio.setEstado(estado);
//
//        Endereco endereco = beneficiario.getEndereco();
//        if (endereco == null) {
//            endereco = new Endereco();
//        }
//        endereco.setLogradouro(modeloEndVLI.getEndereco());
//        endereco.setBairro(modeloEndVLI.getBairro());
//        endereco.setCep(modeloEndVLI.getCep());
//        endereco.setEstado(estado);
//        endereco.setMunicipio(municipio);
//        beneficiario.setEndereco(endereco);
//
//        GrauParentesco grauParentesco = new GrauParentescoBeanImpl().existe(modeloBenVLI.getGrauParentesco());
//        if (grauParentesco == null) {
//            grauParentesco = new GrauParentesco();
//        }
//        grauParentesco.setGrauParentesco(modeloBenVLI.getGrauParentesco());
//        grauParentesco.setDescricao(StringUtil.parseParentesco(grauParentesco.getGrauParentesco()));
//        beneficiario.setGrauParentesco(grauParentesco);
//
//        Plano plano = new PlanoBeanImpl().existe(modeloBenVLI.getPlano());
//        if (plano == null) {
//            plano = new Plano();
//        }
//        plano.setCodPlano(modeloBenVLI.getPlano());
//        beneficiario.setPlano(plano);
//
//        beneficiario.setStatus(SisPasaIntCommon.ATIVO);
//        beneficiario.setSituacao(SisPasaIntCommon.ATUALIZADO);
//        new BeneficiarioBeanImpl().atualizar(beneficiario);
    }
}
