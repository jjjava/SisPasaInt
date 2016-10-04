/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.util;

import java.util.Date;

/**
 *
 * @author 90J00318
 */
public class StringUtil {

    public static Integer parseBoolean(boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Integer parseBoolean(String s) {
        if (s.equalsIgnoreCase("S")) {
            return 1;
        } else {
            return 0;
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
                .replace('Ñ', 'N')
                .replaceAll("[^a-zA-Z0-9,\\s/-]", "");
    }

    public static Date parseData(String d) {
        return null;
    }
}
