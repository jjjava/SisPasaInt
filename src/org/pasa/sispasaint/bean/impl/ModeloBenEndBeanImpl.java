package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ModeloBenEndBean;
import org.pasa.sispasaint.dao.impl.ModeloBenEndDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.rw.LerArquivosBenEnd;

/**
 *
 * @author 90J00318
 */
public class ModeloBenEndBeanImpl implements ModeloBenEndBean{

    @Override
    public ModeloBenEnd obter(Long id) {
       return new ModeloBenEndDAOImpl().obter(id);
    }

    @Override
    public ModeloBenEnd obter(ModeloBenEnd modelo) {
         return new ModeloBenEndDAOImpl().obter(modelo.getId());
    }

    @Override
    public void limparTbTemp() {
       new ModeloBenEndDAOImpl().limpaTB();
    }

    @Override
    public void resetarIdentity() {
        new ModeloBenEndDAOImpl().resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id) {
        LerArquivosBenEnd la = new LerArquivosBenEnd();
        la.ler(id);
    }

    @Override
    public void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd) {
         new ModeloBenEndDAOImpl().salvarTbTemp(listaModeloBenEnd);
    }

    @Override
    public void cadastrar(ModeloBenEnd modelo) {
        new ModeloBenEndDAOImpl().cadastrar(modelo);
    }

    @Override
    public Long contar() {
       return new ModeloBenEndDAOImpl().contar();
    }
}
