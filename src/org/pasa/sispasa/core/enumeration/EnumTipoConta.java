package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 *
 */
public enum EnumTipoConta {

    CORRENTE("C", "Corrente"),
    POUPANCA("P", "Poupança"),
    SALARIO("S", "Salário");

    private final String indice;
    private final String descricao;

    private EnumTipoConta(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumTipoConta getTipoContaByIndice(String indice) {
        for (EnumTipoConta enumTipoConta : EnumTipoConta.values()) {
            if (indice.equals(enumTipoConta.getIndice())) {
                return enumTipoConta;
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
