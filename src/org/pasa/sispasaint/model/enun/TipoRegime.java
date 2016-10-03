package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoRegime {
	
	Reembolso(0,"Reembolso"),
	Credenciamento(1,"Credenciamento"),
	Ambos(2,"Ambos");
	
	private int indice;
	private String descricao;
	
	private TipoRegime(int indice, String descricao) {
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
