package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

public enum TipoVinculoBeneficio {
	
	Titular(0,"Titular"),
	Dependente(1,"Dependente"),
	Agregado(2,"Agregado");
	
	private int indice;
	private String descricao;
	
	private TipoVinculoBeneficio(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}

}
