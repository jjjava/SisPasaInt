package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoVinculoBeneficio {

    Titular(1L, "Titular"),
    Dependente(2L, "Dependente"),
    Agregado(3L, "Agregado");

    private Long indice;
    private String descricao;

    private EnumTipoVinculoBeneficio(Long indice, String descricao) {
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
