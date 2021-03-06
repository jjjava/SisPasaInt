package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumOperadora {

	AMS(1L, "AMS"),
    PASA(2L, "PASA");

    private Long indice;
    private String descricao;

    private EnumOperadora(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumOperadora getOperadoraByIndice(Long indice) {
    	for (EnumOperadora enumOperadora : EnumOperadora.values()) {
			if (enumOperadora.getIndice().equals(indice)) {
				return enumOperadora;
			}
		}
		return null;
    }
    
    

    //getters e setters
    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
