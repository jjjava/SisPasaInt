package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum TipoBeneficiario {

    Titular(0, "Titular"),
    Dependente(1, "Dependente"),
    Agregado(2, "Agregado");

    private final int indice;
    private final String descricao;

    private TipoBeneficiario(int indice, String descricao) {
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
