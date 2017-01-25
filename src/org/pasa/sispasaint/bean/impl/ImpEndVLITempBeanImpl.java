package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpEndVLITempBean;
import org.pasa.sispasaint.dao.impl.ImpEndVLITempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.rw.LerArquivoEndPeople;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpEndVLITempBeanImpl implements ImpEndVLITempBean {

    public ImpEndVLITempBeanImpl() {
    }

    @Override
    public ModeloEndPeople obter(ModeloEndPeople modeloEndVli) {
        return new ImpEndVLITempDAOImpl().obter(modeloEndVli.getId());
    }

    @Override
    public ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli) {
        return new ImpEndVLITempDAOImpl().obterPorMatricula(modeloBenVli.getEmpresa(), modeloBenVli.getMatricula(), modeloBenVli.getCodBeneficiario());
    }

    @Override
    public void limparTbTemp() {
        new ImpEndVLITempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpEndVLITempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        salvarTbTemp(new LerArquivoEndPeople().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        new ImpEndVLITempDAOImpl().salvarTbTemp(listaModeloEndVLI);
    }

    @Override
    public Long contar() {
        return new ImpEndVLITempDAOImpl().contar();
    }

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        return new ImpEndVLITempDAOImpl().list(empresa, matricula);
    }
}
