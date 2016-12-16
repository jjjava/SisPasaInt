package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasaint.bean.impl.DestinatarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ListaDestinatariosBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.CargaBenEndBeanImpl;
import org.pasa.sispasaint.mail.EnviaEmail;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.DateUtil;
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
public class ModeloBenEndJob implements Job {

    private Log log;

    public ModeloBenEndJob() {
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        log.setDataInicio(DateUtil.obterDataAtual());

        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        long tipo = dataMap.getLong(SisPasaIntCommon.TIPO_JOB);
        long idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);

        CargaBenEndBeanImpl cargaBenEndBeanImpl = new CargaBenEndBeanImpl(idEmpresa, log);
        cargaBenEndBeanImpl.inicar();

        log.setDataFim(DateUtil.obterDataAtual());
        new LogBeanImpl().cadastrar(log);

        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(tipo)),
                "#CARGA ",
                setMensagem());
        enviaEmail.send();
    }

    private List<String> getDestinatariosList(List<ListaDestinatarios> lista) {
        List<String> slista = new ArrayList<>();
        for (ListaDestinatarios d : lista) {
            slista.add(new DestinatarioBeanImpl().obter(d.getIdDestinatario()).getEmail());
        }
        return slista;
    }

    private String setMensagem() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA ");
        sb.append("\n");
        sb.append("Nome Arquivos Beneficiario: ");
        sb.append(log.getNomeArquivoBen());
        sb.append("\n");
        sb.append("Nome Arquivos Endereço: ");
        sb.append(log.getNomeArquivoEnd());
        
        return sb.toString() ;
    }
}
