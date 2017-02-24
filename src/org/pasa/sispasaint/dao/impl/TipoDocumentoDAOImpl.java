package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.TipoDocumentoDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class TipoDocumentoDAOImpl extends DaoGenerico<TipoDocumento> implements TipoDocumentoDAO{
    
    public TipoDocumentoDAOImpl() {
        super(TipoDocumento.class);
    }
}
