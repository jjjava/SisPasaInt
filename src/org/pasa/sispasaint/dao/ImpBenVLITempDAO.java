package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenVLITempDAO {
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenVLI> listaModeloBenVLI);
    public List<ModeloBenVLI> listar(String empresa, String matricula);
}