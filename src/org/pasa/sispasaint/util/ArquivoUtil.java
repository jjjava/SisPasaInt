package org.pasa.sispasaint.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ArquivoUtil {

    public static int getNumerosLinhaArquivo(String path) throws FileNotFoundException, IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(path)));
        lnr.skip(Long.MAX_VALUE);
        int lines = lnr.getLineNumber() + 1; //Add 1, index starts at 0
        lnr.close();
        return (lines);
    }

    public static int getNumeroLinhasLote(int numeroLinha) {
        return numeroLinha / Sistema.getNumberProcessors();
    }
    
    public static long getNumeroLinhasLote(long numeroLinha) {
        return (long)(numeroLinha / Sistema.getNumberProcessors());
    }
    
    public int getNumerolLinhasResto(int numeroLinha){
        return numeroLinha % Sistema.getNumberProcessors();
    }
}
