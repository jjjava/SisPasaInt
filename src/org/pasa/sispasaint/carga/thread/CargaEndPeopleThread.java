package org.pasa.sispasaint.carga.thread;

import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.rw.LerArquivoEndPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEndPeopleThread implements Runnable {

    private final String cdVale;
    private final Log log;
    private int ini;
    private int fim;
    private int lote;
    private int loteLines;
    private boolean isSmallFile = false;
    
    public CargaEndPeopleThread(Log log, String cdVale) {
        this.log = log;
        this.cdVale = cdVale;
        this.isSmallFile = true;
    }

    public CargaEndPeopleThread(Log log, String cdVale, int ini, int fim, int lote, int loteLines) {
        this.cdVale = cdVale;
        this.log = log;
        this.ini = ini;
        this.fim = fim;
        this.lote = lote;
        this.loteLines = loteLines;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        if (isSmallFile) {
             new LerArquivoEndPeople(log).lerArquivo(cdVale);
        } else {
            new LerArquivoEndPeople(log).lerArquivo(cdVale, ini, fim, lote, loteLines);
        }
    }
}
