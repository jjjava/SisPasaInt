package org.pasa.sispasa.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

@Entity
@Table(name = "DEPENDENTE")
@PrimaryKeyJoinColumn(name="ID_PESSOA")
@Deprecated
public class Dependente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(name = "ID_DEPENDENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(targetEntity = Beneficiario.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_BEBEFICIARIO", referencedColumnName = "ID_BENEFICIARIO")
	private Beneficiario beneficiario;
	
	@OneToOne(targetEntity = Funcionario.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DEPENDENTE", referencedColumnName = "ID_FUNCIONARIO")
	private Funcionario Funcinario;

	@OneToOne(targetEntity = GrauParentesco.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DEPENDENTE", referencedColumnName = "ID_GRAU_PARENTESCO")
	private GrauParentesco grauParentesco;

	public Dependente() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	public Funcionario getFuncinario() {
		return Funcinario;
	}

	public void setFuncinario(Funcionario funcinario) {
		Funcinario = funcinario;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
}