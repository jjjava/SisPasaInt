package org.pasa.sispasaint.carga.thread;

import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.carga.impl.CargaEntidadePeopleFuncionario;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.SisPasaIntErro;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaMapeaEntidadesThread implements Runnable {

    private Log log;
    private long ini;
    private long qtdRegistros;

    private final FuncionarioBeanImpl funcionarioBeanImpl;
    private final ImpBenPeopleTempBeanImpl modeloBenBean;
    private final CargaEntidadePeopleFuncionario cargaEntidadePeopleFuncionario;
    private final String name;

    public CargaMapeaEntidadesThread(Log log, long ini, long qtdRegistros, String name) {
        this.log = log;
        this.ini = ini;
        this.qtdRegistros = qtdRegistros;
        this.name = name;
        this.modeloBenBean = new ImpBenPeopleTempBeanImpl();
        this.funcionarioBeanImpl = new FuncionarioBeanImpl();
        this.cargaEntidadePeopleFuncionario = new CargaEntidadePeopleFuncionario(log);
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    public void mapearEntidades() {
        Funcionario funcionario = null;
        try {
            for (long k = ini; k < qtdRegistros; k++) {
                ModeloBenPeople mBenef = modeloBenBean.obter(k);
                if (mBenef.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    funcionario = funcionarioBeanImpl.obter(mBenef.getEmpresa(), mBenef.getMatriculaPeople());
                    if (funcionario == null) {
                        if (cargaEntidadePeopleFuncionario.newFuncionario(mBenef)) {
                            log.addAssocIncluidos();
                        } else {
                            log.addErrosAssoc();
                            log.addMatriculaErro(mBenef.getEmpresa(),mBenef.getMatriculaPeople(),
                                    mBenef.getCodBeneficiario(), SisPasaIntErro.ERRO_NAO_CADASTRADO,SisPasaIntErro.MSG_FALSE_DAO);
                        }
                    } else {
                    //comparar
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            Logger.getLogger(CargaMapeaEntidadesThread.class).error(ex);
        }
    }

    @Override
    public void run() {
        mapearEntidades();
    }
}
