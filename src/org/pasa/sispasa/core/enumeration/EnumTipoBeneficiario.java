package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 */
public enum EnumTipoBeneficiario {
	
	TITULAR(1, "Titular"),
	DEPENDENTE(2, "Dependente");
	
	private int indice;
	private String descricao;
	
	private EnumTipoBeneficiario(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	public static EnumSet<EnumTipoBeneficiario> getAllTipoBeneficiario() {
        return EnumSet.of(TITULAR, DEPENDENTE);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
