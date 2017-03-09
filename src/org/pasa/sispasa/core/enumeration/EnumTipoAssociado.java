package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoAssociado {

    A("Ativo"),
    E("Ex-empregado/Aposentado"),
    P("Pensionista"),
    R("Pré-PASA");

    private final String descricao;

    private EnumTipoAssociado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
