package org.pasa.sispasaint.util;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author 90J00318
 */
public class Criptografia {

    /**
     *
     * @param conteudo
     * @return
     * @throws EncoderException
     */
    public static String criptografarBase64(String conteudo) throws EncoderException {
        byte[] byteArray = Base64.encodeBase64(conteudo.getBytes());
        return new String(byteArray);
    }

    /**
     *
     * @param conteudo
     * @return
     * @throws EncoderException
     */
    public static String decriptografarBase64(String conteudo) throws EncoderException {
        byte[] byteArray = Base64.decodeBase64(conteudo.getBytes());
        return new String(byteArray);
    }
}
