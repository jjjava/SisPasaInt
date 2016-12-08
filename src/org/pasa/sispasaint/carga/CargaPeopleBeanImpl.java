package org.pasa.sispasaint.carga;

import org.pasa.sispasaint.bean.impl.ImpBenPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.ImpEndPeopleTempBeanImpl;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaPeopleBeanImpl implements CargaPeopleBean {

    private Long id;
    private Log log;
    private LogBeanImpl logBeanImpl;
    
    public CargaPeopleBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
        logBeanImpl = new LogBeanImpl();
    }

    @Override
    public void cargaArquivosTemp() {
    }

    @Override
    public void mapearEntidades() {
        cargaArquivosBenTemp();
        cargaArquivosEndTemp();
    }

    private void cargaArquivosBenTemp() {
        ImpBenPeopleTempBeanImpl impBenPeopleTempBeanImpl = new ImpBenPeopleTempBeanImpl();
        impBenPeopleTempBeanImpl.limparTbTemp();
        impBenPeopleTempBeanImpl.resetarIdentity();
        impBenPeopleTempBeanImpl.carregarArquivo(id);
    }

    private void cargaArquivosEndTemp() {
        ImpEndPeopleTempBeanImpl impEndPeopleTempBeanImpl = new ImpEndPeopleTempBeanImpl();
        impEndPeopleTempBeanImpl.limparTbTemp();
        impEndPeopleTempBeanImpl.resetarIdentity();
        impEndPeopleTempBeanImpl.carregarArquivo(id);
    }
}
