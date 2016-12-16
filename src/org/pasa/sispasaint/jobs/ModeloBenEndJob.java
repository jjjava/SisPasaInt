package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasaint.bean.impl.DestinatarioBeanImpl;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
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
    private Long idEmpresa;

    public ModeloBenEndJob() {
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        log.setDataInicio(DateUtil.obterDataAtual());

        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        long tipo = dataMap.getLong(SisPasaIntCommon.TIPO_JOB);
        idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);

        CargaBenEndBeanImpl cargaBenEndBeanImpl = new CargaBenEndBeanImpl(idEmpresa, log);
        cargaBenEndBeanImpl.inicar();

        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(tipo)),
                "#CARGA AMS ",
                setMensagem());

        log.setDataFim(DateUtil.obterDataAtual());
        new LogBeanImpl().cadastrar(log);
    }

    private List<String> getDestinatariosList(List<ListaDestinatarios> lista) {
        List<String> slista = new ArrayList<>();
        lista.forEach((d) -> {
            slista.add(new DestinatarioBeanImpl().obter(d.getIdDestinatario()).getEmail());
        });
        return slista;
    }

    private String setMensagem() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA ");
        sb.append(new EmpresaBeanImpl().obter(idEmpresa));
        sb.append("\n");
        sb.append("Nome Arquivos Beneficiario: ");
        sb.append(log.getNomeArquivoBen());
        sb.append("\n");
        sb.append("Nome Arquivos Endereço: ");
        sb.append(log.getNomeArquivoEnd());
        sb.append("\n");
        sb.append("Qtd. Registros.: ");
        sb.append(log.getQtdRegistros());
        sb.append("\n");
        sb.append("Qtd. Assoc. Incluidos.: ");
        sb.append(log.getQtdAssocIncluidos());
        sb.append("\n");
        sb.append("Qtd. Assoc. Alterados.: ");
        sb.append(log.getQtdAssocAlterados());
        sb.append("\n");
        sb.append("Qtd. Erros Assoc.: ");
        sb.append(log.getQtdErrosAssoc());
        sb.append("\n");
        sb.append("Qtd. Assoc. inativos.: ");
        sb.append(log.getQtdAssocInativo());
        sb.append("\n");
        return sb.toString();
    }
}
