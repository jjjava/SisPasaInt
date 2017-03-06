package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "FAIXA_ETARIA_PLANO")
@Audited
@AuditTable(value = "HIST_FAIXA_ETARIA_PLANO")
public class FaixaEtariaPlano extends BaseEntity implements Serializable, Cloneable  {

	private static final long serialVersionUID = -201920239210512624L;
	
	@Id
	@Column(name = "ID_FAIXA_ETARIA_PLANO", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="VALOR", nullable=false)
	private BigDecimal valor;
	
	@Column(name="IDADE_INICIO", nullable=false , columnDefinition = ConstantesBanco.SMALLINT)
	private Integer idadeInicio;
	
	@Column(name="IDADE_FIM", nullable=true , columnDefinition = ConstantesBanco.SMALLINT)
	private Integer idadeFim;
	
	@Column(name="PERCENTUAL_REAJUSTE", nullable=true)
	private BigDecimal percentualReajuste;
	
	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	@Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
	private Long idUsuario;

	@Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indAtivo;

	@ManyToOne
	@JoinColumn(name = "ID_PLANO", referencedColumnName = "ID_PLANO")
	private Plano plano;
	
	@ManyToOne
	@JoinColumn(name = "ID_VIGENCIA_FAIXA_ETARIA", referencedColumnName = "ID_VIGENCIA_FAIXA_ETARIA")
	private VigenciaFaixaEtaria vigencia; 
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdadeInicio() {
		return idadeInicio;
	}

	public void setIdadeInicio(Integer idadeInicio) {
		this.idadeInicio = idadeInicio;
	}

	public Integer getIdadeFim() {
		return idadeFim;
	}

	public void setIdadeFim(Integer idadeFim) {
		this.idadeFim = idadeFim;
	}

	public BigDecimal getPercentualReajuste() {
		return percentualReajuste;
	}

	public void setPercentualReajuste(BigDecimal percentualReajuste) {
		this.percentualReajuste = percentualReajuste;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public VigenciaFaixaEtaria getVigencia() {
		return vigencia;
	}

	public void setVigencia(VigenciaFaixaEtaria vigencia) {
		this.vigencia = vigencia;
	}

	public Object clone()throws CloneNotSupportedException  {
		return (FaixaEtariaPlano) super.clone();
	}

	

}
