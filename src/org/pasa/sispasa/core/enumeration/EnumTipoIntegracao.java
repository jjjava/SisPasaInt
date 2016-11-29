package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

public enum EnumTipoIntegracao {

	People(0,"People Software"),
	Valia(1,"Valia"),
	Externa(2,"Empresa externa");
	
	private int indice;
	private String descricao;
	
	private EnumTipoIntegracao(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
