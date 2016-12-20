package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 *
 * @author Andre Gomes
 *
 */
public enum EnumTipoConta {

    CORRENTE("C", "Corrente"),
    POUPANCA("P", "Poupança"),
    SALARIO("S", "Salário");

    private String indice;
    private String descricao;

    private EnumTipoConta(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    /**
     *
     * @param indice
     * @return
     */
    public static EnumTipoConta getTipoContaByIndice(String indice) {
        for (EnumTipoConta enumTipoConta : getAllTipoConta()) {
            if (indice.equals(enumTipoConta.getIndice())) {
                return enumTipoConta;
            }
        }
        return null;
    }

    public static EnumSet<EnumTipoConta> getAllTipoConta() {
        return EnumSet.of(CORRENTE, POUPANCA, SALARIO);
    }

    //getters e setters
    public String getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

}
