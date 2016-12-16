package org.pasa.sispasaint.carga;

import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ModeloBenEndBeanImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.util.SisPasaIntCommon;

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
       // cargaArquivosTemp();
        mapearEntidades();
    }
    
    @Override
    public void cargaArquivosTemp() {
        ModeloBenEndBeanImpl modeloBenEndBeanImpl = new ModeloBenEndBeanImpl();
        modeloBenEndBeanImpl.limparTbTemp();
        modeloBenEndBeanImpl.resetarIdentity();
        modeloBenEndBeanImpl.carregarArquivo(id, log);
    }
    
    @Override
    public void mapearEntidades() {
        ModeloBenEndBeanImpl modeloBean = new ModeloBenEndBeanImpl();
        Long qtdRegistros = modeloBean.contar();
        
        for (Long k = 1L; k < qtdRegistros; k++) {
            ModeloBenEnd modeloBenEnd = modeloBean.obter(k);
            if (modeloBenEnd.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                Funcionario funcionario = new FuncionarioBeanImpl().obter(modeloBenEnd.getEmpresa(), modeloBenEnd.getMatricula());
                if (funcionario == null) {
                    if (new CargaEntidadeFuncionario().newFuncionario(modeloBenEnd)) {
                        log.addAssocIncluidos();
                    } else {
                        log.addErrosAssoc();
                        log.addMatriculaErro(modeloBenEnd.getEmpresa() + modeloBenEnd.getMatricula());
                    }
                } else {
                    
                }
            } else {
                
            }
        }
    }
}
