package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoAssociado {
	
	A("Ativo"),
	E("Ex-empregado ou aposentado"),		
	P("Pensionista"),
	R("Pré-PASA");
		
	private String descricao;
	
	private EnumTipoAssociado(String descricao) {					
		this.descricao = descricao;
	}		

	public String getDescricao() {
		return descricao;
	}
}
