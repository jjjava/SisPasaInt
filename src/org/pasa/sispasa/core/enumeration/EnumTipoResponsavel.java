package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */

public enum EnumTipoResponsavel {

	T("Titular"), 
	C("Curador");

	private String descricao;

	private EnumTipoResponsavel(String descricao) {

		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
