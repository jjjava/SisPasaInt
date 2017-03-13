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
    private final int ini;
    private final int fim;
    private final int lote;
    private final int loteLines;

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
        new LerArquivoBenPeople(log).lerArquivo(cdVale, ini, fim, lote, loteLines);
    }
}
