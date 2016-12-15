package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.carga.CargaBenEndBeanImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@DisallowConcurrentExecution
public class ModeloBenEndJob implements Job{
    
    private Log log;
    public ModeloBenEndJob(){
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        long tipo = dataMap.getLong(SisPasaIntCommon.TIPO_JOB);
        long idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);
        
        CargaBenEndBeanImpl cargaBenEndBeanImpl = new CargaBenEndBeanImpl(idEmpresa, log);
        cargaBenEndBeanImpl.inicar();
    }
    
}
