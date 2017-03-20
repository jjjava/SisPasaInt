package org.pasa.sispasaint.carga.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.CargaPeopleBean;
import org.pasa.sispasaint.carga.thread.CargaMapeaEntidadesThread;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 * @version 1.2.18
 */
public class CargaPeopleBeanImpl implements CargaPeopleBean {

    private final Log log;
    private final String cdVale;
    private final ImpBenPeopleBeanImpl modeloBenBean;
    private final ImpBenPeopleTempBeanImpl modeloBenBeanTemp;

    public CargaPeopleBeanImpl(String cdVale, Log log) {
        this.cdVale = cdVale;
        this.log = log;
        this.modeloBenBean = new ImpBenPeopleBeanImpl();
        this.modeloBenBeanTemp = new ImpBenPeopleTempBeanImpl();
    }

    @Override
    public void inicar() {
        this.cargaArquivosTemp();
        this.mapearEntidades();
        this.inativacao();
    }

    @Override
    public void cargaArquivosTemp() {

        //BENEFICIARIO
        ImpBenPeopleBeanImpl beanBen = new ImpBenPeopleBeanImpl();
        beanBen.limparTabela();
        beanBen.resetarIdentity();
        beanBen.carregarArquivo(cdVale, log);

        //ENDERECO
        ImpEndPeopleBeanImpl beanEnd = new ImpEndPeopleBeanImpl();
        beanEnd.limparTbTemp();
        beanEnd.resetarIdentity();
        beanEnd.carregarArquivo(cdVale, log);
    }

    @Override
    public void mapearEntidades() {
        ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
        long qtdRegistros = modeloBenBean.contar();
        if (qtdRegistros > 2001) {
            long lote = ArquivoUtil.getNumeroLinhasLote(qtdRegistros);
            long ini = 1;
            long fim = lote;
            this.log.setQtdLote(lote);
            this.log.setQtdThreads(Sistema.getNumberProcessors());
            try {
                for (int k = 0; k < Sistema.getNumberProcessors(); k++) {
                    if ((Sistema.getNumberProcessors() - k) == 1) {
                        fim = fim + ArquivoUtil.getNumeroLinhasResto(qtdRegistros);
                    }
                    executor.execute(new CargaMapeaEntidadesThread(log, ini, fim, " Thread_" + (k + 1)));
                    ini = fim;
                    fim = fim + lote;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {
                }
            } catch (Exception ex) {
                System.err.println(this.getClass().getName()+"\n"+ex);
                Logger.getLogger(CargaPeopleBeanImpl.class).error(ex);
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            }
        } else {
            long ini = 1;
            long fim = qtdRegistros;
            this.log.setQtdLote(qtdRegistros);
            this.log.setQtdThreads(1);
            try {
                executor.execute(new CargaMapeaEntidadesThread(log, ini, fim, " Thread"));
            } catch (Exception ex) {
                System.err.println(this.getClass().getName() + "\n" + ex);
                Logger.getLogger(CargaPeopleBeanImpl.class).error(ex);
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            }
        }
    }

    public void inativacao() {
        modeloBenBean.inativar(modeloBenBean.verificarInativos());
        modeloBenBeanTemp.limparTabela(Configuracao.getInstance().getNomeArqBen(cdVale));
        modeloBenBean.copiarTabela();
    }
}
