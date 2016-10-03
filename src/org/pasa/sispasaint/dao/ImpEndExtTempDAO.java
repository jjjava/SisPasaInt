
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloEndExt;

/**
 *
 * @author hudson
 */
public interface ImpEndExtTempDAO {
    ModeloEndExt obter(Long id);
    ModeloEndExt obterPorMatricula(String empresa, String matricula, String codBeneficiario);
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloEndExt> listaModeloEndExt);
}
