package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoConvenio {

	ColetivoAdesao(0,"Coletivo por Adesão"),
	ColetivoEmpresarial(1, "Coletivo Empresarial");
	
	private int indice;
	private String descricao;
	
	TipoConvenio(int indice, String descricao) {
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