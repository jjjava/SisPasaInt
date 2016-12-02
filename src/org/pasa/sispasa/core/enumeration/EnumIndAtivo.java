package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumIndAtivo {
	
	ATIVO(1, "Ativo"),
	INATIVO(0, "Inativo"),
	TODOS(2,"Todos");
	
	private int indice;
	private String descricao;
	
	private EnumIndAtivo(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	
	public static EnumIndAtivo getIndAtivoByIndice(int indice){
		
		switch (indice) {
			
			case 0:
				return EnumIndAtivo.INATIVO;
				
			case 1:
				return EnumIndAtivo.ATIVO;
			
			case 2:
				return EnumIndAtivo.TODOS;

			default:
				break;
		}
		
		return null;
	}
	
	public static EnumSet<EnumIndAtivo> getAllIndAtivo() {
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
