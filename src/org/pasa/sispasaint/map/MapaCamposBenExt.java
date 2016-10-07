package org.pasa.sispasaint.map;

import java.util.HashMap;
import java.util.Map;
import org.pasa.sispasaint.rw.PosicaoCampo;

/**
 *
 * @author hudson schumaker
 */
public class MapaCamposBenExt {

    private Map<String, PosicaoCampo> mapa;

    public MapaCamposBenExt() {
        mapa = new HashMap<>();
         mapa.put(CamposBenVLI.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(CamposBenVLI.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(CamposBenVLI.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        mapa.put(CamposBenVLI.DIREITO_AMS_CREDENCIAMENTO, new PosicaoCampo(11, 12));
        mapa.put(CamposBenVLI.DATA_VALIDADE_CREDENCIADO, new PosicaoCampo(12, 22));
        mapa.put(CamposBenVLI.DIREITO_AMS_REEMBOLSO, new PosicaoCampo(22, 23));
        mapa.put(CamposBenVLI.DATA_VALIDADE_REEMBOLSO, new PosicaoCampo(23, 33));
        mapa.put(CamposBenVLI.DATA_DE_ATUALIZACAO, new PosicaoCampo(33, 43));
        mapa.put(CamposBenVLI.NOME_BENEFICIARIO_ABREVIADO, new PosicaoCampo(43, 66));
        mapa.put(CamposBenVLI.CODIGO_CR, new PosicaoCampo(67, 74));
        mapa.put(CamposBenVLI.ORGAO_PESSOAL, new PosicaoCampo(75, 76));
        mapa.put(CamposBenVLI.VINCULO, new PosicaoCampo(76, 77));
        mapa.put(CamposBenVLI.PLANO, new PosicaoCampo(77, 78));
        mapa.put(CamposBenVLI.FAIXA_NIVEL, new PosicaoCampo(78, 79));
        mapa.put(CamposBenVLI.DATA_NASCIMENTO, new PosicaoCampo(80, 90));
        mapa.put(CamposBenVLI.DIREITO_ABATER_IR, new PosicaoCampo(90, 91));
        mapa.put(CamposBenVLI.NUCLEO_DA_AMS, new PosicaoCampo(91, 92));
        mapa.put(CamposBenVLI.AGENCIA_BANCARIA, new PosicaoCampo(93, 97));
        mapa.put(CamposBenVLI.BANCO, new PosicaoCampo(98, 100));
        mapa.put(CamposBenVLI.CONTA_CORRENTE, new PosicaoCampo(101, 111));
        mapa.put(CamposBenVLI.DATA_ADMISSAO, new PosicaoCampo(112, 122));
        mapa.put(CamposBenVLI.GRAU_PARENTESCO, new PosicaoCampo(122, 123));
        mapa.put(CamposBenVLI.FINACEIRA, new PosicaoCampo(123, 124));
        mapa.put(CamposBenVLI.CONTRATO_TRABALHO, new PosicaoCampo(124, 125));
        mapa.put(CamposBenVLI.SEXO, new PosicaoCampo(125, 126));
        mapa.put(CamposBenVLI.EMPRESA_ATUALIZADOR, new PosicaoCampo(126, 127));
        mapa.put(CamposBenVLI.MATRICULA_ATUALIZADOR, new PosicaoCampo(128, 133));
        mapa.put(CamposBenVLI.TIPO_BENEFICIARIO, new PosicaoCampo(134, 135));
        mapa.put(CamposBenVLI.CODIGO_DIREITO_PASA, new PosicaoCampo(135, 136));
        mapa.put(CamposBenVLI.GRAU_ESCOLARIDADE, new PosicaoCampo(136, 137));
        mapa.put(CamposBenVLI.INDICAR_CONCLUSAO, new PosicaoCampo(137, 138));
        mapa.put(CamposBenVLI.DATA_FALECIMENTO, new PosicaoCampo(138, 148));
        mapa.put(CamposBenVLI.MATRICULA_PASA, new PosicaoCampo(148, 153));
        mapa.put(CamposBenVLI.NOME_DA_MAE, new PosicaoCampo(154, 223));
        mapa.put(CamposBenVLI.PIS, new PosicaoCampo(224, 234));
        mapa.put(CamposBenVLI.CPF, new PosicaoCampo(235, 246));
        mapa.put(CamposBenVLI.EMPRESA_ORIGEM, new PosicaoCampo(246, 247));
        mapa.put(CamposBenVLI.MATRICULA_ORIGEM, new PosicaoCampo(248, 253));
        mapa.put(CamposBenVLI.EMPRESA_PEOPLE, new PosicaoCampo(254, 256));
        mapa.put(CamposBenVLI.MATRICULA_PEOPLE, new PosicaoCampo(257, 263));
        mapa.put(CamposBenVLI.UNIDADE_DE_CONTROLE, new PosicaoCampo(264, 266));
        mapa.put(CamposBenVLI.CENTRO_DE_CUSTO, new PosicaoCampo(267, 278));
        mapa.put(CamposBenVLI.MATRICULA_PARTICIPANTE, new PosicaoCampo(279, 284));
        mapa.put(CamposBenVLI.MATRICULA_REPRESENTANTE_LEGAL, new PosicaoCampo(285, 290));
        mapa.put(CamposBenVLI.NOME_BENEFICIARIO, new PosicaoCampo(291, 340));
        mapa.put(CamposBenVLI.PLANO_DE_RECIPROCIDADE_CASSI, new PosicaoCampo(341, 341));
        mapa.put(CamposBenVLI.CODIGO_NACIONAL_DE_SAUDE, new PosicaoCampo(342, 356));
        mapa.put(CamposBenVLI.DECLARACAO_NASCIDO_VIVO, new PosicaoCampo(357, 367));
        mapa.put(CamposBenVLI.CASSI_DATA, new PosicaoCampo(368, 377));//fim direito ao plano
        mapa.put(CamposBenVLI.BRANCO, new PosicaoCampo(378, 396));
        mapa.put(CamposBenVLI.CODIGO_FILIAL_VLI, new PosicaoCampo(397, 400));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, PosicaoCampo> mapa) {
        this.mapa = mapa;
    }
}
