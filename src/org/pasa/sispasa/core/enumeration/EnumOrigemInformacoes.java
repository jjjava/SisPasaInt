package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumOrigemInformacoes {

    MANUAL(1L, "Manual"),
    CARGA(2L, "Carga"),
    MANUAL_JUDICIAL(3L, "Manual Judicial"),
    CARGA_JUDICIAL(4L, "Carga Judicial");

    private Long indice;
    private String descricao;

    private EnumOrigemInformacoes(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumOrigemInformacoes getOrigemInformacoesByIndice(int indice) {

        switch (indice) {

            case 1:
                return EnumOrigemInformacoes.MANUAL;

            case 2:
                return EnumOrigemInformacoes.CARGA;

            case 3:
                return EnumOrigemInformacoes.MANUAL_JUDICIAL;

            case 4:
                return EnumOrigemInformacoes.CARGA_JUDICIAL;

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
