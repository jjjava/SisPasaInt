package org.pasa.sispasa.core.model;

import java.io.Serializable;

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

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumTipoContaAssociado;

@Entity
@Table(name = "PARTICIPANTE_DADOS_BANCARIOS")
@Audited
@AuditTable(value = "HIST_PARTICIPANTE_DADOS_BANCARIOS")
public class ParticipanteDadosBancarios extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PARTICIPANTE_DADOS_BANCARIOS", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TP_CONTA", nullable = false, columnDefinition = ConstantesBanco.CHAR_1)
	private EnumTipoContaAssociado tipoConta;

	@ManyToOne
	@JoinColumn(name = "ID_DADOS_BANC")
	@NotAudited
	private DadosBancarios dadosBancarios;

	@ManyToOne
	@JoinColumn(name = "ID_PARTICIPANTE")
	@NotAudited
	private Participante participante;

	public boolean isTipoContaPagamento() {
		return EnumTipoContaAssociado.P.equals(tipoConta);
	}

	public boolean isTipoContaReembolso() {
		return EnumTipoContaAssociado.R.equals(tipoConta);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumTipoContaAssociado getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(EnumTipoContaAssociado tipoConta) {
		this.tipoConta = tipoConta;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
