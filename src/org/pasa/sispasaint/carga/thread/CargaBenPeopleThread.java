package org.pasa.sispasaint.carga.thread;

import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.rw.LerArquivoBenPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class CargaBenPeopleThread implements Runnable {

    private final String cdVale;
    private final Log log;
    private int ini;
    private int fim;
    private int lote;
    private int loteLines;
    private boolean isSmallFile = false;

    public CargaBenPeopleThread(Log log, String cdVale) {
        this.log = log;
        this.cdVale = cdVale;
        this.isSmallFile = true;
    }

    public CargaBenPeopleThread(Log log, String cdVale, int ini, int fim, int lote, int loteLines) {
        this.log = log;
        this.cdVale = cdVale;
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
             new LerArquivoBenPeople(log).lerArquivo(cdVale);
        } else {
            new LerArquivoBenPeople(log).lerArquivo(cdVale, ini, fim, lote, loteLines);
        }
    }
}
