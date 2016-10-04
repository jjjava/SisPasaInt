/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author 90J00318
 */
public class DateUtil {

    public static final String PATTERN_DATA = "dd/MM/yyyy";

    public static Date toDate(final String data) {
        Date retorno;
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DATA, Locale.getDefault());
            retorno = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            System.err.println(e);
            retorno = null;
        }
        return retorno;
    }

}
