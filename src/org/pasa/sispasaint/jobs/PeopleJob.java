package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaPeopleBeanImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author 90J00318
 */
public class PeopleJob implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        CargaPeopleBeanImpl carga = new CargaPeopleBeanImpl();
        carga.cargaArquivosTemp();
        carga.mapearEntidades();
    }    
}
