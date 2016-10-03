package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoEmpresa {

	Coligada(0,"Coligada"),
	Congenere(1,"Congenre"),
	Reciprocidade(2,"Reciprocidade");
	
	private int indice;
	private String descricao;
	
	private TipoEmpresa(int indice, String descricao) {
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
