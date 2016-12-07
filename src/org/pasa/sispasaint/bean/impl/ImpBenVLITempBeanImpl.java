package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpBenVLITempBean;
import org.pasa.sispasaint.dao.impl.ImpBenVLITempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.rw.LerArquivoBenVLI;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpBenVLITempBeanImpl implements ImpBenVLITempBean {

    public ImpBenVLITempBeanImpl() {
    }

    @Override
    public ModeloBenVLI obter(Long id) {
        ModeloBenVLI modeloBenVLI = new ModeloBenVLI();
        modeloBenVLI.setId(id);
        return obter(modeloBenVLI);
    }

    @Override
    public ModeloBenVLI obter(ModeloBenVLI modeloBenVLI) {
        return new ImpBenVLITempDAOImpl().obter(modeloBenVLI.getId());
    }

    @Override
    public void limparTbTemp() {
        new ImpBenVLITempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpBenVLITempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        salvarTbTemp(new LerArquivoBenVLI().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloBenVLI> listaModeloBenVLI) {
        new ImpBenVLITempDAOImpl().salvarTbTemp(listaModeloBenVLI);
    }

    @Override
    public Long contar() {
        return new ImpBenVLITempDAOImpl().contar();
    }
}
