package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum  EnunOperadora {
    AMS(0L,"AMS"),
    PASA(1L, "PASA");
    
    private final Long indice;
    private final String descricao;

    private EnunOperadora(Long indice, String descricao) {
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
