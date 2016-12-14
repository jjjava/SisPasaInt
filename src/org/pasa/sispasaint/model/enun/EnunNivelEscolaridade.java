package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnunNivelEscolaridade {

    Sem(0L,"Sem Instrução"),
    Fundamental(1L, "Ensio Fundamental"),
    Medio(2L, "Ensino Médio"),
    Superior(3L, "Ensino Superior");

    
    private final Long indice;
    private final String descricao;

    private EnunNivelEscolaridade(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
