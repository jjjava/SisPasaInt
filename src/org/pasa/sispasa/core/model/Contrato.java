package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTRATO")
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONTRATO",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_CONTRATO", columnDefinition = ConstantesBanco.BIGINT)
    private Long numeroContrato;

    @Column(name = "OBSERVACAO", length=245)
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

    @Column(name = "DT_ULT_ATULZ", nullable = false) 
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TP_CONTRATO")
    private TipoContrato tipoContrato;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OPERADORA")
    private Operadora operadora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CONTRATO_PLANO",
            joinColumns = @JoinColumn(name = "ID_CONTRATO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PLANO"))
    private List<Plano> planos;

    public Contrato() {
    }

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

    public Date getDataUltAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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

    public Empresa getEmrpesa() {
        return empresa;
    }

    public void setEmrpesa(Empresa emrpesa) {
        this.empresa = emrpesa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }
}
