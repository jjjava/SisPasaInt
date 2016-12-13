package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumBanco {
	
	ITAU("347", "Itaú"),
	BRADESCO("237", "Bradesco"),
	SANTANDER("341","Santander");
	
	private String indice;
	private String descricao;
	
	private EnumBanco(String indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumBanco getBancoByIndice(String indice){
		for (EnumBanco enumBanco : getAllBanco()) {
			if(indice.equals(enumBanco.getIndice())){
				return enumBanco;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumBanco> getAllBanco() {
        return EnumSet.of(ITAU, BRADESCO, SANTANDER);
    }
	
	//getters e setters
    public String getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
