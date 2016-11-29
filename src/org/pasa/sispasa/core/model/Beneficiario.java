package org.pasa.sispasa.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "BENEFICIARIO")
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
public class Beneficiario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_BENEF", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_BENEF", nullable = false, columnDefinition = ConstantesBanco.CHAR_2)
    private String codBeneficiario;

    @Column(name = "MATRICULA_AMS", length=15)
    private String matriculaAMS;

    @Column(name = "CARTEIRINHA", nullable = false, length=10)
    private String carteirinha;

    @Column(name = "DIREITO_AMS_CREDENC", nullable = false, columnDefinition = ConstantesBanco.CHAR_1)
    private String direitoAmsCredenciar;

    @Column(name = "DT_VALIDADE_CREDENC", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataValidadeCredenciado;

    @Column(name = "DIREITO_AMS_REEMB", columnDefinition = ConstantesBanco.CHAR_1)
    private String direitoAMSReenbolso;

    @Column(name = "DT_VALIDADE_REEMB", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataValidadeReembolso;

    @Column(name = "DT_ATULIZACAO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataAtulizacao;

    @Column(name = "CD_CR", length=8)
    private String codCR;

    @Column(name = "ORGAO_PESSOAL", columnDefinition = ConstantesBanco.CHAR_1)
    private String orgaoPessoal;

    @Column(name = "FAIXA_NIVEL", length=2)
    private String faixaNivel;

    @Column(name = "NUCLEO_AMS", length=2)
    private String nucleoAMS;

    @Column(name = "TP_BENEF", columnDefinition = ConstantesBanco.CHAR_1, nullable= false)
    private String tipoBenneficiario;

    @Column(name = "MATR_PARTICIP", length=15)
    private String matriculaParticipante;

    @Column(name = "MATR_REPR_LEGAL", length=15)
    private String matriculaRepresentanteLegal;

    @Column(name = "PLANO_RCP_CASSI", columnDefinition = ConstantesBanco.CHAR_1)
    private String planoReciprocidadeCassi;

    @Column(name = "DT_FIM_PLANO_CASSI", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataFimPlanoCassi;

    @Column(name = "CD_NACIONAL_SAUDE", length=15)
    private String cns;

    @Column(name = "DECL_NASCIDO_VIVO", length=11)
    private String declNascidoVivo;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtulizacao;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ID_GRAU_PARENT")
    private GrauParentesco grauParentesco;

    @ManyToOne
    @JoinColumn(name = "ID_PLANO")
    private Plano plano;

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

    public String getMatriculaAMS() {
        return matriculaAMS;
    }

    public void setMatriculaAMS(String matriculaAMS) {
        this.matriculaAMS = matriculaAMS;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }

    public String getDireitoAmsCredenciar() {
        return direitoAmsCredenciar;
    }

    public void setDireitoAmsCredenciar(String direitoAmsCredenciar) {
        this.direitoAmsCredenciar = direitoAmsCredenciar;
    }

    public Date getDataValidadeCredenciado() {
        return dataValidadeCredenciado;
    }

    public void setDataValidadeCredenciado(Date dataValidadeCredenciado) {
        this.dataValidadeCredenciado = dataValidadeCredenciado;
    }

    public String getDireitoAMSReenbolso() {
        return direitoAMSReenbolso;
    }

    public void setDireitoAMSReenbolso(String direitoAMSReenbolso) {
        this.direitoAMSReenbolso = direitoAMSReenbolso;
    }

    public Date getDataValidadeReembolso() {
        return dataValidadeReembolso;
    }

    public void setDataValidadeReembolso(Date dataValidadeReembolso) {
        this.dataValidadeReembolso = dataValidadeReembolso;
    }

    public Date getDataAtulizacao() {
        return dataAtulizacao;
    }

    public void setDataAtulizacao(Date dataAtulizacao) {
        this.dataAtulizacao = dataAtulizacao;
    }

    public String getCodCR() {
        return codCR;
    }

    public void setCodCR(String codCR) {
        this.codCR = codCR;
    }

    public String getOrgaoPessoal() {
        return orgaoPessoal;
    }

    public void setOrgaoPessoal(String orgaoPessoal) {
        this.orgaoPessoal = orgaoPessoal;
    }

    public String getFaixaNivel() {
        return faixaNivel;
    }

    public void setFaixaNivel(String faixaNivel) {
        this.faixaNivel = faixaNivel;
    }

    public String getNucleoAMS() {
        return nucleoAMS;
    }

    public void setNucleoAMS(String nucleoAMS) {
        this.nucleoAMS = nucleoAMS;
    }

    public String getTipoBenneficiario() {
        return tipoBenneficiario;
    }

    public void setTipoBenneficiario(String tipoBenneficiario) {
        this.tipoBenneficiario = tipoBenneficiario;
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

    public String getPlanoReciprocidadeCassi() {
        return planoReciprocidadeCassi;
    }

    public void setPlanoReciprocidadeCassi(String planoReciprocidadeCassi) {
        this.planoReciprocidadeCassi = planoReciprocidadeCassi;
    }

    public Date getDataFimPlanoCassi() {
        return dataFimPlanoCassi;
    }

    public void setDataFimPlanoCassi(Date dataFimPlanoCassi) {
        this.dataFimPlanoCassi = dataFimPlanoCassi;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getDeclNascidoVivo() {
        return declNascidoVivo;
    }

    public void setDeclNascidoVivo(String declNascidoVivo) {
        this.declNascidoVivo = declNascidoVivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Date getDataUltAtulizacao() {
        return dataUltAtulizacao;
    }

    public void setDataUltAtulizacao(Date dataUltAtulizacao) {
        this.dataUltAtulizacao = dataUltAtulizacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public GrauParentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

}
