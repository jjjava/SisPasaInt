package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.rw.LerArquivoBenPeople;
import org.pasa.sispasaint.bean.ImpBenPeopleTempBean;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleTempBeanImpl implements ImpBenPeopleTempBean {

    private final ImpBenPeopleTempDAOImpl modeloDAO;

    public ImpBenPeopleTempBeanImpl() {
        modeloDAO = new ImpBenPeopleTempDAOImpl();
    }

    @Override
    public ModeloBenPeople obter(Long id) {
        ModeloBenPeople modeloBenPeople = new ModeloBenPeople();
        modeloBenPeople.setId(id);
        return obter(modeloBenPeople);
    }

    @Override
    public ModeloBenPeople obter(ModeloBenPeople modelo) {
        return modeloDAO.obter(modelo.getId());
    }

    @Override
    public void limparTbTemp() {
        modeloDAO.limpaTB();
    }

    @Override
    public void resetarIdentity() {
        modeloDAO.resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id, Log log) {
        new LerArquivoBenPeople(log).lerArquivo(id);
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI) {
        modeloDAO.salvarTbTemp(listaModeloBenVLI);
    }

    @Override
    public Long contar() {
        return modeloDAO.contar();
    }
    
    @Override
    public List<ModeloBenPeople> listarBeneficiarios(ModeloBenPeople modeloBenPeople) {
        return listarBeneficiarios(modeloBenPeople.getEmpresa(), modeloBenPeople.getMatricula());
    }
    
    @Override
    public List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula) {
        return modeloDAO.listarBeneficiarios(empresa, matricula);
    }
}
