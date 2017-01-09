package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
@Audited
@AuditTable(value = "HIST_FUNCIONARIO")
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_FUNCIONARIO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATR_ORIGEM", length = 15, nullable = false)
    private String matriculaOrigem;

    @Column(name = "MATR_PASA", length = 15)
    private String matriculaPasa;

    @Column(name = "EMP_ATULZR", length = 2)
    private String empresaAtualizadora;

    @Column(name = "MATR_ATULZR", length = 15)
    private String matriculaAtualizadora;

    @Column(name = "DIREITO_ABATER_IR", columnDefinition = ConstantesBanco.CHAR_1)
    private String direitoAbaterIR;

    @Column(name = "DT_ADMISSAO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "DT_DESLIGAMENTO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataDesligamento;

    @Column(name = "EMAIL_CORPORATIVO", length = 60)
    private String emailCorporativo;

    @Column(name = "FINANCEIRA", columnDefinition = ConstantesBanco.CHAR_1)
    private String financeira;

    @Column(name = "CONTRATO_TRABALHO", columnDefinition = ConstantesBanco.CHAR_1)
    private String contratoTrabalho;

    @Column(name = "CD_DIREITO_PASA", columnDefinition = ConstantesBanco.CHAR_1)
    private String codDireitoPasa;

    @Column(name = "UNIDADE_CONTROLE", length = 3)
    private String unidadeControle;

    @Column(name = "CENTRO_CUSTO", columnDefinition = ConstantesBanco.CHAR_12)
    private String centroCusto;

    @Column(name = "CD_FILIAL_VLI", length = 4)
    private String codFilialVLI;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_EMPRESA")
    @NotAudited
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TP_VINC_EMPREG")
    @NotAudited
    private TipoVinculoEmpregaticio tipoVinculoEmpregaticio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DADOS_BANC")
    @NotAudited
    private DadosBancarios dadosBancarios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MOTIVO_DESLIGAMENTO")
    @NotAudited
    private MotivoDesligamento motivoDesligamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    @NotAudited
    private List<Beneficiario> beneficiarios;

    public Funcionario() {
        beneficiarios = new ArrayList<>();
    }

    public EnumMotivoDesligamento getMotivoDesligamentoAsEnum() {
        return EnumMotivoDesligamento.getMotivoDesligamentoByIndice(motivoDesligamento.getId().intValue());
    }

    public void addBeneficiario(Beneficiario b) {
        beneficiarios.add(b);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaOrigem() {
        return matriculaOrigem;
    }

    public void setMatriculaOrigem(String matriculaOrigem) {
        this.matriculaOrigem = matriculaOrigem;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getEmpresaAtualizadora() {
        return empresaAtualizadora;
    }

    public void setEmpresaAtualizadora(String empresaAtualizadora) {
        this.empresaAtualizadora = empresaAtualizadora;
    }

    public String getMatriculaAtualizadora() {
        return matriculaAtualizadora;
    }

    public void setMatriculaAtualizadora(String matriculaAtualizadora) {
        this.matriculaAtualizadora = matriculaAtualizadora;
    }

    public String getDireitoAbaterIR() {
        return direitoAbaterIR;
    }

    public void setDireitoAbaterIR(String direitoAbaterIR) {
        this.direitoAbaterIR = direitoAbaterIR;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public String getFinanceira() {
        return financeira;
    }

    public void setFinanceira(String financeira) {
        this.financeira = financeira;
    }

    public String getContratoTrabalho() {
        return contratoTrabalho;
    }

    public void setContratoTrabalho(String contratoTrabalho) {
        this.contratoTrabalho = contratoTrabalho;
    }

    public String getCodDireitoPasa() {
        return codDireitoPasa;
    }

    public void setCodDireitoPasa(String codDireitoPasa) {
        this.codDireitoPasa = codDireitoPasa;
    }

    public String getUnidadeControle() {
        return unidadeControle;
    }

    public void setUnidadeControle(String unidadeControle) {
        this.unidadeControle = unidadeControle;
    }

    public String getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
    }

    public String getCodFilialVLI() {
        return codFilialVLI;
    }

    public void setCodFilialVLI(String codFilialVLI) {
        this.codFilialVLI = codFilialVLI;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoVinculoEmpregaticio getTipoVinculoEmpregaticio() {
        return tipoVinculoEmpregaticio;
    }

    public void setTipoVinculoEmpregaticio(TipoVinculoEmpregaticio tipoVinculoEmpregaticio) {
        this.tipoVinculoEmpregaticio = tipoVinculoEmpregaticio;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public MotivoDesligamento getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(MotivoDesligamento motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
    }

    /**
     * @return the emailCorporativo
     */
    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    /**
     * @param emailCorporativo the emailCorporativo to set
     */
    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    /**
     * @return the dataAdmissao
     */
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * @return the dataUltimaAtualizacao
     */
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    /**
     * @param dataUltimaAtualizacao the dataUltimaAtualizacao to set
     */
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
