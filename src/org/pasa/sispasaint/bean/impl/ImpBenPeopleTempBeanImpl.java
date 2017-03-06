package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.ImpBenPeopleTempBean;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeopleTemp;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleTempBeanImpl implements ImpBenPeopleTempBean {

    private final ImpBenPeopleTempDAOImpl modeloDAO;

    public ImpBenPeopleTempBeanImpl() {
        this.modeloDAO = new ImpBenPeopleTempDAOImpl();
    }

    @Override
    public ModeloBenPeopleTemp obter(Long id) {
        return modeloDAO.obter(id);
    }

    @Override
    public void limparTabela(String nomeArquivo) {
        modeloDAO.limpaTB(nomeArquivo);
    }

    @Override
    public void resetarIdentity() {
        modeloDAO.resetarIdentity();
    }

    @Override
    public Long contar() {
        return modeloDAO.contar();
    }
}
