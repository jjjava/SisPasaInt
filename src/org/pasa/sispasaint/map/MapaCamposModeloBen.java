package org.pasa.sispasaint.map;

import java.util.HashMap;
import java.util.Map;
import org.pasa.sispasaint.rw.PosicaoCampo;

/**
 *
 * @author Hudson Schumker
 * @version 1.0.0
 */
public class MapaCamposModeloBen {

    private Map<String, PosicaoCampo> mapa;

    public MapaCamposModeloBen() {
        mapa = new HashMap<>();
        mapa.put(CamposModelo.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(CamposModelo.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(CamposModelo.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        mapa.put(CamposModelo.DIREITO_AMS_CREDENCIAMENTO, new PosicaoCampo(11, 12));
        mapa.put(CamposModelo.DATA_VALIDADE_CREDENCIADO, new PosicaoCampo(12, 22));
        mapa.put(CamposModelo.DIREITO_AMS_REEMBOLSO, new PosicaoCampo(22, 23));
        mapa.put(CamposModelo.DATA_VALIDADE_REEMBOLSO, new PosicaoCampo(23, 33));
        mapa.put(CamposModelo.DATA_DE_ATUALIZACAO, new PosicaoCampo(33, 43));
        mapa.put(CamposModelo.NOME_BENEFICIARIO_ABREVIADO, new PosicaoCampo(43, 66));
        mapa.put(CamposModelo.CODIGO_CR, new PosicaoCampo(67, 74));
        mapa.put(CamposModelo.ORGAO_PESSOAL, new PosicaoCampo(75, 76));
        mapa.put(CamposModelo.VINCULO, new PosicaoCampo(76, 77));
        mapa.put(CamposModelo.PLANO, new PosicaoCampo(77, 78));
        mapa.put(CamposModelo.FAIXA_NIVEL, new PosicaoCampo(78, 79));
        mapa.put(CamposModelo.DATA_NASCIMENTO, new PosicaoCampo(80, 90));
        mapa.put(CamposModelo.DIREITO_ABATER_IR, new PosicaoCampo(90, 91));
        mapa.put(CamposModelo.NUCLEO_DA_AMS, new PosicaoCampo(91, 92));
        mapa.put(CamposModelo.AGENCIA_BANCARIA, new PosicaoCampo(93, 97));
        mapa.put(CamposModelo.BANCO, new PosicaoCampo(98, 101));
        mapa.put(CamposModelo.CONTA_CORRENTE, new PosicaoCampo(101, 111));
        mapa.put(CamposModelo.DATA_ADMISSAO, new PosicaoCampo(112, 122));
        mapa.put(CamposModelo.GRAU_PARENTESCO, new PosicaoCampo(122, 123));
        mapa.put(CamposModelo.FINACEIRA, new PosicaoCampo(123, 124));
        mapa.put(CamposModelo.CONTRATO_TRABALHO, new PosicaoCampo(124, 125));
        mapa.put(CamposModelo.SEXO, new PosicaoCampo(125, 126));
        mapa.put(CamposModelo.EMPRESA_ATUALIZADOR, new PosicaoCampo(126, 127));
        mapa.put(CamposModelo.MATRICULA_ATUALIZADOR, new PosicaoCampo(128, 133));
        mapa.put(CamposModelo.TIPO_BENEFICIARIO, new PosicaoCampo(134, 135));
        mapa.put(CamposModelo.CODIGO_DIREITO_PASA, new PosicaoCampo(135, 136));
        mapa.put(CamposModelo.GRAU_ESCOLARIDADE, new PosicaoCampo(136, 137));
        mapa.put(CamposModelo.INDICAR_CONCLUSAO, new PosicaoCampo(137, 138));
        mapa.put(CamposModelo.DATA_FALECIMENTO, new PosicaoCampo(138, 148));
        mapa.put(CamposModelo.MATRICULA_PASA, new PosicaoCampo(148, 153));
        mapa.put(CamposModelo.NOME_DA_MAE, new PosicaoCampo(154, 223));
        mapa.put(CamposModelo.PIS, new PosicaoCampo(224, 234));
        mapa.put(CamposModelo.CPF, new PosicaoCampo(235, 246));
        mapa.put(CamposModelo.EMPRESA_ORIGEM, new PosicaoCampo(246, 247));
        mapa.put(CamposModelo.MATRICULA_ORIGEM, new PosicaoCampo(248, 253));
        mapa.put(CamposModelo.EMPRESA_PEOPLE, new PosicaoCampo(254, 257));
        mapa.put(CamposModelo.MATRICULA_PEOPLE, new PosicaoCampo(257, 264));
        mapa.put(CamposModelo.UNIDADE_DE_CONTROLE, new PosicaoCampo(264, 266));
        mapa.put(CamposModelo.CENTRO_DE_CUSTO, new PosicaoCampo(267, 278));
        mapa.put(CamposModelo.MATRICULA_PARTICIPANTE, new PosicaoCampo(279, 284));
        mapa.put(CamposModelo.MATRICULA_REPRESENTANTE_LEGAL, new PosicaoCampo(285, 290));
        mapa.put(CamposModelo.NOME_BENEFICIARIO, new PosicaoCampo(291, 340));
        mapa.put(CamposModelo.PLANO_DE_RECIPROCIDADE_CASSI, new PosicaoCampo(341, 341));
        mapa.put(CamposModelo.CODIGO_NACIONAL_DE_SAUDE, new PosicaoCampo(342, 356));
        mapa.put(CamposModelo.DECLARACAO_NASCIDO_VIVO, new PosicaoCampo(357, 367));
        mapa.put(CamposModelo.CASSI_DATA, new PosicaoCampo(368, 377));//fim direito ao plano
        mapa.put(CamposModelo.BRANCO, new PosicaoCampo(378, 396));
        mapa.put(CamposModelo.CODIGO_FILIAL_VLI, new PosicaoCampo(397, 400));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, PosicaoCampo> mapa) {
        this.mapa = mapa;
    }
}
