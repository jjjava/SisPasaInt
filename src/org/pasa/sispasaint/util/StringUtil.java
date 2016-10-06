package org.pasa.sispasaint.util;

import org.pasa.sispasaint.model.enun.NivelEscolaridade;
import org.pasa.sispasaint.model.enun.Sexo;

/**
 *
 * @author 90J00318
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

    public static Sexo parseSexo(String s) {
        if (s.equalsIgnoreCase("M")) {
            return Sexo.Masculino;
        } else {
            return Sexo.Feminino;
        }
    }

    public static NivelEscolaridade parseEscolocaridade(String s) {
        if (s.equalsIgnoreCase("3")) {
            return NivelEscolaridade.Superior;
        } else if (s.equalsIgnoreCase("2")) {
            return NivelEscolaridade.Medio;
        } else if (s.equalsIgnoreCase("2")) {
            return NivelEscolaridade.Fundamental;
        } else {
            return NivelEscolaridade.Sem;
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
                .replace('ñ', 'n')
                .replace('Ñ', 'N');
    }
}
