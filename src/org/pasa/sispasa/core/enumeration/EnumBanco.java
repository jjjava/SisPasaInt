package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumBanco {
	
	ITAU("1", "Itaú"),
	BRADESCO("2", "Brasdeco"),
	SANTANDER("3","Santander"),
	BANCO_DO_BRASIL("4","Banco do Brasil"),
	CAIXA_ECONOMICA("5","Caixa Econômica Federal");
	
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
			if(indice.equals(enumBanco.getDescricao())){
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
        return EnumSet.of(ITAU, BRADESCO, SANTANDER, BANCO_DO_BRASIL, CAIXA_ECONOMICA );
    }
	
	//getters e setters
    public String getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
