package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 * 
 * @author Andre Gomes
 *
 */
public enum EnumTipoConta {

	CORRENTE(1,"Corrente"),
	POUPANCA(2,"Poupança"),
	SALARIO(3,"Salário");
	
	private int indice;
	private String descricao;
	
	
	private EnumTipoConta() {
	}

	private EnumTipoConta(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public static EnumSet<EnumTipoConta> getAllTipoConta() {
        return EnumSet.of(CORRENTE, POUPANCA, SALARIO);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
