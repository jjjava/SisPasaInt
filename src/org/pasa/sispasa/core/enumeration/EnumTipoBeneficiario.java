package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 * @author Hudson Schumaker
 */
public enum EnumTipoBeneficiario {

    TITULAR("T", "Titular"),
    DEPENDENTE("D", "Dependente");

    private String indice;
    private String descricao;

    private EnumTipoBeneficiario(String indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumTipoBeneficiario getTipoBeneficiarioByIndice(String indice) {

        if ("T".equals(indice)) {
            return EnumTipoBeneficiario.TITULAR;
        }
        return EnumTipoBeneficiario.DEPENDENTE;
    }

    //getters e setters
    public String getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
