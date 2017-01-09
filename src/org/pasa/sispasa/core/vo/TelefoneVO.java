package org.pasa.sispasa.core.vo;

import org.pasa.sispasa.core.enumeration.EnumTipoTelefone;

/**
 *
 * @author Andre Gomes
 */
public class TelefoneVO extends AtributosComunsVO {

	private Long id;
	private String numeroTelefoneComDDD;
	private String ramal;

	private EnumTipoTelefone enumTipoTelefone;

	public TelefoneVO() {
	}

	public TelefoneVO(String numeroTelefoneComDDD, String ramal, EnumTipoTelefone tipo) {
		this(null, numeroTelefoneComDDD, ramal, tipo);
	}

	public TelefoneVO(Long id, String numeroTelefoneComDDD, String ramal, EnumTipoTelefone tipo) {
		this.id = id;
		this.numeroTelefoneComDDD = numeroTelefoneComDDD;
		this.ramal = ramal;
		this.enumTipoTelefone = tipo;
	}

	// GETTERS E SETTERS

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	/**
	 * @return the numeroTelefoneComDDD
	 */
	public String getNumeroTelefoneComDDD() {
		return numeroTelefoneComDDD;
	}

	/**
	 * @param numeroTelefoneComDDD
	 *            the numeroTelefoneComDDD to set
	 */
	public void setNumeroTelefoneComDDD(String numeroTelefoneComDDD) {
		this.numeroTelefoneComDDD = numeroTelefoneComDDD;
	}

	/**
	 * @return the enumTipoTelefone
	 */
	public EnumTipoTelefone getEnumTipoTelefone() {
		return enumTipoTelefone;
	}

	/**
	 * @param enumTipoTelefone
	 *            the enumTipoTelefone to set
	 */
	public void setEnumTipoTelefone(EnumTipoTelefone enumTipoTelefone) {
		this.enumTipoTelefone = enumTipoTelefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
