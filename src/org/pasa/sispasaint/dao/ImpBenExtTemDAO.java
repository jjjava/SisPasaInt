package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenExt;

/**
 *
 * @author 90J00318
 */
public interface ImpBenExtTemDAO {
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenExt> listaModeloExt);    
}
