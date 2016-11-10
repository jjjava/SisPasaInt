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

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATR_ORIGEM", length = 6, nullable = false)
    private String matriculaOrigem;

    @Column(name = "MATR_PASA", length = 2)
    private String matriculaPasa;

    @Column(name = "EMP_ATULZR")
    private String empresaAtualizadora;

    @Column(name = "MATR_ATULZR")
    private String matriculaAtualizadora;

    @Column(name = "DIREITO_ABATER_IR", length = 1)
    private String direitoAbaterIR;

    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdimissao;

    @Column(name = "DT_DESLIGAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataDesligamento;

    @Column(name = "EMAIL_CORPORATIVO", length = 60)
    private String email;

    @Column(name = "FINANCEIRA", length = 1)
    private String financeira;

    @Column(name = "CONTRATO_TRABALHO")
    private String contratoTrabalho;

    @Column(name = "CD_DIREITO_PASA")
    private String codDireitoPasa;

    @Column(name = "UNIDADE_CONTROLE", length = 3)
    private String unidadeControle;

    @Column(name = "CENTRO_CUSTO", length = 12)
    private String centroCusto;

    @Column(name = "CD_FILIAL_VLI", length = 4)
    private String codFilialVLI;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUltAtulizacao;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "ID_TP_VINC_EMPREG")
    private TipoVinculoEmpregaticio tipoVinculoEmpregaticio;

    @ManyToOne
    @JoinColumn(name = "ID_DADOS_BANC")
    private DadosBancarios dadosBancarios;

    @ManyToOne
    @JoinColumn(name = "ID_MOTIVO_DESLIGAMENTO")
    private MotivoDesligamento motivoDesligamento;

    public Funcionario() {
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

    public Date getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(Date dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDataUltAtulizacao() {
        return dataUltAtulizacao;
    }

    public void setDataUltAtulizacao(Date dataUltAtulizacao) {
        this.dataUltAtulizacao = dataUltAtulizacao;
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
}
