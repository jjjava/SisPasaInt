package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenPeopleTempDAO {
    ModeloBenPeople obter(Long id);
    boolean cadastrar(ModeloBenPeople modelo);
    Long contar();
    void limpaTB();
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI);
}