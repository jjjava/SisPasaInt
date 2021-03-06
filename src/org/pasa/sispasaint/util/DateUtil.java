package org.pasa.sispasaint.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DateUtil {

    public static final String PATTERN_DATA = "dd.MM.yyyy";
    public static final String PATTERN_DATA2 = "ddMMyyyy";
    public static final String SEGUNDA_FEIRA = "MON";
    public static final String TERCA_FEIRA = "TUE";
    public static final String QUARTA_FEIRA = "WED";
    public static final String QUINTA_FEIRA = "THI";
    public static final String SEXTA_FEIRA = "FRI";
    public static final String SABADO = "SAT";
    public static final String DOMINGO = "SUN";

    public static final String JANEIRO = "JAN";
    public static final String FEVEREIRO = "FEV";
    public static final String MARCO = "MAR";
    public static final String ABRIL = "APR";
    public static final String MAIO = "MAY";
    public static final String JUNHO = "JUN";
    public static final String JULHO = "JUL";
    public static final String AGOSTO = "AUG";
    public static final String SETEMBRO = "SET";
    public static final String OUTUBRO = "OUT";
    public static final String NOVEMBRO = "NOV";
    public static final String DEZEMBRO = "DEC";

    public static Date toDate(final String data) {
        Date retorno;
        if (data == null) {
            return null;
        }
        String trim = data.trim();
        if (trim.equalsIgnoreCase("")) {
            return null;
        }
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DATA, Locale.getDefault());
            retorno = simpleDateFormat.parse(trim);
        } catch (ParseException ex) {
            System.err.println(ex);
            Logger.getLogger(DateUtil.class).error(ex);
            new LogBeanImpl().logErroClass("DateUtil", ex.getMessage());//metodo statico.
            retorno = null;
        }
        return retorno;
    }

    public static Date obterDataAtual() {
        return Calendar.getInstance().getTime();
    }

    public static String dataParaArquivo() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
