package org.pasa.sispasaint.jobs;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasaint.bean.impl.DestinatarioBeanImpl;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.ListaDestinatariosBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.impl.CargaBenEndBeanImpl;
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
    private Long idEmpresa;

    public ModeloBeneficiarioEnderecoJob() {
        log = new Log();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        JobDataMap dataMap = jec.getJobDetail().getJobDataMap();
        String tipo = dataMap.getString(SisPasaIntCommon.TIPO_JOB);
        long idLista = dataMap.getLong(SisPasaIntCommon.ID_LISTA);
        this.idEmpresa = dataMap.getLong(SisPasaIntCommon.ID_EMPRESA);
        this.log.setEmpresaVale(new EmpresaBeanImpl().obter(idEmpresa).getNomeFantasia());
        
        if (tipo.equals(SisPasaIntCommon.CARGA_PEOPLE)) {
            CargaPeopleBeanImpl cargaPeopleBeanImpl = new CargaPeopleBeanImpl(idEmpresa, log);
            cargaPeopleBeanImpl.inicar();
        } else {
            CargaBenEndBeanImpl cargaBenEndBeanImpl = new CargaBenEndBeanImpl(idEmpresa, log);
            cargaBenEndBeanImpl.start();
        }
        
        EnviaEmail enviaEmail = new EnviaEmail(getDestinatariosList(new ListaDestinatariosBeanImpl().listar(idLista)),
                "#CARGA AMS ",
                setMensagem());
        enviaEmail.enviar();
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
        sb.append(new EmpresaBeanImpl().obter(idEmpresa).getNomeFantasia());
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
