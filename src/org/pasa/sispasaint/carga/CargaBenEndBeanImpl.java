package org.pasa.sispasaint.carga;

import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.bean.impl.ModeloBenEndBeanImpl;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaBenEndBeanImpl implements CargaBenEndBean {

    private Long id;
    private Log log;

    public CargaBenEndBeanImpl(Long id, Log log) {
        this.id = id;
        this.log = log;
    }
    
    @Override
    public void inicar() {
       cargaArquivosTemp();
    }

    @Override
    public void cargaArquivosTemp() {
        ModeloBenEndBeanImpl modeloBenEndBeanImpl = new ModeloBenEndBeanImpl();
        modeloBenEndBeanImpl.limparTbTemp();
        modeloBenEndBeanImpl.resetarIdentity();
        modeloBenEndBeanImpl.carregarArquivo(id,log);
    }

    @Override
    public void mapearEntidades() {
        
    }

  

}
