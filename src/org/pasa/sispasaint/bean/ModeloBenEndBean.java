package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ModeloBenEndBean {
    ModeloBenEnd obter(Long id);
    ModeloBenEnd obter(ModeloBenEnd modelo);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id,Log log);
    void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd);
    void cadastrar(ModeloBenEnd modelo);
    Long contar();
}
