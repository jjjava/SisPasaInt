package org.pasa.sispasaint.model.enun;

/**
 *
 * @author 90J00318
 */
public enum TipoDocumento {
    RG(0, "Identidade"),
    CPF(1, "Ensino Médio"),
    PIS(2, "Ensino Superior"),
    CNH(3, "Carnteira Nacional de Habilitação"),
    CarteiraTrabalho(4, "Pós Graduação"),
    Passaporte(5, "Passaporte");
    
    private final int indice;
    private final String descricao;
    
    private TipoDocumento(int indice, String descricao) {
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
