package org.pasa.sispasaint.model.enun;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoEmpresa {

	Coligada(0,"Coligada"),
	Congenere(1,"Congenre"),
	Reciprocidade(2,"Reciprocidade");
	
	private final int indice;
	private final String descricao;
	
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
