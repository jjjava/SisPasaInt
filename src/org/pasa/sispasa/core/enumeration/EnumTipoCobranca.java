package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum EnumTipoCobranca {
	
    DebitoAutomatico(0,"Débito automático"),
	Boleto(1,"Boleto"),
	CartaoCredito(2,"Cartão crédito");
	
	private int indice;
	private String descricao;
	
	private EnumTipoCobranca(int indice, String descricao) {
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
 
