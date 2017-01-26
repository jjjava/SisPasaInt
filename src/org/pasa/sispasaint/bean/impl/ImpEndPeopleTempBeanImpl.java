package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.rw.LerArquivoEndPeople;
import org.pasa.sispasaint.bean.ImpEndPeopleTempBean;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleTempBeanImpl implements ImpEndPeopleTempBean {

    private final ImpEndPeopleTempDAOImpl modeloDAO;

    public ImpEndPeopleTempBeanImpl() {
        modeloDAO = new ImpEndPeopleTempDAOImpl();
    }

    @Override
    public ModeloEndPeople obter(ModeloEndPeople modeloEndPeople) {
        return modeloDAO.obter(modeloEndPeople.getId());
    }

    @Override
    public ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli) {
        return modeloDAO.obterPorMatricula(modeloBenVli.getEmpresa(), modeloBenVli.getMatricula(), modeloBenVli.getCodBeneficiario());
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
        new LerArquivoEndPeople(log).lerArquivo(id);
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        modeloDAO.salvarTbTemp(listaModeloEndVLI);
    }

    @Override
    public Long contar() {
        return modeloDAO.contar();
    }

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        return modeloDAO.list(empresa, matricula);
    }
}
