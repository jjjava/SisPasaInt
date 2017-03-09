package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumMotivoDesligamento {

    SEM_JUSTA_CAUSA(1L, "Desligado sem justa causa"),
    COM_JUSTA_CAUSA(2L, "Desligado por justa causa"),
    ABANDONO(3L, "Desligado por abandono de emprego"),
    TERMINO_CONTRATO(4L, "Desligado por término de contrato"),
    APOSENTADORIA(5L, "Desligado por aposentadoria"),
    INVALIDEZ(6L, "Desligado por invalidez"),
    FALECIMENTO(7L, "Desligado por falecimento");

    private Long indice;
    private String descricao;

    private EnumMotivoDesligamento(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumMotivoDesligamento getFromIndice(Long indice) {
        for (EnumMotivoDesligamento enumMotivoDeslig : EnumMotivoDesligamento.values()) {
            if (enumMotivoDeslig.getIndice().equals(indice)) {
                return enumMotivoDeslig;
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
