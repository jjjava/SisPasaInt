package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasaint.bean.impl.CargaExtBeanImpl;
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
 * @author 90J00318
 */
public class ExtJob implements Job {

    private Log log;

    private ExtJob() {
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        long tipo = dataMap.getLong(SisPasaIntCommon.TIPO_JOB);
        long idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);
        CargaExtBeanImpl cargaExtBeanImpl = new CargaExtBeanImpl(idEmpresa, log);
        cargaExtBeanImpl.cargaArquivosTemp();
        cargaExtBeanImpl.mapearEntidades();

        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(tipo)),
                 "#CARGA EXT ",
                 setMensagem());

        enviaEmail.send();
    }

    public List<String> getDestinatariosList(List<ListaDestinatarios> lista) {
        List<String> slista = new ArrayList<>();
        for (ListaDestinatarios d : lista) {
            slista.add(new DestinatarioBeanImpl().obter(d.getIdDestinatario()).getEmail());
        }
        return slista;
    }

    public String setMensagem() {
        return "";
    }
}
