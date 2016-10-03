package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpBenPeopleTempBean;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.sispasa.sispasaint.rw.LerArquivoBenPeople;

/**
 *
 * @author hudsonschumaker
 */
public class ImpBenPeopleTempBeanImpl implements ImpBenPeopleTempBean {

    public ImpBenPeopleTempBeanImpl() {
    }

    @Override
    public ModeloBenPeople obter(Long id) {
        ModeloBenPeople modeloBenPeople = new ModeloBenPeople();
        modeloBenPeople.setId(id);
        return obter(modeloBenPeople);
    }

    @Override
    public ModeloBenPeople obter(ModeloBenPeople modelo) {
        return new ImpBenPeopleTempDAOImpl().obter(modelo.getId());
    }

    @Override
    public void limparTbTemp() {
        new ImpBenPeopleTempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpBenPeopleTempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo() {
        salvarTbTemp(new LerArquivoBenPeople().lerArquivo());
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople) {
        new ImpBenPeopleTempDAOImpl().salvarTbTemp(listaModeloBenPeople);
    }

    @Override
    public Long contar() {
        return new ImpBenPeopleTempDAOImpl().contar();
    }
}
