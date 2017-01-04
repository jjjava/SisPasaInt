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

    /**
     *
     * @param indice
     * @return
     */
    public static EnumSexo getSexoByIndice(String indice) {
        if (indice.equals(EnumSexo.FEMININO.getIndice())) {
            return EnumSexo.FEMININO;
        } else {
            return EnumSexo.MASCULINO;
        }
    }

    //getters e setters
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
