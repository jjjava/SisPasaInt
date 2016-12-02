package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumEstadoCivil {
	
	SOLTEIRO(1, "Solteiro"),
	CASADO(2, "Casado"),
	DIVORCIADO(3,"Divorciado"),
	DESQUITADO(4,"Desquitado"),
	VIUVO(5,"Viuvo");
	
	private int indice;
	private String descricao;
	
	private EnumEstadoCivil(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumEstadoCivil> getAllEstadoCivil() {
        return EnumSet.of(SOLTEIRO, CASADO, DIVORCIADO, DESQUITADO, VIUVO );
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
