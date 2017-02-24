package org.pasa.sispasaint.carga.thread;

import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.rw.LerArquivoBenPeople;

/**
 *
 * @author HUdson Schumaker
 */
public class CargaBenPeopleThread implements Runnable {

    private Long id;
    private int ini;
    private int fim;
    private int lote;
    private int loteLines;

    public CargaBenPeopleThread(Long id, int ini, int fim, int lote, int loteLines) {
        this.id = id;
        this.ini = ini;
        this.fim = fim;
        this.lote = lote;
        this.loteLines = loteLines;
    }
    
    public void start(){
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        new LerArquivoBenPeople(new Log()).lerArquivo(id,ini,fim,lote,loteLines);
    }
}
