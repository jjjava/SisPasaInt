package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumSimNao {

    /* Não mudar ordem do enum pois a entidade usa o EnumType ORDINAL. */
    NAO(0, "Nao"),
    SIM(1, "Sim");

    private Integer indice;
    private String descricao;

    private EnumSimNao(Integer indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumSimNao valueFromIndice(int indice) {
        for (EnumSimNao enumSimNao : EnumSimNao.values()) {
            if (enumSimNao.indice == indice) {
                return enumSimNao;
            }
        }
        return null;
    }

    public Integer getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

}
