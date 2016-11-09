package org.pasa.sispasaint.util;

import org.pasa.sispasaint.model.enun.EnunNivelEscolaridade;
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

    public static EnunNivelEscolaridade parseEscolocaridade(String s) {
        if (s.equalsIgnoreCase("3")) {
            return EnunNivelEscolaridade.Superior;
        } else if (s.equalsIgnoreCase("2")) {
            return EnunNivelEscolaridade.Medio;
        } else if (s.equalsIgnoreCase("2")) {
            return EnunNivelEscolaridade.Fundamental;
        } else {
            return EnunNivelEscolaridade.Sem;
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
    
    public static String parseParentesco(String value){
        if(value.equalsIgnoreCase("0")){
            return "Pai/Mãe";
        }else if( value.equalsIgnoreCase("1")){
            return "Cônjuge";
        }else if(value.equalsIgnoreCase("2")){
            return "Filho/Filha";
        }else if(value.equalsIgnoreCase("3")){
            return "Companheiro/Companheira";
        }else if(value.equalsIgnoreCase("4")){
            return "Enteado/Enteada";
        }else if(value.equalsIgnoreCase("5")){
            return "Descendete";
        }else if (value.equalsIgnoreCase("6")){
            return "Ascendente";
        }else if(value.equalsIgnoreCase("7")){
            return "Irmão/Irmã";
        }else if(value.equalsIgnoreCase("8")){
            return "Menor sob dependência";
        }else if(value.equalsIgnoreCase("9")){
            return "Menor sob guarda";
        }else if(value.equalsIgnoreCase("A")){
            return "Menor sob tutela";
        }else if(value.equalsIgnoreCase("B")){
            return "Ex-Cônjuge Div. C/ Pensão";
        }else if(value.equalsIgnoreCase("C")){
            return "Sogro";
        }else if(value.equalsIgnoreCase("D")){
            return "Menor adotado";
        }else if(value.equalsIgnoreCase("E")){
            return "Esposa";
        }else if(value.equalsIgnoreCase("G")){
            return "Designiado";
        }else{
            return "Sobrinho";
        }
    }
}
