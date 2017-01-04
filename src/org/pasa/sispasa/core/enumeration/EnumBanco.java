package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumBanco {

    ITAU("347", "Itaú"),
    BRADESCO("237", "Bradesco"),
    SANTANDER("341", "Santander");

    private String indice;
    private String descricao;

    private EnumBanco(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    /**
     *
     * @param indice
     * @return
     */
    public static EnumBanco getBancoByIndice(String indice) {
        for (EnumBanco enumBanco : EnumBanco.values()) {
            if (indice.equals(enumBanco.getIndice())) {
                return enumBanco;
            }
        }
        return null;
    }

    //getters e setters
    public String getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
