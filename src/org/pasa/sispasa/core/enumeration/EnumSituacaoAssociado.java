package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Allan Garcia
 */
public enum EnumSituacaoAssociado {

    CADASTRO_INCOMPLETO(1L, "Cadastro Incompleto"),
    PRE_CADASTRO(2L, "Pré-Cadastro"),
    ATIVO_SEM_DEBITO(3L, "Ativo sem Débito"),
    ATIVO_COM_DEBITO(4L, "Ativo com Débito"),
    INATIVO(5L, "Inativo");

    private Long indice;
    private String descricao;

    private EnumSituacaoAssociado(Long indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public static EnumSituacaoAssociado getFromIndice(Long indice) {
        for (EnumSituacaoAssociado enumSituacao : EnumSituacaoAssociado.values()) {
            if (enumSituacao.getIndice().equals(indice)) {
                return enumSituacao;
            }
        }
        return null;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
