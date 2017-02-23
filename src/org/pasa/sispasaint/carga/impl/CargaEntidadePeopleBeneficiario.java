package org.pasa.sispasaint.carga.impl;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.core.enumeration.EnumOrigemInformacoes;
import org.pasa.sispasa.core.enumeration.EnumTipoBeneficiario;
import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Pessoa;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.MunicipioBeanImpl;
import org.pasa.sispasaint.bean.impl.NivelEscolaridadeBeanImpl;
import org.pasa.sispasaint.bean.impl.PlanoBeanImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEntidadePeopleBeneficiario {

    private Beneficiario beneficiario;
    private final PlanoBeanImpl planoBean;
    private final EstadoBeanImpl estadoBean;
    private final MunicipioBeanImpl municipioBean;
    private final ImpEndPeopleTempBeanImpl impEndPeopleTempBeanImpl;
    private final NivelEscolaridadeBeanImpl nivelEscolaridadeBean;

    public CargaEntidadePeopleBeneficiario() {
        this.planoBean = new PlanoBeanImpl();
        this.estadoBean = new EstadoBeanImpl();
        this.municipioBean = new MunicipioBeanImpl();
        this.impEndPeopleTempBeanImpl = new ImpEndPeopleTempBeanImpl();
        this.nivelEscolaridadeBean = new NivelEscolaridadeBeanImpl();
    }

    public Beneficiario newBeneficiario(ModeloBenPeople modelo) {
        beneficiario = new Beneficiario();
        beneficiario.setPessoa(new Pessoa());
        //ENDERECO
        if (newEndereco(modelo) == null) {
            return null;
        } else {
            beneficiario.getPessoa().addEndereco(newEndereco(modelo));
        }
        //DOCUMENTOS
        beneficiario.getPessoa().setCpf(modelo.getCpf());
        beneficiario.getPessoa().addDocumento(newPis(modelo));
        //TELEFONES
        beneficiario.getPessoa().setTelefones(newTelefones(modelo));
        //ATRIBUTOS 
        setAtributos(modelo);
        //PLANO
        if (newPlano(modelo) == null) {
            return null;
        }
        beneficiario.getPessoa().setOrigemInformacoes(newOrigemInformacoes());
        beneficiario.setPlano(newPlano(modelo));
        beneficiario.setDataUltimaAtulizacao(DateUtil.obterDataAtual());
        beneficiario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        beneficiario.setIndAtivo(SisPasaIntCommon.ATIVO);

        return beneficiario;
    }

    private Endereco newEndereco(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        Estado estado = estadoBean.obter(modeloEndPeople.getUf());
        Municipio municipio = municipioBean.existe(modeloEndPeople.getCidade());
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

    private NivelEscolaridade newNivelEscolaridade(ModeloBenPeople modelo) {
        NivelEscolaridade nivelEscolaridade = nivelEscolaridadeBean.obter(modelo.getGrauEscolaridade());
        return nivelEscolaridade;
    }

    private List<Telefone> newTelefones(ModeloBenPeople mBen) {
        ModeloEndPeople modeloEndPeople = impEndPeopleTempBeanImpl.obterPorMatricula(mBen);
        List<Telefone> listaTelefones = new ArrayList<>();
        
        if (!modeloEndPeople.getTelefone1().trim().equals("")) {
            
            Telefone tel1 = new Telefone();
            tel1.setNumeroTelefone(modeloEndPeople.getTelefone1().replaceAll(" ",""));
            tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
            tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            System.out.println(tel1.getNumeroTelefone());
            listaTelefones.add(tel1);
        }

        if (!modeloEndPeople.getTelefone2().trim().equals("")) {
            Telefone tel2 = new Telefone();
            tel2.setNumeroTelefone(modeloEndPeople.getTelefone2().replaceAll(" ",""));
            tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
            tel2.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            tel2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            System.out.println(tel2.getNumeroTelefone());
            listaTelefones.add(tel2);
        }
        return listaTelefones;
    }

    private Plano newPlano(ModeloBenPeople modelo) {
        return planoBean.existe(modelo.getPlano());
    }

    private void setAtributos(ModeloBenPeople modeloBenEnd) {
        //ATRIBUTOS
        beneficiario.setCarteirinha(modeloBenEnd.getEmpresa() + modeloBenEnd.getMatricula() + modeloBenEnd.getCodBeneficiario());
        beneficiario.setMatriculaAMS(modeloBenEnd.getMatricula());
        beneficiario.setCodBeneficiario(modeloBenEnd.getCodBeneficiario());
        beneficiario.getPessoa().setNome(modeloBenEnd.getNomeBeneficiario());
        beneficiario.getPessoa().setNomeAbreviado(modeloBenEnd.getNomeBeneficiarioAbreviado());
        beneficiario.getPessoa().setNomeMae(modeloBenEnd.getNomeDaMae());
        beneficiario.getPessoa().setDataNascimento(DateUtil.toDate(modeloBenEnd.getDataNascimento()));
        beneficiario.getPessoa().setDataObito(DateUtil.toDate(modeloBenEnd.getDataFalecimento()));
        beneficiario.getPessoa().setSexo(modeloBenEnd.getSexo());
        beneficiario.getPessoa().setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modeloBenEnd.getIndicadorConclusao()));
        beneficiario.setDireitoAMSReenbolso(modeloBenEnd.getDireitoAmsReembolso());
        if (beneficiario.getDireitoAMSReenbolso().equals("S")) {
            beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenEnd.getDataValidadeReembolso()));
        }else{
            beneficiario.setDataValidadeReembolso(null);
        }
        beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenEnd.getDataValidadeReembolso()));
        beneficiario.setDataUltimaAtulizacao(DateUtil.toDate(modeloBenEnd.getDataDeAtualizacao()));
        beneficiario.setCodCR(modeloBenEnd.getCodigoCR());
        beneficiario.setOrgaoPessoal(modeloBenEnd.getOrgaoPessoal());
        beneficiario.setFaixaNivel(modeloBenEnd.getFaixaNivel());
        beneficiario.setNucleoAMS(modeloBenEnd.getNucleoDaAms());
        beneficiario.setMatriculaParticipante(modeloBenEnd.getMatriculaParticipante());
        beneficiario.setMatriculaRepresentanteLegal(modeloBenEnd.getMatriculaRepresentanteLegal());
        beneficiario.setPlanoReciprocidadeCassi(modeloBenEnd.getPlanoDeReciprocidadeCassi());
        beneficiario.setCns(modeloBenEnd.getCodigoNacionalDeSaude());
        beneficiario.setDeclNascidoVivo(modeloBenEnd.getDeclaracaoNascidoVivo());
        beneficiario.setDataFimPlanoCassi(DateUtil.toDate(modeloBenEnd.getCassiData()));
        beneficiario.getPessoa().setDataInclusaoSistema(DateUtil.obterDataAtual());
        beneficiario.getPessoa().setNivelEscolaridade(newNivelEscolaridade(modeloBenEnd));

        if (modeloBenEnd.getTipoBeneficiario().equalsIgnoreCase(EnumTipoBeneficiario.TITULAR.getIndice())) {
            beneficiario.setTipoBeneficiario(EnumTipoBeneficiario.TITULAR.getIndice());
        } else {
            beneficiario.setTipoBeneficiario(EnumTipoBeneficiario.DEPENDENTE.getIndice());
        }
    }

    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setId(EnumOrigemInformacoes.CARGA.getIndice());
        origemInformacoes.setDescricao(EnumOrigemInformacoes.CARGA.getDescricao());
        return origemInformacoes;
    }
}
