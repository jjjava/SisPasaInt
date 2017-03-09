package org.pasa.sispasa.core.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre Gomes
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public enum EnumTipoPagamento {

    DESCONTO_EM_FOLHA(1L, "Desconto em Folha", EnumTipoPagador.EMPRESA),
    NOTA_DE_DEBITO(2L, "Nota de Débito", EnumTipoPagador.EMPRESA),
    BOLETO(3L, "Boleto", EnumTipoPagador.TODOS),
    DEBITO_AUTOMATICO(4L, "Debito Automático", EnumTipoPagador.USUARIO),
    CARTAO_DE_CREDITO(5L, "Cartão de Crédito", EnumTipoPagador.USUARIO),
    DESCONTO_VALIA(6L, "Desconto VALIA", EnumTipoPagador.USUARIO);

    private final Long indice;
    private final String descricao;
    private final EnumTipoPagador tpPagador;

    EnumTipoPagamento(Long indice, String descricao, EnumTipoPagador tpPagador) {
        this.indice = indice;
        this.descricao = descricao;
        this.tpPagador = tpPagador;
    }

    public static List<EnumTipoPagamento> getListaPorTipoPagador(EnumTipoPagador tpPg) {

        List<EnumTipoPagamento> lista = new ArrayList<>();
        for (EnumTipoPagamento e : EnumTipoPagamento.values()) {
            if (tpPg.equals(e.tpPagador) || EnumTipoPagador.TODOS.equals(e.getTpPagador())) {
                lista.add(e);
            }
        }
        return lista;
    }

    public static EnumTipoPagamento getFromIndice(Long indice) {
        for (EnumTipoPagamento tipoPag : EnumTipoPagamento.values()) {
            if (tipoPag.getIndice().equals(indice)) {
                return tipoPag;
            }
        }
        return null;
    }

    // GETTERS
    public Long getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

    public EnumTipoPagador getTpPagador() {
        return tpPagador;
    }
}
