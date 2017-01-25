package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenVLITempDAO {
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI);
    public List<ModeloBenPeople> listar(String empresa, String matricula);
}