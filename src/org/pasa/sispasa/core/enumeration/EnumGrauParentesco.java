package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumGrauParentesco {
	
	FILHO(1L, "Filho"),
	CONJUGE(2L, "Conjuge"),
	NETO(3L,"Neto");
	
	private Long indice;
	private String descricao;
	
	private EnumGrauParentesco(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	public static EnumSet<EnumGrauParentesco> getAllGrauParentesco() {
        return EnumSet.of(FILHO, CONJUGE, NETO);
    }
	
	//getters e setters
    public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
