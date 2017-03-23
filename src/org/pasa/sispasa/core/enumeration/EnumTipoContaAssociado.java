package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoContaAssociado {
	
	P("Pagamento"),
	R("Reembolso");	
		
	private String descricao;
	
	private EnumTipoContaAssociado(String descricao) {		
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
