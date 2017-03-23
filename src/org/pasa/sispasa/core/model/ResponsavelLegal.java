package org.pasa.sispasa.core.model;

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

/**
 * 
 * @author Allan Garcia
 *
 */
@Entity
@Table(name = "RESPONSAVEL_LEGAL")
@Audited
@AuditTable(value = "HIST_RESPONSAVEL_LEGAL")
public class ResponsavelLegal extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPONSAVEL_LEGAL")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ULT_ATULZ", nullable = false)
	private Date dataUltimaAlteracao;

	@Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
	private Long idUsuario;

	@ManyToOne
	@JoinColumn(name = "ID_PARTICIPANTE_RESPONSAVEL")
	private Participante participante;

	public ResponsavelLegal() {
	}

	public ResponsavelLegal(Participante participante) {
		this.participante = participante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
