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
                .replace('ñ', 'n')
                .replace('Ñ', 'N');
    }
    
    public static String truncTelefone(String tel){
        char aux[] = tel.toCharArray();
        tel = "";
        System.out.println(aux.length);
        for(int k=0;k<18;k++){
            tel = tel + aux[k]; 
        }
        return tel;
    }
}
