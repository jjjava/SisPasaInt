package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnunTipoPlano {

    Medico(0, "Médico"),
    Odontologico(1, "Odontológico"),
    Ambos(2, "Médico e Odontológico");

    private final int indice;
    private final String descricao;

    private EnunTipoPlano(int indice, String descricao) {
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
