package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpEndVLITempBean;
import org.pasa.sispasaint.dao.impl.ImpEndVLITempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;
import org.sispasa.sispasaint.rw.LerArquivoEndVLI;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpEndVLITempBeanImpl implements ImpEndVLITempBean {

    public ImpEndVLITempBeanImpl() {
    }

    @Override
    public ModeloEndVLI obter(ModeloEndVLI modeloEndVli) {
        return new ImpEndVLITempDAOImpl().obter(modeloEndVli.getId());
    }

    @Override
    public ModeloEndVLI obterPorMatricula(ModeloBenVLI modeloBenVli) {
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
    public void carregarArquivo() {
        salvarTbTemp(new LerArquivoEndVLI().lerArquivo());
    }

    @Override
    public void salvarTbTemp(List<ModeloEndVLI> listaModeloEndVLI) {
        new ImpEndVLITempDAOImpl().salvarTbTemp(listaModeloEndVLI);
    }

    @Override
    public Long contar() {
        return new ImpEndVLITempDAOImpl().contar();
    }
}
