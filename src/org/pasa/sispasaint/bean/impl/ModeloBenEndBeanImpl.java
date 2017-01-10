package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ModeloBenEndBean;
import org.pasa.sispasaint.dao.impl.ModeloBenEndDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.rw.LerArquivosBenEnd;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.2
 */
public class ModeloBenEndBeanImpl implements ModeloBenEndBean {

    private final ModeloBenEndDAOImpl modeloBenEndDAO;
    
    public ModeloBenEndBeanImpl() {
        this.modeloBenEndDAO = new ModeloBenEndDAOImpl();
    }

    @Override
    public ModeloBenEnd obter(Long id) {
        return modeloBenEndDAO.obter(id);
    }

    @Override
    public ModeloBenEnd obter(ModeloBenEnd modelo) {
        return modeloBenEndDAO.obter(modelo.getId());
    }

    @Override
    public void limparTbTemp() {
        modeloBenEndDAO.limpaTB();
    }

    @Override
    public void resetarIdentity() {
        modeloBenEndDAO.resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id, Log log) {
        LerArquivosBenEnd la = new LerArquivosBenEnd(log);
        la.ler(id);
    }

    @Override
    public void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd) {
        modeloBenEndDAO.salvarTbTemp(listaModeloBenEnd);
    }

    @Override
    public void cadastrar(ModeloBenEnd modelo) {
        modeloBenEndDAO.cadastrar(modelo);
    }

    @Override
    public Long contar() {
        return modeloBenEndDAO.contar();
    }

    @Override
    public List<ModeloBenEnd> listarBeneficiarios(ModeloBenEnd modelo) {
        return modeloBenEndDAO.listarBeneficiarios(modelo.getEmpresa(), modelo.getMatricula());
    }
    
    @Override
    public List<String> listarEmpresasPorAquivo(){
        return modeloBenEndDAO.listarEmpresasPorAquivo();
    }
}
