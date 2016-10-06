package org.pasa.sispasaint.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasaint.model.enun.TipoBeneficiario;

/**
 *
 * @author hudson schumaker
 */
@Entity
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
public class Beneficiario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_BENEFICIARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_BENEFICIARIO")
    private String codBeneficiario;

    @Column(name = "BOL_DIREITO_AMS_CREDENCIAMENTO")
    private Integer direitoAMSCredenciamento;

    @Column(name = "DT_VALIDADE_CREDENCIADO")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeCredenciado;

    @Column(name = "BOL_DIREITO_AMS_REEMBOLSO")
    private Integer direitoAmsReembolso;

    @Column(name = "DT_VALIDADE_REEMBOLSO")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeReembolso;

    @Column(name = "DT_DE_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dataDeAtualizacao;

    @Column(name = "CD_CR")
    private String codigoCR;

    @Column(name = "VL_ORGAO_PESSOAL")
    private String orgaoPessoal;

    @Column(name = "CD_PLANO")
    private String plano;

    @Column(name = "CD_FAIXA_NIVEL")
    private String faixaNivel;

    @Column(name = "VL_NUCLEO_AMS")
    private String nucleoDaAms;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GRAU_PARENTESCO")
    private GrauParentesco grauParentesco;

    @Column(name = "TP_BENEFICIARIO")
    @Enumerated(EnumType.ORDINAL)
    private TipoBeneficiario tipoBeneficiario;
    
    @Column(name="NR_MATRICULA_PARTICIPANTE")
    private String matriculaParticipante;
    
    @Column(name="NR_MATRICULA_REPRESENTANTE_LEGAL")
    private String matriculaRepresentanteLegal;

    @Column(name = "BL_PLANO_DE_RECIPROCIDADE_CASSI")
    private Integer planoDeReciprocidadeCassi;

    @Column(name = "CD_NACIONAL_DE_SAUDE")
    private String codigoNacionalDeSaude;
    
    @Column(name = "CD_DECLARACAO_NASCIDO_VIVO")
    private String declaracaoNascidoVivo;

    @Column(name = "BR_CASSI_DATA")
    private String cassiData;// BRANCO

    public Beneficiario() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodBeneficiario() {
        return codBeneficiario;
    }

    public void setCodBeneficiario(String codBeneficiario) {
        this.codBeneficiario = codBeneficiario;
    }

    public Integer getDireitoAMSCredenciamento() {
        return direitoAMSCredenciamento;
    }

    public void setDireitoAMSCredenciamento(Integer direitoAMSCredenciamento) {
        this.direitoAMSCredenciamento = direitoAMSCredenciamento;
    }

    public Date getDataValidadeCredenciado() {
        return dataValidadeCredenciado;
    }

    public void setDataValidadeCredenciado(Date dataValidadeCredenciado) {
        this.dataValidadeCredenciado = dataValidadeCredenciado;
    }

    public Integer getDireitoAmsReembolso() {
        return direitoAmsReembolso;
    }

    public void setDireitoAmsReembolso(Integer direitoAmsReembolso) {
        this.direitoAmsReembolso = direitoAmsReembolso;
    }

    public Date getDataValidadeReembolso() {
        return dataValidadeReembolso;
    }

    public void setDataValidadeReembolso(Date dataValidadeReembolso) {
        this.dataValidadeReembolso = dataValidadeReembolso;
    }

    public Date getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(Date dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public String getCodigoCR() {
        return codigoCR;
    }

    public void setCodigoCR(String codigoCR) {
        this.codigoCR = codigoCR;
    }

    public String getOrgaoPessoal() {
        return orgaoPessoal;
    }

    public void setOrgaoPessoal(String orgaoPessoal) {
        this.orgaoPessoal = orgaoPessoal;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getFaixaNivel() {
        return faixaNivel;
    }

    public void setFaixaNivel(String faixaNivel) {
        this.faixaNivel = faixaNivel;
    }

    public String getNucleoDaAms() {
        return nucleoDaAms;
    }

    public void setNucleoDaAms(String nucleoDaAms) {
        this.nucleoDaAms = nucleoDaAms;
    }

    public GrauParentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public TipoBeneficiario getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getMatriculaParticipante() {
        return matriculaParticipante;
    }

    public void setMatriculaParticipante(String matriculaParticipante) {
        this.matriculaParticipante = matriculaParticipante;
    }

    public String getMatriculaRepresentanteLegal() {
        return matriculaRepresentanteLegal;
    }

    public void setMatriculaRepresentanteLegal(String matriculaRepresentanteLegal) {
        this.matriculaRepresentanteLegal = matriculaRepresentanteLegal;
    }

    public Integer getPlanoDeReciprocidadeCassi() {
        return planoDeReciprocidadeCassi;
    }

    public void setPlanoDeReciprocidadeCassi(Integer planoDeReciprocidadeCassi) {
        this.planoDeReciprocidadeCassi = planoDeReciprocidadeCassi;
    }

    public String getCodigoNacionalDeSaude() {
        return codigoNacionalDeSaude;
    }

    public void setCodigoNacionalDeSaude(String codigoNacionalDeSaude) {
        this.codigoNacionalDeSaude = codigoNacionalDeSaude;
    }

    public String getDeclaracaoNascidoVivo() {
        return declaracaoNascidoVivo;
    }

    public void setDeclaracaoNascidoVivo(String declaracaoNascidoVivo) {
        this.declaracaoNascidoVivo = declaracaoNascidoVivo;
    }

    public String getCassiData() {
        return cassiData;
    }

    public void setCassiData(String cassiData) {
        this.cassiData = cassiData;
    }
}
