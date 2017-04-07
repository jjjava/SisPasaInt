package org.pasa.sispasaint.carga.thread;

import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.impl.CargaEntidadePeopleFuncionario;
import org.pasa.sispasaint.model.intg.ComparadorFuncionario;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.SisPasaIntErro;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaMapeiaEntidadesThread implements Runnable {

    private final Log log;
    private final long ini;
    private final long qtdRegistros;

    private final String nome;
    private final LogBeanImpl logBean;
    private final ComparadorFuncionario comparadorFuncionario;
    private final FuncionarioBeanImpl funcionarioBean;
    private final ImpBenPeopleBeanImpl modeloBenBean;
    private final CargaEntidadePeopleFuncionario cargaEntidadePeopleFuncionario;

    public CargaMapeiaEntidadesThread(Log log, long ini, long qtdRegistros, String nome) {
        this.log = log;
        this.ini = ini;
        this.qtdRegistros = qtdRegistros;
        this.nome = nome;
        this.logBean = new LogBeanImpl();
        this.modeloBenBean = new ImpBenPeopleBeanImpl();
        this.funcionarioBean = new FuncionarioBeanImpl();
        this.comparadorFuncionario = new ComparadorFuncionario();
        this.cargaEntidadePeopleFuncionario = new CargaEntidadePeopleFuncionario(log);
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    public void mapearEntidades() {
        Funcionario funcionario = null;
        long k = 0;
        try {
            for (k = ini; k < qtdRegistros; k++) {
                try {
                    ModeloBenPeople mBenef = modeloBenBean.obter(k);
                    if (null != mBenef) {
                        log.addRegistro();
                        if (mBenef.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                            funcionario = funcionarioBean.obter(mBenef.getEmpresa(), mBenef.getMatriculaPeople());
                            if (null == funcionario) {
                                if (cargaEntidadePeopleFuncionario.newFuncionario(mBenef)) {
                                    log.addAssocIncluidos();
                                    logBean.atualizar(log);
                                } else {
                                    log.addErrosAssoc();
                                    log.addMatriculaErro(mBenef.getEmpresa(), mBenef.getMatriculaPeople(), mBenef.getCodBeneficiario(), SisPasaIntErro.ERRO_NAO_CADASTRADO, SisPasaIntErro.MSG_FALSE_DAO);
                                    logBean.atualizar(log);
                                }
                            } else {
//                                Funcionario b = cargaEntidadePeopleFuncionario.funcionarioFromModelo(mBenef);
//                                if (comparadorFuncionario.comparar(funcionario, b) != 0) {
//                                    funcionarioBean.atualizar(b);
//                                    log.addAlterados();
//                                    logBean.atualizar(log);
//                                }
                            }
                        }
                    } else {
                        System.err.println(nome + "   contador :" + k + " ModeloBenPeople = null");
                        Logger.getLogger(CargaMapeiaEntidadesThread.class).error(nome + "   contador :" + k + " ModeloBenPeople = null");
                        new LogBeanImpl().logErroClass(this.getClass().getName() + nome + " contador: " + k, "ModeloBenPeople = null");
                    }
                } catch (Exception ex) {
                    System.err.println(nome + "   contador :" + k + "   " + ex);
                    Logger.getLogger(CargaMapeiaEntidadesThread.class).error(ex);
                    new LogBeanImpl().logErroClass(this.getClass().getName() + nome + " contador: " + k, ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.err.println(nome + "   contador :" + k + "   " + ex);
            Logger.getLogger(CargaMapeiaEntidadesThread.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName() + nome + " contador: " + k, ex.getMessage());
        }
    }

    @Override
    public void run() {
        mapearEntidades();
    }
}
