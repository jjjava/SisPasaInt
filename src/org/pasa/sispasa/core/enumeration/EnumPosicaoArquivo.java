package org.pasa.sispasa.core.enumeration;

public enum EnumPosicaoArquivo {

    COD_EMPRESA(0, 2),
    CARTEIRINHA(0, 10),
    MATRICULA_ASSOCIADO(2, 8),
    NOME_ASSOCIADO(322, 372),
    CPF(234, 245),
    CELULAR(10, 27),
    TEL_RESIDENCIAL(27, 39),
    TEL_COMERCIAL(39, 51),
    COD_BENEFICIARIO(8, 10),
    LOGRADOURO(59, 109),
    BAIRRO(109, 139),
    MUNICIPIO(139, 169),
    ESTADO(169, 171),
    CEP(171, 179),
    EMAIL(179, 210);

    private EnumPosicaoArquivo(Integer posicaoInicial, Integer posicaoFinal) {
        this.posicaoInicial = posicaoInicial;
        this.posicaoFinal = posicaoFinal;
    }
    private Integer posicaoInicial;
    private Integer posicaoFinal;

    public Integer getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Integer posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public Integer getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(Integer posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }
}
