package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author 90J00318
 */
public class MasterJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String tipo = dataMap.getString("tipo");
        if(tipo.equalsIgnoreCase(SisPasaIntCommon.CARGA_VLI)){
            CargaVLIBeanImpl cargaVLIBeanImpl = new CargaVLIBeanImpl();
            cargaVLIBeanImpl.cargaArquivosTemp();
            cargaVLIBeanImpl.mapearEntidades();
        }
    }
}
