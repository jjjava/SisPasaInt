package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaExtBean;

/**
 *
 * @author 90J00318
 */
public class CargaExtBeanImpl implements CargaExtBean {

    public CargaExtBeanImpl() {
        System.out.println("carga");
    }

    @Override
    public void cargaArquivosTemp() {
        ImpBenExtTempBeanImpl impBenExtTempBeanImpl = new ImpBenExtTempBeanImpl();
        impBenExtTempBeanImpl.limparTbTemp();
        impBenExtTempBeanImpl.resetarIdentity();
        impBenExtTempBeanImpl.carregarArquivo();
    }

    @Override
    public void mapearEntidades() {
        
    }

}
