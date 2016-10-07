package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaPeopleBean;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaPeopleBeanImpl implements CargaPeopleBean {

    public CargaPeopleBeanImpl() {
        System.out.println("carga");
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
        impBenPeopleTempBeanImpl.carregarArquivo();
    }

    private void cargaArquivosEndTemp() {
        ImpEndPeopleTempBeanImpl impEndPeopleTempBeanImpl = new ImpEndPeopleTempBeanImpl();
        impEndPeopleTempBeanImpl.limparTbTemp();
        impEndPeopleTempBeanImpl.resetarIdentity();
        impEndPeopleTempBeanImpl.carregarArquivo();
    }
}
