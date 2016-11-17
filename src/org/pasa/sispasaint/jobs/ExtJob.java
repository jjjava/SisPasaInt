package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaExtBeanImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author 90J00318
 */
public class ExtJob implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        CargaExtBeanImpl cargaExtBeanImpl = new CargaExtBeanImpl();
        cargaExtBeanImpl.cargaArquivosTemp();
        cargaExtBeanImpl.mapearEntidades();
    }
}
