package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumTipoTaxa {

    LEGADO(0, "Legado"),
    PASA(1, "Padrão");

    private Integer id;
    private String descricao;

    private EnumTipoTaxa(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static EnumTipoTaxa[] valueAtivo() {
        return new EnumTipoTaxa[]{EnumTipoTaxa.PASA};
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getId() {
        return id;
    }
}
