package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "VIGENCIA_FAIXA_ETARIA")
@Audited
@AuditTable(value = "HIST_VIGENCIA_FAIXA_ETARIA")
public class VigenciaFaixaEtaria extends BaseEntity implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 8684377734999537076L;
	

	@Id
	@Column(name = "ID_VIGENCIA_FAIXA_ETARIA", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DT_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
	
	@Column(name = "DT_FIM", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtFim;
	
	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	@Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
	private Long idUsuario;

	@Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indAtivo;
	
	public VigenciaFaixaEtaria() {
	}

	public VigenciaFaixaEtaria(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VigenciaFaixaEtaria other = (VigenciaFaixaEtaria) obj;
		if (dtFim == null) {
			if (other.dtFim != null)
				return false;
		} else if (!dtFim.equals(other.dtFim))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Object clone()throws CloneNotSupportedException  {
		return (VigenciaFaixaEtaria) super.clone();
	}


}
