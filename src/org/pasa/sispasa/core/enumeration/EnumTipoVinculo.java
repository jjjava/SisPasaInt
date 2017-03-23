package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoVinculo {

    Titular(1, "Titular"),
    Dependente(2, "Dependente"),
    Agregado(3, "Agregado");

    private int indice;
    private String descricao;

    private EnumTipoVinculo(int indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public int getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

}
