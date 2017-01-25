package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpEndVLITempBean;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.rw.LerArquivoEndPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleTempBeanImpl implements ImpEndVLITempBean {

    public ImpEndPeopleTempBeanImpl() {
    }

    @Override
    public ModeloEndPeople obter(ModeloEndPeople modeloEndPeople) {
        return new ImpEndPeopleTempDAOImpl().obter(modeloEndPeople.getId());
    }

    @Override
    public ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli) {
        return new ImpEndPeopleTempDAOImpl().obterPorMatricula(modeloBenVli.getEmpresa(), modeloBenVli.getMatricula(), modeloBenVli.getCodBeneficiario());
    }

    @Override
    public void limparTbTemp() {
        new ImpEndPeopleTempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpEndPeopleTempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        salvarTbTemp(new LerArquivoEndPeople().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        new ImpEndPeopleTempDAOImpl().salvarTbTemp(listaModeloEndVLI);
    }

    @Override
    public Long contar() {
        return new ImpEndPeopleTempDAOImpl().contar();
    }

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        return new ImpEndPeopleTempDAOImpl().list(empresa, matricula);
    }
}
