package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "PLANO")
@Audited
@AuditTable(value = "HIST_PLANO")
public class Plano extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PLANO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_PLANO", length = 10)
    private String codPlano;

    @Column(name = "NOME", length = 30, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 60, nullable = false)
    private String descricao;

    @Column(name = "DT_INICIO_VIGENCIA", columnDefinition = ConstantesBanco.DATE, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicioVigencia;

    @Column(name = "DT_FIM_VIGENCIA", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataFimVigencia;

    @Column(name = "QTD_DIAS_CARENCIA", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer qtdDiasCarencia;

    @Column(name = "REGISTRO_ANS", length = 30)
    private String registroANS;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    //RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "ID_OPERADORA", nullable = false)
    @NotAudited
    private Operadora operadora;

    @ManyToOne
    @JoinColumn(name = "ID_TP_PLANO", nullable = false)
    @NotAudited
    private TipoPlano tipoPlano;

    @ManyToOne
    @JoinColumn(name = "ID_PLANO_PAI", referencedColumnName = "ID_PLANO")
    @NotAudited
    private Plano planoPai;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    @NotAudited
    private Contrato contrato;

    //CONSTRUTORES
    public Plano() {
    }

    public Plano(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //GETTERS E SETTERS
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(Date dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public Date getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(Date dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public Integer getQtdDiasCarencia() {
        return qtdDiasCarencia;
    }

    public void setQtdDiasCarencia(Integer qtdDiasCarencia) {
        this.qtdDiasCarencia = qtdDiasCarencia;
    }

    public String getRegistroANS() {
        return registroANS;
    }

    public void setRegistroANS(String registroANS) {
        this.registroANS = registroANS;
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

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public Plano getPlanoPai() {
        return planoPai;
    }

    public void setPlanoPai(Plano planoPai) {
        this.planoPai = planoPai;
    }

    public String getCodPlano() {
        return codPlano;
    }

    public void setCodPlano(String codPlano) {
        this.codPlano = codPlano;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
