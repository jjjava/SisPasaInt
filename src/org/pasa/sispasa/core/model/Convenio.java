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
@Table(name = "CONVENIO")
@Audited
@AuditTable(value="HIST_CONVENIO")
public class Convenio extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONVENIO",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DT_INICIO_VIGENCIA", nullable = false, columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataInicioVigencia;

    @Column(name = "DT_FIM", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataFimVigencia;

    @Column(name = "QTD_DIAS_ASSOC", columnDefinition = ConstantesBanco.SMALLINT)
    private Integer qtdDiasAssociacao;

    @Column(name = "QTD_DIAS_ADESAO", columnDefinition = ConstantesBanco.SMALLINT)
    private Integer qtdDiasAdesao;
    
    @Column(name = "IND_CONV_PRINCIP", columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indConvenioPrincipal;

    @Column(name = "IND_PARTICIP_TAXA_ASSOC", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indParticipacaoTaxaAssociado;

    @Column(name = "IND_CONTRIB_ASSOC", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribuicaoAssociado;

    @Column(name = "IND_CONTRIB_AGREG", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribuicaoAgregado;

    @Column(name = "IND_CONTRIB_DEPEN", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indContribuicaoDependente;
    
    @Column(name = "IND_COPARTICIP_ASSOC", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indCoparticipacaoAssociado;

    @Column(name = "IND_COPARTICIP_AGREG", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indCoparticipacaoAgregado;

    @Column(name = "IND_COPARTICIP_DEPEN", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indCoparticipacaoDependente;
    
    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
   //RELACIONAMENTOS

    @ManyToOne
    @JoinColumn(name = "ID_TP_PAGAMENTO")
    @NotAudited
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_TP_PARTICIP")
    @NotAudited
    private TipoParticipacao tipoParticipacao;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    @NotAudited
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    @NotAudited
    private Contrato contrato;

    
    //GETTERS E SETTERS
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public Integer getIndConvenioPrincipal() {
		return indConvenioPrincipal;
	}

	public void setIndConvenioPrincipal(Integer indConvenioPrincipal) {
		this.indConvenioPrincipal = indConvenioPrincipal;
	}

	public Integer getIndCoparticipacaoAssociado() {
		return indCoparticipacaoAssociado;
	}

	public void setIndCoparticipacaoAssociado(Integer indCoparticipacaoAssociado) {
		this.indCoparticipacaoAssociado = indCoparticipacaoAssociado;
	}

	public Integer getIndCoparticipacaoAgregado() {
		return indCoparticipacaoAgregado;
	}

	public void setIndCoparticipacaoAgregado(Integer indCoparticipacaoAgregado) {
		this.indCoparticipacaoAgregado = indCoparticipacaoAgregado;
	}

	public Integer getIndCoparticipacaoDependente() {
		return indCoparticipacaoDependente;
	}

	public void setIndCoparticipacaoDependente(Integer indCoparticipacaoDependente) {
		this.indCoparticipacaoDependente = indCoparticipacaoDependente;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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

	public Integer getIndContribuicaoDependente() {
		return indContribuicaoDependente;
	}

	public void setIndContribuicaoDependente(Integer indContribuicaoDependente) {
		this.indContribuicaoDependente = indContribuicaoDependente;
	}
}
