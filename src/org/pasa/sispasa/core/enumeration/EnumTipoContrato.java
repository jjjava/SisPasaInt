package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
public enum EnumTipoContrato {

    INDIVIDUAL(1L, "Individual"),
    COLETIVO_POR_ADESAO(2L, "Coletivo por Adesão"),
    COLETIVO_EMPRESARIAL(3L, "Coletivo Empresarial");

    private final Long indice;
    private final String descricao;

    EnumTipoContrato(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumTipoContrato getTipoContratoByIndice(Long indice) {

        switch (indice.intValue()) {
            case 1:
                return EnumTipoContrato.INDIVIDUAL;
            case 2:
                return EnumTipoContrato.COLETIVO_POR_ADESAO;

            case 3:
                return EnumTipoContrato.COLETIVO_EMPRESARIAL;
            default:
                break;
        }
        return null;
    }

    //GETTERS E SETTERS
    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }
}
