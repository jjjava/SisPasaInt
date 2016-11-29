package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumGrauParentesco {
	
	FILHO(1, "Filho"),
	CONJUGE(2, "Cônjuge"),
	NETO(3,"Neto");
	
	private int indice;
	private String descricao;
	
	private EnumGrauParentesco(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	public static EnumSet<EnumGrauParentesco> getAllGrauParentesco() {
        return EnumSet.of(FILHO, CONJUGE, NETO);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
