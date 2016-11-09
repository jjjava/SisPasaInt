package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnunTipoBeneficiario {

    Titular(0, "Titular"),
    Dependente(1, "Dependente"),
    Agregado(2, "Agregado");

    private final int indice;
    private final String descricao;

    private EnunTipoBeneficiario(int indice, String descricao) {
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
