package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.TelefoneDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class TelefoneDAOImpl extends DaoGenerico<Telefone> implements TelefoneDAO {

    public TelefoneDAOImpl() {
        super(Telefone.class);
    }
}
