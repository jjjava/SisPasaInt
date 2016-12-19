package org.pasa.sispasaint.bean.impl;

import java.util.List;
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
        return new BeneficiarioDAOImpl().obter(matricula, codBeneficiario);
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

    @Override
    public List<Beneficiario> listar() {
        return new BeneficiarioDAOImpl().listar();
    }

    @Override
    public List<Beneficiario> listar(String empresa, String matricula) {
        return new BeneficiarioDAOImpl().listar(empresa, matricula);
    }

    @Override
    public Integer atulizaStatus(String empresa) {
        return new BeneficiarioDAOImpl().atulizaStatus(empresa);
    }

    @Override
    public Long getInativos(String empresa) {
        return new BeneficiarioDAOImpl().getInativos(empresa);
    }
}
