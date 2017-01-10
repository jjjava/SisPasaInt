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

    private final BeneficiarioDAOImpl beneficiarioDAO;
    
    public BeneficiarioBeanImpl() {
        this.beneficiarioDAO = new BeneficiarioDAOImpl();
    }

    @Override
    public Beneficiario obter(Beneficiario b) {
        return beneficiarioDAO.obter(b.getId());
    }

    @Override
    public Beneficiario obter(String empresa, String matricula, String codBeneficiario) {
        return beneficiarioDAO.obter(matricula, codBeneficiario);
    }

    @Override
    public void cadastar(Beneficiario b) {
        beneficiarioDAO.cadastrar(b);
    }

    @Override
    public void atualizar(Beneficiario b) {
        beneficiarioDAO.atualizar(b);
    }

    @Override
    public void apagar(Beneficiario b) {
        beneficiarioDAO.apagar(b);
    }

    @Override
    public List<Beneficiario> listar() {
        return beneficiarioDAO.listar();
    }

    @Override
    public List<Beneficiario> listar(String empresa, String matricula) {
        return beneficiarioDAO.listar(empresa, matricula);
    }

    @Override
    public Integer atulizaStatus(String empresa) {
        return beneficiarioDAO.atulizaStatus(empresa);
    }

    @Override
    public Long getInativos(String empresa) {
        return beneficiarioDAO.getInativos(empresa);
    }
}
