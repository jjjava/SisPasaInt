package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ImpEndPeopleTempBean;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.sispasa.sispasaint.rw.LerArquivoEndPeople;

/**
 *
 * @author hudsonschumaker
 */
public class ImpEndPeopleTempBeanImpl implements ImpEndPeopleTempBean {
    
    @Override
    public ModeloEndPeople obter(ModeloEndPeople modeloEndPeople) {
        return new ImpEndPeopleTempDAOImpl().obter(modeloEndPeople.getId());
    }
    
    @Override
    public ModeloEndPeople obterPorMatricula(ModeloEndPeople modeloBenPeolpe) {
        return new ImpEndPeopleTempDAOImpl().obterPorMatricula(modeloBenPeolpe.getEmpresa(), modeloBenPeolpe.getMatricula(), modeloBenPeolpe.getCodBeneficiario());
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
    public void carregarArquivo() {
        salvarTbTemp(new LerArquivoEndPeople().lerArquivo());
    }
    
    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndPeolpe) {
        new ImpEndPeopleTempDAOImpl().salvarTbTemp(listaModeloEndPeolpe);
    }
    
    @Override
    public Long contar() {
        return new ImpEndPeopleTempDAOImpl().contar();
    }
}
