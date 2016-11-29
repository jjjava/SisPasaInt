package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
*
* @author Andre Gomes
*/

public enum EnumNivelEscolaridade {

	FUNDAMENTAL(1,"Ensino Fundamental"),
	MEDIO(2,"Ensino Médio"),
	SUPERIOR(3,"Ensino Superior"),
	POS(4,"Pós Graduação"),
	MESTRADO(5,"Mestrado"),
	DOUTORADO(6,"Doutorado");
	
	private int indice;
	private String descricao;
	
	private EnumNivelEscolaridade(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumNivelEscolaridade> getAllNivelEscolaridade() {
        return EnumSet.of(FUNDAMENTAL, MEDIO, SUPERIOR, POS, MESTRADO, DOUTORADO);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
