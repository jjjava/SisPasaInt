package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum Sexo {

    Masculino(0, 'M'),
    Feminino(1, 'F');

    private final int indice;
    private final char descricao;

    private Sexo(int indice, char descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public int getIndice() {
        return indice;
    }

    public char getDescricao() {
        return descricao;
    }
}
