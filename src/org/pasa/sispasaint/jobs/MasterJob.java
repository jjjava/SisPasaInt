package org.pasa.sispasaint.jobs;

import org.pasa.sispasaint.bean.impl.CargaExtBeanImpl;
import org.pasa.sispasaint.bean.impl.CargaPeopleBeanImpl;
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
        System.out.println("tipo:"+tipo);
        if(tipo.equalsIgnoreCase(SisPasaIntCommon.CARGA_VLI)){
            CargaVLIBeanImpl cargaVLIBeanImpl = new CargaVLIBeanImpl();
            cargaVLIBeanImpl.cargaArquivosTemp();
            cargaVLIBeanImpl.mapearEntidades();
        }
        if(tipo.equalsIgnoreCase(SisPasaIntCommon.CARGA_PEOPLE)){
            CargaPeopleBeanImpl cargaPeopleBeanImpl = new CargaPeopleBeanImpl();
            cargaPeopleBeanImpl.cargaArquivosTemp();
            cargaPeopleBeanImpl.mapearEntidades();
        }
        if(tipo.equalsIgnoreCase(SisPasaIntCommon.CARGA_EXT)){
            CargaExtBeanImpl cargaExtBeanImpl = new CargaExtBeanImpl();
            cargaExtBeanImpl.cargaArquivosTemp();
            cargaExtBeanImpl.mapearEntidades();
        }
    }
}
