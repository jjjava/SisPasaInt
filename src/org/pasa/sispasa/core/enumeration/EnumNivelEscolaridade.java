package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
*
* @author Andre Gomes
*/

public enum EnumNivelEscolaridade {

	FUNDAMENTAL(1,"Ensino Fundamental"),
	MEDIO(2,"Ensino Medio"),
	SUPERIOR(3,"Ensino Superior"),
	POS(4,"Pos Graduacao"),
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
	 * @param indice
	 * @return
	 */
	public static EnumNivelEscolaridade getNivelEscolaridadeByIndice(int indice){
		
		switch (indice) {
			
			case 1:
				return EnumNivelEscolaridade.FUNDAMENTAL;
				
			case 2:
				return EnumNivelEscolaridade.MEDIO;
			
			case 3:
				return EnumNivelEscolaridade.SUPERIOR;
				
			case 4:
				return EnumNivelEscolaridade.POS;
				
			case 5:
				return EnumNivelEscolaridade.MESTRADO;
				
			case 6:
				return EnumNivelEscolaridade.DOUTORADO;

			default:
				break;
		}
		
		return null;
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
