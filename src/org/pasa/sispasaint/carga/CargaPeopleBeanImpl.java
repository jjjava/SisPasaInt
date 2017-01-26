package org.pasa.sispasaint.carga;

import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaPeopleBeanImpl implements CargaPeopleBean, Runnable {

    private Long id;
    private Log log;
    private final LogBeanImpl logBeanImpl;
    private final FuncionarioBeanImpl funcionarioBeanImpl;
    private final ImpBenPeopleTempBeanImpl modeloBenBean;
    private final ImpEndPeopleTempBeanImpl modeloEndBean;
    private final CargaEntidadePeopleFuncionario cargaEntidadePeopleFuncionario;

    public CargaPeopleBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        logBeanImpl = new LogBeanImpl();
        modeloBenBean = new ImpBenPeopleTempBeanImpl();
        modeloEndBean = new ImpEndPeopleTempBeanImpl();
        funcionarioBeanImpl = new FuncionarioBeanImpl();
        cargaEntidadePeopleFuncionario = new CargaEntidadePeopleFuncionario();
    }
    
    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    
    @Override
    public void inicar() {
        this.cargaArquivosTemp();
        this.mapearEntidades();
    }

    @Override
    public void cargaArquivosTemp() {
        ImpBenPeopleTempBeanImpl bean = new ImpBenPeopleTempBeanImpl();
        bean.limparTbTemp();
        bean.resetarIdentity();
        bean.carregarArquivo(id, log);
    }
    
    @Override
    public void mapearEntidades() {
        Long qtdRegistros = modeloBenBean.contar();
        Funcionario funcionario = null;
        try {
            for (Long k = 1L; k < qtdRegistros; k++) {
                System.out.println(k);
                ModeloBenPeople mBen = modeloBenBean.obter(k);
                if(mBen.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)){
                    funcionario = funcionarioBeanImpl.obter(mBen.getEmpresa(), mBen.getMatriculaPeople());
                    if (funcionario == null) {
                        if (cargaEntidadePeopleFuncionario.newFuncionario(mBen)) {
                            log.addAssocIncluidos();
                        } else {
                            log.addErrosAssoc();
                            //log.addMatriculaErro(modeloBenEnd.getEmpresa() + modeloBenEnd.getMatricula());
                        }
                    }else{
                        
                    }
                }
            }
        }catch (Exception e) {
            System.err.println(e);
            Logger.getLogger(CargaPeopleBeanImpl.class).error(e);
        }
    }
    
    @Override
    public void run() {
        inicar();
    }
}
