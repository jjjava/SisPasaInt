package org.pasa.sispasaint.run;

import java.util.List;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.AgendaBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.jobs.ModeloBenEndJob;
import org.pasa.sispasaint.model.intg.Agenda;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Maestro {

    private SchedulerFactory schedFact;
    private Scheduler scheduler;

    public Maestro() {
        Log log = new Log();
        log.setEmpresaVale(SisPasaIntCommon.COD_PASA);
        new LogBeanImpl().cadastrar(log);
    }

    public void iniciar() {
        try {
            this.schedFact = new StdSchedulerFactory();
            this.scheduler = schedFact.getScheduler();
            this.scheduler.start();
            this.carregaJobs();
        } catch (SchedulerException ex) {
            System.err.println(ex);
            Logger.getLogger(Maestro.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }

    private void carregaJobs() {
        List<Agenda> listAgenda = new AgendaBeanImpl().listar();
        for (Agenda a : listAgenda) {
            try {
                JobDetail job = JobBuilder.newJob(ModeloBenEndJob.class)
                        .withIdentity(a.getDescricao(), a.getGrupo())
                        .usingJobData(SisPasaIntCommon.TIPO_JOB, a.getIdLista())
                        .usingJobData(SisPasaIntCommon.ID_EMPRESA, a.getIdEmpresa())
                        .build();
                Trigger trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(a.getDescricao(), a.getGrupo())
                        .withSchedule(CronScheduleBuilder.cronSchedule(parseSchedule(a)))
                        .build();
                this.scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException ex) {
                System.err.println(ex);
                Logger.getLogger(Maestro.class).error(ex);
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            }
        }
    }

    private String parseSchedule(Agenda a) {
        String s = "";
        s = s + a.getSegundo() + " ";
        s = s + a.getMinuto() + " ";
        s = s + a.getHora() + " ";
        s = s + a.getDia() + " ";
        s = s + a.getMes() + " ";
        s = s + a.getDiaSemana() + " ";
        s = s + a.getAno();
        return s;
    }
}
