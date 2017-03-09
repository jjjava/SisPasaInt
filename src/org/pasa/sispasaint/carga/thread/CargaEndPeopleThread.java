package org.pasa.sispasaint.carga.thread;

import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.rw.LerArquivoEndPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEndPeopleThread implements Runnable {

    private final Long id;
    private final Log log;
    private final int ini;
    private final int fim;
    private final int lote;
    private final int loteLines;

    public CargaEndPeopleThread(Log log, Long id, int ini, int fim, int lote, int loteLines) {
        this.id = id;
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
        new LerArquivoEndPeople(log).lerArquivo(id, ini, fim, lote, loteLines);
    }
}
