package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
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
         JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        String tipo = dataMap.getString("tipo");
        carga.cargaArquivosTemp();
        carga.mapearEntidades();
    }
}
