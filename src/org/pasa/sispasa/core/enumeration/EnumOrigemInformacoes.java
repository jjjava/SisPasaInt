package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumOrigemInformacoes {
	
	MANUAL(1, "Manual"),
	CARGA(2, "Carga"),
	MANUAL_JUDICIAL(3,"Manual Judicial"),
	CARGA_JUDICIAL(4,"Carga Judicial");
	
	private int indice;
	private String descricao;
	
	private EnumOrigemInformacoes(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumOrigemInformacoes> getAllOrigemInformacoes() {
        return EnumSet.of(MANUAL, CARGA, MANUAL_JUDICIAL, CARGA_JUDICIAL);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
