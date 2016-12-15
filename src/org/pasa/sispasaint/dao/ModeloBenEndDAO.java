
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ModeloBenEndDAO {
    ModeloBenEnd obter(Long id);
    void cadastrar(ModeloBenEnd modelo);
    void limparTbTemp();
    void resetarIdentity();
    void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd);
    Long contar();
}
