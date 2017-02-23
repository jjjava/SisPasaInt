package org.pasa.sispasaint.carga.thread;

import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.carga.impl.CargaEntidadePeopleFuncionario;
import org.pasa.sispasaint.carga.impl.CargaPeopleBeanImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaMapeaEntidadesThread implements Runnable {
    
    private Long ini;
    private Long qtdRegistros;
    
    private final FuncionarioBeanImpl funcionarioBeanImpl;
    private final ImpBenPeopleTempBeanImpl modeloBenBean;
    private final CargaEntidadePeopleFuncionario cargaEntidadePeopleFuncionario;
    private String name;

    public CargaMapeaEntidadesThread(Long ini, Long qtdRegistros, String name) {
    
        this.ini = ini;
        this.qtdRegistros = qtdRegistros;
        this.name = name;
        modeloBenBean = new ImpBenPeopleTempBeanImpl();
        funcionarioBeanImpl = new FuncionarioBeanImpl();
        cargaEntidadePeopleFuncionario = new CargaEntidadePeopleFuncionario();
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    public void mapearEntidades() {
        Funcionario funcionario = null;
        try {
            int j =1;
            System.out.println(name+" iniciou...");
            for (Long k = ini ; k < qtdRegistros; k++) {
                //System.out.println(k);
                ModeloBenPeople mBen = modeloBenBean.obter(k);
                if (mBen.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    funcionario = funcionarioBeanImpl.obter(mBen.getEmpresa(), mBen.getMatriculaPeople());
                    if (funcionario == null) {
                        if (cargaEntidadePeopleFuncionario.newFuncionario(mBen)) {
                          //  log.addAssocIncluidos();
                        } else {
                        //    log.addErrosAssoc();
                            //log.addMatriculaErro(modeloBenEnd.getEmpresa() + modeloBenEnd.getMatricula());
                        }
                    } else {
                       if(mBen.getEmpresa().equalsIgnoreCase("90")){
                           System.out.println("PASA");
                       }
                    }
                }
                j++;
            }
            System.out.println("Contei "+name+" :"+j);
        } catch (Exception e) {
            System.err.println(e);
            Logger.getLogger(CargaPeopleBeanImpl.class).error(e);
        }
    }

    @Override
    public void run() {
        mapearEntidades();
    }
}
