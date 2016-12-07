package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpEndExtTempBean;
import org.pasa.sispasaint.dao.impl.ImpEndExtTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenExt;
import org.pasa.sispasaint.model.intg.ModeloEndExt;
import org.pasa.sispasaint.rw.LerArquivoEndExt;

/**
 *
 * @author 90J00318
 */
public class ImpEndExtTempBeanImpl implements ImpEndExtTempBean {

    public ImpEndExtTempBeanImpl() {
    }

    @Override
    public ModeloEndExt obter(ModeloEndExt modeloEndExt) {
        return  new ImpEndExtTempDAOImpl().obter(modeloEndExt.getId());
    }

    @Override
    public ModeloEndExt obterPorMatricula(ModeloBenExt modeloBenExt) {
        return  new ImpEndExtTempDAOImpl().obterPorMatricula(modeloBenExt.getEmpresa(), modeloBenExt.getMatricula(), modeloBenExt.getCodBeneficiario());
    }

    @Override
    public void limparTbTemp() {
        new ImpEndExtTempDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ImpEndExtTempDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        salvarTbTemp(new LerArquivoEndExt().lerArquivo(id));
    }

    @Override
    public void salvarTbTemp(List<ModeloEndExt> listaModeloEndExt) {
        new ImpEndExtTempDAOImpl().salvarTbTemp(listaModeloEndExt);
    }

    @Override
    public Long contar() {
        return new ImpEndExtTempDAOImpl().contar();
    }
}
