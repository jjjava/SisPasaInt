package org.pasa.sispasa.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/**
 * 
 * @author Allan Garcia
 *
 */
@Entity
@Table(name = "RESPONSAVEL_PAGAMENTO")
@Audited
@AuditTable(value = "HIST_RESPONSAVEL_PAGAMENTO")
public class ResponsavelPagamento extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_RESPONSAVEL_PAGAMENTO")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PARTICIPANTE")
	private Participante participante;

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

}
