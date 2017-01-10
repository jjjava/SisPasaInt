package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumOperadora {

    PASA(1L, "PASA"),
    AMS(2L, "AMS");

    private Long indice;
    private String descricao;

    private EnumOperadora(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumOperadora getOperadoraByIndice(Long indice) {
        switch (indice.intValue()) {

            case 1:
                return EnumOperadora.PASA;

            case 2:
                return EnumOperadora.AMS;

            default:
                break;
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
