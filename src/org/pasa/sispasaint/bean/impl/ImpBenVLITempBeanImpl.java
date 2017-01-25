package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpBenVLITempBean;
import org.pasa.sispasaint.dao.impl.ImpBenVLITempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.rw.LerArquivoBenPeople;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpBenVLITempBeanImpl implements ImpBenVLITempBean {

    public ImpBenVLITempBeanImpl() {
    }

    @Override
    public ModeloBenPeople obter(Long id) {
        ModeloBenPeople modeloBenVLI = new ModeloBenPeople();
        modeloBenVLI.setId(id);
        return obter(modeloBenVLI);
    }

    @Override
    public ModeloBenPeople obter(ModeloBenPeople modeloBenVLI) {
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
        salvarTbTemp(new LerArquivoBenPeople().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI) {
        new ImpBenVLITempDAOImpl().salvarTbTemp(listaModeloBenVLI);
    }

    @Override
    public Long contar() {
        return new ImpBenVLITempDAOImpl().contar();
    }

    @Override
    public List<ModeloBenPeople> listar(String empresa, String matricula) {
      return new ImpBenVLITempDAOImpl().listar(empresa, matricula);
    }
}
