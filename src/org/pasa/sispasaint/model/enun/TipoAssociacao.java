package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum TipoAssociacao {

    AMS(0, "AMS"),
    PASA(1, "PASA");

    private final int indice;
    private final String descricao;

    private TipoAssociacao(int indice, String descricao) {
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
