package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum NivelEscolaridade {

    Sem(0,"Sem Instrução"),
    Fundamental(1, "Ensio Fundamental"),
    Medio(2, "Ensino Médio"),
    Superior(3, "Ensino Superior");

    
    private final int indice;
    private final String descricao;

    private NivelEscolaridade(int indice, String descricao) {
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
