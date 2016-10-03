package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.MunicipioDAO;
import org.pasa.sispasaint.model.Municipio;

/**
 *
 * @author Hudson Schumaker
 */
public class MunicipioDAOImpl extends DaoGenerico<Municipio> implements MunicipioDAO {

    public MunicipioDAOImpl() {
        super(Municipio.class);
    }

    @Override
    public Municipio existe(Municipio m) {
        return getEntityManager().createQuery("Select m from Municipio m  Where m.nome = '" + m.getNome() + "'", Municipio.class).getSingleResult();
    }
}
