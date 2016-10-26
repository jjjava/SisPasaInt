package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author 90J00318
 */
@DisallowConcurrentExecution
public class VliJob implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        CargaVLIBeanImpl carga = new CargaVLIBeanImpl();
        carga.cargaArquivosTemp();
        carga.mapearEntidades();
    }
}
