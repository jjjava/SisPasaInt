package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */

public enum EnumSexo {

	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino");
	
	private int indice;
	private String descricao;
	
	private EnumSexo(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumSexo> getAllSexo() {
        return EnumSet.of(MASCULINO, FEMININO);
    }



	//getters e setters
	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


}
