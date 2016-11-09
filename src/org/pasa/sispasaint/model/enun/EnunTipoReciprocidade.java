package org.pasa.sispasaint.model.enun;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum EnunTipoReciprocidade {

	PASA(0,"PASA"),
	RedeConveniada(1, "Rede Conveniada");
	
	private int indice;
	private String descricao;
	
	EnunTipoReciprocidade(int indice, String descricao) {
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
