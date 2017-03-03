package org.pasa.sispasaint.carga.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.CargaPeopleBean;
import org.pasa.sispasaint.carga.thread.CargaMapeaEntidadesThread;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaPeopleBeanImpl implements CargaPeopleBean {

    private Long id;
    private Log log;
    private final ImpBenPeopleTempBeanImpl modeloBenBean;

    public CargaPeopleBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        this.modeloBenBean = new ImpBenPeopleTempBeanImpl();

    }

    @Override
    public void inicar() {
        // this.cargaArquivosTemp();
        this.mapearEntidades();
    }

    @Override
    public void cargaArquivosTemp() {
        ImpBenPeopleTempBeanImpl beanBen = new ImpBenPeopleTempBeanImpl();
        beanBen.limparTbTemp();
        beanBen.resetarIdentity();
        beanBen.carregarArquivo(id, log);

        ImpEndPeopleTempBeanImpl beanEnd = new ImpEndPeopleTempBeanImpl();
        beanEnd.limparTbTemp();
        beanEnd.resetarIdentity();
        beanEnd.carregarArquivo(id, log);
    }

    @Override
    public void mapearEntidades() {
        ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
        long qtdRegistros = modeloBenBean.contar();
        long lote = ArquivoUtil.getNumeroLinhasLote(qtdRegistros);
        this.log.setQtdLote(lote);
        long ini = 1;
        long fim = lote;
        try {
            for (int k = 0; k < Sistema.getNumberProcessors(); k++) {
                executor.execute(new CargaMapeaEntidadesThread(log, ini, fim, "Thread" + k + 1));
                ini = fim;
                fim = fim + lote;
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
        } catch (Exception ex) {
            System.err.println(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            Logger.getLogger(CargaPeopleBeanImpl.class).error(ex);
        }
    }
}
