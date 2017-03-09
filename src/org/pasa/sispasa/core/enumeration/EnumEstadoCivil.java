package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumEstadoCivil {

    SOLTEIRO(1L, "Solteiro"),
    CASADO(2L, "Casado"),
    DIVORCIADO(3L, "Divorciado"),
    DESQUITADO(4L, "Desquitado"),
    VIUVO(5L, "Viúvo");

    private Long indice;
    private String descricao;

    private EnumEstadoCivil(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumEstadoCivil getEstadoCivilByIndice(Long indice) {
        for (EnumEstadoCivil enumEstadoCivil : EnumEstadoCivil.values()) {
            if (enumEstadoCivil.indice.equals(indice)) {
                return enumEstadoCivil;
            }
        }
        return null;
    }

    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

}
