package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "CONVENIO")
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONVENIO",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DT_INICIO_VIGENCIA", nullable = false, columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "DT_FIM", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(name = "QTD_DIAS_ASSOC", columnDefinition = ConstantesBanco.SMALLINT)
    private Integer qtdDiasAssociacao;

    @Column(name = "QTD_DIAS_ADESAO", columnDefinition = ConstantesBanco.SMALLINT)
    private Integer qtdDiasAdesao;

    @Column(name = "IND_PARTICIP_TAXA_ASSOC", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indParticipacaoTaxaAssociado;

    @Column(name = "IND_CONTRIB_ASSOC", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribuicaoAssociado;

    @Column(name = "IND_CONTRIB_AGREG", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribuicaoAgregado;

    @Column(name = "IND_CONTRIB_DEPEN", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribDependente;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TP_PAGAMENTO")
    private TipoPagamento tipoPagamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TP_PARTICIP")
    private TipoParticipacao tipoParticipacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONTRATO")
    private Contrato contrato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQtdDiasAssociacao() {
        return qtdDiasAssociacao;
    }

    public void setQtdDiasAssociacao(Integer qtdDiasAssociacao) {
        this.qtdDiasAssociacao = qtdDiasAssociacao;
    }

    public Integer getQtdDiasAdesao() {
        return qtdDiasAdesao;
    }

    public void setQtdDiasAdesao(Integer qtdDiasAdesao) {
        this.qtdDiasAdesao = qtdDiasAdesao;
    }

    public Integer getIndParticipacaoTaxaAssociado() {
        return indParticipacaoTaxaAssociado;
    }

    public void setIndParticipacaoTaxaAssociado(Integer indParticipacaoTaxaAssociado) {
        this.indParticipacaoTaxaAssociado = indParticipacaoTaxaAssociado;
    }

    public Integer getIndContribuicaoAssociado() {
        return indContribuicaoAssociado;
    }

    public void setIndContribuicaoAssociado(Integer indContribuicaoAssociado) {
        this.indContribuicaoAssociado = indContribuicaoAssociado;
    }

    public Integer getIndContribuicaoAgregado() {
        return indContribuicaoAgregado;
    }

    public void setIndContribuicaoAgregado(Integer indContribuicaoAgregado) {
        this.indContribuicaoAgregado = indContribuicaoAgregado;
    }

    public Integer getIndContribDependente() {
        return indContribDependente;
    }

    public void setIndContribDependente(Integer indContribDependente) {
        this.indContribDependente = indContribDependente;
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
        return dataUltimaAtualizacao;
    }

    public void setDataUltAtulizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoParticipacao getTipoParticipacao() {
        return tipoParticipacao;
    }

    public void setTipoParticipacao(TipoParticipacao tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
