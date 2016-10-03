package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EstadoDAO;
import org.pasa.sispasaint.model.Estado;

/**
 *
 * @author Hudson Schumaker
 */
public class EstadoDAOImpl extends DaoGenerico<Estado> implements EstadoDAO {

    public EstadoDAOImpl() {
        super(Estado.class);
    }

    @Override
    public Estado existe(Estado e) {
        return getEntityManager().createQuery("Select e from Estado e  Where e.uf = '" + e.getUf() + "'", Estado.class).getSingleResult();
    }
}
