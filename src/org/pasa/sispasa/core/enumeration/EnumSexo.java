package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumSexo {

    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private String indice;
    private String descricao;

    private EnumSexo(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

	public static EnumSexo getSexoByIndice(String id) {
		for (EnumSexo enumSexo : EnumSexo.values()) {
			if (enumSexo.indice.equals(id)) {
				return enumSexo;
			}
		}
		return null;
	}
       
    /**
     * @return the indice
     */
    public String getIndice() {
        return indice;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
}
