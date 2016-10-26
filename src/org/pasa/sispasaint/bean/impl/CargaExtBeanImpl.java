package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaExtBean;

/**
 *
 * @author 90J00318
 */
public class CargaExtBeanImpl implements CargaExtBean {

    public CargaExtBeanImpl() {
    }

    @Override
    public void cargaArquivosTemp() {
        cargaArquivosBenTemp();
        cargaArquivosEndTemp();
    }

    @Override
    public void mapearEntidades() {

    }

    private void cargaArquivosBenTemp() {
        ImpBenExtTempBeanImpl impBenExtTempBeanImpl = new ImpBenExtTempBeanImpl();
        impBenExtTempBeanImpl.limparTbTemp();
        impBenExtTempBeanImpl.resetarIdentity();
        impBenExtTempBeanImpl.carregarArquivo();
    }

    private void cargaArquivosEndTemp() {
        ImpEndExtTempBeanImpl impEndExtTempBeanImpl = new ImpEndExtTempBeanImpl();
        impEndExtTempBeanImpl.limparTbTemp();
        impEndExtTempBeanImpl.resetarIdentity();
        impEndExtTempBeanImpl.carregarArquivo();
    }
}
