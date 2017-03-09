package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 *
 */
public enum EnumTipoEmpresa {

    COLIGADA(1L, "Coligada"),
    CONGENERE(2L, "Congênere");

    private final Long indice;
    private final String descricao;

    private EnumTipoEmpresa(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumTipoEmpresa getTipoEmpresaByIndice(int indice) {
        switch (indice) {
            case 1:
                return EnumTipoEmpresa.COLIGADA;
            case 2:
                return EnumTipoEmpresa.CONGENERE;
            default:
                break;
        }
        return null;
    }

    //getters e setters
    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

}
