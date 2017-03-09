package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 *
 */
public enum EnumTipoAposentadoria {

    /* Não mudar ordem do enum pois a entidade usa o EnumType ORDINAL. */
    VALIA("VALIA"),
    INSS("INSS"),
    VALIA_E_INSS("VALIA e INSS");

    private final String descricao;

    private EnumTipoAposentadoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
