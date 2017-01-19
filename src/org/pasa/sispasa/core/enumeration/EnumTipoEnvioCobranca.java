package org.pasa.sispasa.core.enumeration;

/**
 * 
 * @author Allan Garcia
 *
 */
public enum EnumTipoEnvioCobranca {

	E("Email"), 
	C("Correios");

	private String descricao;

	private EnumTipoEnvioCobranca(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
