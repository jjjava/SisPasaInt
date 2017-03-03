package org.pasa.sispasaint.util;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Criptografia {

    public static String criptografarBase64(String conteudo) throws EncoderException {
        byte[] byteArray = Base64.encodeBase64(conteudo.getBytes());
        return new String(byteArray);
    }

    public static String decriptografarBase64(String conteudo) throws EncoderException {
        byte[] byteArray = Base64.decodeBase64(conteudo.getBytes());
        return new String(byteArray);
    }
}
