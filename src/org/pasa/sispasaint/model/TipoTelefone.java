package org.pasa.sispasaint.model;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum TipoTelefone {

    Fixo(0, "Fixo"),
    Celular(1, "Celular"),
    Comercial(2, "Comercial"),
    Fax(3, "Fax");

    private final int indice;
    private final String descricao;

    private TipoTelefone(int indice, String descricao) {
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
