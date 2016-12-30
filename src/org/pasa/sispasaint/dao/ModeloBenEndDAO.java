
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
    boolean cadastrar(ModeloBenEnd modelo);
    void limpaTB();
    void resetarIdentity();
    void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd);
    Long contar();
    List<ModeloBenEnd> listarBeneficiarios(String empresa, String matricula);
    List<String> listarEmpresasPorAquivo();
}
