package org.pasa.sispasaint.model.enun;

/**
 *
 * @author 90J00318
 */
public enum  EnunOperadora {
    AMS(0,"AMS"),
    PASA(1, "PASA");
    
    private final int indice;
    private final String descricao;

    private EnunOperadora(int indice, String descricao) {
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
