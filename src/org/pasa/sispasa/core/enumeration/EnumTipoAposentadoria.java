package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoAposentadoria {

	V("VALIA"), I("INSS");

	private String descricao;

	private EnumTipoAposentadoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
