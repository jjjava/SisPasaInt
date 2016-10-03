package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoReciprocidade {

	PASA(0,"PASA"),
	RedeConveniada(1, "Rede Conveniada");
	
	private int indice;
	private String descricao;
	
	TipoReciprocidade(int indice, String descricao) {
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
