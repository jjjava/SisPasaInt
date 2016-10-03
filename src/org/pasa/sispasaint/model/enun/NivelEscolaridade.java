package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0 
*/

public enum NivelEscolaridade {

	Fundamental(0,"Ensio Fundamental"),
	Médio(1,"Ensino Médio"),
	Superior(2,"Ensino Superior"),
	Pos(3,"Pós Graduação"),
	Mestrado(4,"Mestrado"),
	Doutorado(5,"Doutorado");
	
	private int indice;
	private String descricao;
	
	private NivelEscolaridade(int indice, String descricao) {
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
