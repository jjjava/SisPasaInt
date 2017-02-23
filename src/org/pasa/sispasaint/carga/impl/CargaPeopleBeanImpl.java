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
    private final LogBeanImpl logBeanImpl;
    private final ImpBenPeopleTempBeanImpl modeloBenBean;

    public CargaPeopleBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        logBeanImpl = new LogBeanImpl();
        modeloBenBean = new ImpBenPeopleTempBeanImpl();

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
        Long qtdRegistros = modeloBenBean.contar();
        System.out.println("qtd rgistros "+qtdRegistros);
        long lote = ArquivoUtil.getNumeroLinhasLote(qtdRegistros);
        System.out.println("lote :"+lote);
        long ini = 1;
        long fim = lote;
        try {
            for (int k = 0; k < Sistema.getNumberProcessors(); k++) {   
                executor.execute(new CargaMapeaEntidadesThread(ini, fim, "Thread"+k));
                ini = fim;
                fim = fim + lote;
              //  System.out.println("K "+k);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Acabou !!!!!!!!");
        } catch (Exception e) {
            System.err.println(e);
            Logger.getLogger(CargaPeopleBeanImpl.class).error(e);
        }
    }
}
