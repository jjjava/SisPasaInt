package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpBenExtTempBean;
import org.pasa.sispasaint.dao.impl.ImpBenExtTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenExt;
import org.pasa.sispasaint.rw.LerArquivoBenExt;

/**
 *
 * @author 90J00318
 */
public class ImpBenExtTempBeanImpl implements ImpBenExtTempBean {

    public ImpBenExtTempBeanImpl() {
    }

    @Override
    public ModeloBenExt obter(Long id) {
        ModeloBenExt modelo = new ModeloBenExt();
        modelo.setId(id);
        return obter(modelo);
    }

    @Override
    public ModeloBenExt obter(ModeloBenExt modelo) {
        return new ImpBenExtTempDAOImpl().obter(modelo.getId());
    }

    @Override
    public void limparTbTemp() {
        new ImpBenExtTempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpBenExtTempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        salvarTbTemp(new LerArquivoBenExt().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloBenExt> listaModeloBenExt) {
        new ImpBenExtTempDAOImpl().salvarTbTemp(listaModeloBenExt);
    }

    @Override
    public Long contar() {
        return new ImpBenExtTempDAOImpl().contar();
    }
}