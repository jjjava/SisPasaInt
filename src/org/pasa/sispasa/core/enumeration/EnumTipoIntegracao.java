package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoIntegracao {

    People(0L, "People Software"),
    Valia(1L, "Valia"),
    Externa(2L, "Empresa externa");

    private Long indice;
    private String descricao;

    private EnumTipoIntegracao(Long indice, String descricao) {
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
