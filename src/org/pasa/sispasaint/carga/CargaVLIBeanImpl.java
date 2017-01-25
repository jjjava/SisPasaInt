package org.pasa.sispasaint.carga;

import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaVLIBeanImpl implements CargaVLIBean, Runnable {

    private Long id;
    private Log log;
    private LogBeanImpl logBeanImpl;

    public CargaVLIBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        logBeanImpl = new LogBeanImpl();
    }
    
    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    
    @Override
    public void inicar() {
        this.cargaArquivosTemp();
        this.mapearEntidades();
    }

    @Override
    public void cargaArquivosTemp() {

    }
    
    @Override
    public void mapearEntidades() {
        
    }
    
    @Override
    public void run() {
        inicar();
    }
}
