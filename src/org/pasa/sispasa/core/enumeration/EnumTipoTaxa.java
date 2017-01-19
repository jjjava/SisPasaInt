package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoTaxa {

	PASA(1, "Padrão"), 
	LEGADO(0, "Legado");

	private Integer indAtivo;
	private String descricao;

	private EnumTipoTaxa(Integer indAtivo, String descricao) {
		this.indAtivo = indAtivo;
		this.descricao = descricao;
	}

	public static EnumTipoTaxa[] valueAtivo() {
		return new EnumTipoTaxa[] {EnumTipoTaxa.PASA};
	}

	public Integer getIndAtivo() {
		return indAtivo;
	}

	public String getDescricao() {
		return descricao;
	}

}
