package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */

public enum EnumTipoResponsavel {

	TITULAR("T", "Titular"), 
	CURADOR("C", "Curador");

	private String indice;
	private String descricao;

	private EnumTipoResponsavel(String indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
