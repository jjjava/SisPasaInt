
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author hudson
 */
public interface ImpBenPeopleTempDAO {
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople);    
}
