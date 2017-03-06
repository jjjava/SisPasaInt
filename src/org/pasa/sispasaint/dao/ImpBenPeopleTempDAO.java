package org.pasa.sispasaint.dao;

import org.pasa.sispasaint.model.intg.ModeloBenPeopleTemp;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenPeopleTempDAO {
    ModeloBenPeopleTemp obter(Long id);
    boolean cadastrar(ModeloBenPeopleTemp modelo);
    Long contar();
    void limpaTB();
    void resetarIdentity(); 
}