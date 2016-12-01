package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.DestinatarioDAO;
import org.pasa.sispasaint.model.intg.Destinatario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DestinatarioDAOImpl extends DaoGenerico<Destinatario> implements DestinatarioDAO{
    
    public DestinatarioDAOImpl() {
        super(Destinatario.class);
    }
}
