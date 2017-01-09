package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "CONTRATO")
@Audited
@AuditTable(value = "HIST_CONTRATO")
public class Contrato extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONTRATO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_CONTRATO", columnDefinition = ConstantesBanco.BIGINT)
    private Long numeroContrato;

    @Column(name = "OBSERVACAO", length = 245)
    private String observacao;

    @Column(name = "DT_INICIO_VIGENCIA", nullable = false, columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataInicioVigencia;

    @Column(name = "DT_FIM_VIGENCIA", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataFimVigencia;

    @Column(name = "IDADE_COM_ESTUDO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer idadeComEstudo;

    @Column(name = "IDADE_SEM_ESTUDO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer idadeSemEstudo;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    //RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "ID_TP_CONTRATO")
    @NotAudited
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADORA")
    @NotAudited
    private Operadora operadora;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    @NotAudited
    private Empresa empresa;

    @OneToMany(mappedBy="contrato")
    private List<Plano> planos;
    
    //CONSTRUTORES
    public Contrato() {
        //CONSTRUTOR DEFAULT
    }
    
    public Contrato(Long id) {
        this.id = id;
    }

    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Long numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public Integer getIdadeComEstudo() {
        return idadeComEstudo;
    }

    public void setIdadeComEstudo(Integer idadeComEstudo) {
        this.idadeComEstudo = idadeComEstudo;
    }

    public Integer getIdadeSemEstudo() {
        return idadeSemEstudo;
    }

    public void setIdadeSemEstudo(Integer idadeSemEstudo) {
        this.idadeSemEstudo = idadeSemEstudo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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
}
