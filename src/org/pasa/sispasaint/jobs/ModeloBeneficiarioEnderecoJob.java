package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.DestinatarioBeanImpl;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.ListaDestinatariosBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.impl.CargaPeopleBeanImpl;
import org.pasa.sispasaint.mail.EnviaEmail;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;
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
 * @version 1.1.1
 */
@DisallowConcurrentExecution
public class ModeloBeneficiarioEnderecoJob implements Job {

    private final Log log;
    private String cdVale;
    private Long idLista;

    public ModeloBeneficiarioEnderecoJob() {
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
            String tipo = dataMap.getString(SisPasaIntCommon.TIPO_JOB);
            this.idLista = dataMap.getLong(SisPasaIntCommon.ID_LISTA);
            this.cdVale = dataMap.getString(SisPasaIntCommon.ID_EMPRESA);
            this.log.setEmpresaVale(new EmpresaBeanImpl().obter(cdVale).getNomeFantasia());
           
            new LogBeanImpl().atualizar(log);

            if (tipo.equals(SisPasaIntCommon.CARGA_PEOPLE)) {
                log.setTipoJob(SisPasaIntCommon.CARGA_PEOPLE);
                CargaPeopleBeanImpl cargaPeopleBeanImpl = new CargaPeopleBeanImpl(cdVale, log);
                cargaPeopleBeanImpl.inicar();
            }

            if (tipo.equals(SisPasaIntCommon.CARGA_VLI)) {
                log.setTipoJob(SisPasaIntCommon.CARGA_VLI);
                CargaPeopleBeanImpl cargaPeopleBeanImpl = new CargaPeopleBeanImpl(cdVale, log);
                cargaPeopleBeanImpl.inicar();
            }

            if (tipo.equals(SisPasaIntCommon.CARGA_EXT)) {
                log.setTipoJob(SisPasaIntCommon.CARGA_EXT);
                CargaPeopleBeanImpl cargaPeopleBeanImpl = new CargaPeopleBeanImpl(cdVale, log);
                cargaPeopleBeanImpl.inicar();
            }
        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(ModeloBeneficiarioEnderecoJob.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        } finally {
            enviarEmail();
        }
    }

    private void enviarEmail() {
        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(idLista)),
                "#CARGA AMS ", setMensagem());
        enviaEmail.enviar();
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
        sb.append(new EmpresaBeanImpl().existe(cdVale).getNomeFantasia());
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
        sb.append("Qtd. Beneficiarios Incluidos.: ");
        sb.append(log.getQtdAssocIncluidos());
        sb.append("\n");
        sb.append("Qtd. Beneficiarios Alterados.: ");
        sb.append(log.getQtdAssocAlterados());
        sb.append("\n");
        sb.append("Qtd. Erros Beneficiarios.: ");
        sb.append(log.getQtdErrosAssoc());
        sb.append("\n");
        sb.append("Qtd. Beneficiarios inativos.: ");
        sb.append(log.getQtdAssocInativo());
        sb.append("\n");
        return sb.toString();
    }
}
