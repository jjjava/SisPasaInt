package org.pasa.sispasaint.util;

import org.pasa.sispasa.core.enumeration.EnumSexo;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class StringUtil {

    public static Integer parseBoolean(boolean b) {
        if (b) {
            return SisPasaIntCommon.VERDADEIRO;
        } else {
            return SisPasaIntCommon.FALSO;
        }
    }

    public static Integer parseBoolean(String s) {
        if (s.equalsIgnoreCase("S")) {
            return SisPasaIntCommon.VERDADEIRO;
        } else {
            return SisPasaIntCommon.FALSO;
        }
    }

    public static EnumSexo parseSexo(String s) {
        if (s.equalsIgnoreCase("M")) {
            return EnumSexo.MASCULINO;
        } else {
            return EnumSexo.FEMININO;
        }
    }

    public static Integer parserIndicadorConclusao(String s) {
        if (s.equalsIgnoreCase("C")) {
            return SisPasaIntCommon.VERDADEIRO;
        } else {
            return SisPasaIntCommon.FALSO;
        }
    }

    public static String removeCharsEspeciais(String value) {
        return value.replaceAll("[ãâàáä]", "a")
                .replaceAll("[êèéë]", "e")
                .replaceAll("[îìíï]", "i")
                .replaceAll("[õôòóö]", "o")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("[ÃÂÀÁÄ]", "A")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[ÎÌÍÏ]", "I")
                .replaceAll("[ÕÔÒÓÖ]", "O")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replace('ç', 'c')
                .replace('Ç', 'C')
                .replace('ñ', 'n').replace('Ñ', 'N');
    }

    public static String truncTelefone(String tel) {
        if (tel.length() > SisPasaIntCommon.TAM_ERRO_LOG) {
            return tel.substring(0, SisPasaIntCommon.TAM_TELEFONE);
        }
        return tel;
    }

    public static String truncErroLog(String erro) {
        if (null == erro) {
            return "objeto nulo truncErroLog";
        }
        if (erro.length() > SisPasaIntCommon.TAM_ERRO_LOG) {
            return erro.substring(0, SisPasaIntCommon.TAM_ERRO_LOG);
        }
        return erro;
    }
}
