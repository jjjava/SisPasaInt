package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumStatus {
	
	ATIVO(1, "Ativo"),
	INATIVO(0, "Inativo"),
	TODOS(2,"Todos");
	
	private int indice;
	private String descricao;
	
	private EnumStatus(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	
	public static EnumStatus getStatusByValue(int value){
		
		switch (value) {
			
			case 0:
				return EnumStatus.INATIVO;
				
			case 1:
				return EnumStatus.ATIVO;
			
			case 2:
				return EnumStatus.TODOS;

			default:
				break;
		}
		
		return null;
	}
	
	public static EnumSet<EnumStatus> getAllStatus() {
        return EnumSet.of(ATIVO, INATIVO, TODOS);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
