package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.enumeration.EnumSimNao;

@Entity
@Table(name = "TAXA_ASSOCIADO")
@Audited
@AuditTable(value = "HIST_TAXA_ASSOCIADO")
public class TaxaAssociado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TAXA_ASSOCIADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DT_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "DT_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "IND_ATIVO")
    private EnumSimNao indAtivo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INCLUSAO_SISTEMA")
    private Date dataInclusaoSistema;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ULT_ATULZ")
    private Date dataUltimaAlteracao;

    @ManyToOne()
    @JoinColumn(name = "ID_TIPO_TAXA")
    private TipoTaxa tipoTaxa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public EnumSimNao getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(EnumSimNao indAtivo) {
        this.indAtivo = indAtivo;
    }

    public TipoTaxa getTipoTaxa() {
        return tipoTaxa;
    }

    public void setTipoTaxa(TipoTaxa tipoTaxa) {
        this.tipoTaxa = tipoTaxa;
    }

    public Date getDataInclusaoSistema() {
        return dataInclusaoSistema;
    }

    public void setDataInclusaoSistema(Date dataInclusaoSistema) {
        this.dataInclusaoSistema = dataInclusaoSistema;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

}
