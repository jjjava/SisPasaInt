package org.pasa.sispasaint.model.enun;

/**
 *
 * @author 90J00318
 */
public enum EnunTipoDocumento {
    RG(0, "Identidade"),
    CPF(1, "CPF"),
    PIS(2, "PIS"),
    CNH(3, "Carnteira Nacional de Habilitação"),
    CarteiraTrabalho(4, "Carteira de Trabalho"),
    Passaporte(5, "Passaporte");
    
    private final int indice;
    private final String descricao;
    
    private EnunTipoDocumento(int indice, String descricao) {
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
