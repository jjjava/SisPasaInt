package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author hudson
 */
public interface ImpEndPeopleTempDAO {
    ModeloEndPeople obter(Long id);
    ModeloEndPeople obterPorMatricula(String empresa, String matricula, String codBeneficiario);
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloEndPeople> listaModeloEndPeople);
}
