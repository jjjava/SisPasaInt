package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenExt;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenExtTempDAO {
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenExt> listaModeloBenExt);
}