package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasaint.carga.CargaVLIBeanImpl;
import org.pasa.sispasaint.bean.impl.DestinatarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ListaDestinatariosBeanImpl;
import org.pasa.sispasaint.mail.EnviaEmail;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

public class VliJob implements Job {
    
    private Log log;
    
    public VliJob(){
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
       
        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        long tipo = dataMap.getLong(SisPasaIntCommon.TIPO_JOB);
        long idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);
        
        System.out.println("1111execute");

        CargaVLIBeanImpl carga = new CargaVLIBeanImpl(idEmpresa, log);
        carga.cargaArquivosTemp();
        carga.mapearEntidades();
        
        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(tipo))
                , "#CARGA VLI "
                , setMensagem());
        
        enviaEmail.send();
    }

    private List<String> getDestinatariosList(List<ListaDestinatarios> lista) {
        List<String> slista = new ArrayList<>();
        for (ListaDestinatarios d : lista) {
            slista.add(new DestinatarioBeanImpl().obter(d.getIdDestinatario()).getEmail());
        }
        return slista;
    }
    
    private String setMensagem(){
       return "";
    }
}
