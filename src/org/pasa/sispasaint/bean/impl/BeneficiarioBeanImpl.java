package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.BeneficiarioBean;
import org.pasa.sispasaint.dao.impl.BeneficiarioDAOImpl;
import org.pasa.sispasa.core.model.Beneficiario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class BeneficiarioBeanImpl implements BeneficiarioBean {

    public BeneficiarioBeanImpl() {
    }

    @Override
    public Beneficiario obter(Beneficiario b) {
        return new BeneficiarioDAOImpl().obter(b.getId());
    }

    @Override
    public Beneficiario obter(String empresa, String matricula, String codBeneficiario) {
        return new BeneficiarioDAOImpl().obter(empresa, matricula, codBeneficiario);
    }

    @Override
    public void cadastar(Beneficiario b) {
        new BeneficiarioDAOImpl().cadastrar(b);
    }

    @Override
    public void atualizar(Beneficiario b) {
        new BeneficiarioDAOImpl().atualizar(b);
    }

    @Override
    public void apagar(Beneficiario b) {
       new BeneficiarioDAOImpl().apagar(b);
    }
}
