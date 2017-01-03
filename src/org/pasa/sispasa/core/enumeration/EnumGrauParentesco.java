package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumGrauParentesco {
	
	FILHO(1L, "Filho"),
	CONJUGE(2L, "Cônjugue"),
	NETO(3L,"Neto");
	
	private Long indice;
	private String descricao;
	
	private EnumGrauParentesco(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	
	//getters e setters
    public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
