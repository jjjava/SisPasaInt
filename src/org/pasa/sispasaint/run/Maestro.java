package org.pasa.sispasaint.run;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pasa.sispasaint.bean.impl.AgendaBeanImpl;
import org.pasa.sispasaint.jobs.MasterJob;
import org.pasa.sispasaint.model.intg.Agenda;
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
 * @author 90J00318
 */
public class Maestro {

    private SchedulerFactory schedFact;
    private Scheduler sched;

    public Maestro() {
        try {
            schedFact = new StdSchedulerFactory();
            sched = schedFact.getScheduler();
            sched.start();
            carregaJobs();
        } catch (SchedulerException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregaJobs() {
        List<Agenda> listAgenda = new AgendaBeanImpl().listar();
        for (Agenda a : listAgenda) {
            System.out.println(parseSchedule(a));
            try {
                JobDetail job = JobBuilder.newJob(MasterJob.class)
                        .withIdentity(a.getDescricao(), a.getGrupo())
                        .usingJobData("tipo", a.getDescricao())
                        .build();

                Trigger trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(a.getDescricao(), a.getGrupo())
                        .withSchedule(CronScheduleBuilder.cronSchedule(parseSchedule(a)))
                        .build();
                sched.scheduleJob(job, trigger);
            } catch (SchedulerException e) {
                System.out.println("erro");
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
