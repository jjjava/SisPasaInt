package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.MunicipioDAO;

/**
 *
 * @author Hudson Schumaker
 */
public class MunicipioDAOImpl extends DaoGenerico<Municipio> implements MunicipioDAO {

    public MunicipioDAOImpl() {
        super(Municipio.class);
    }

    @Override
    public Municipio existe(String nome) {
        Query q1 = getEntityManager().
        createQuery("select m from Municipio m where m.nome = :nome");
        q1.setParameter("nome", nome);
        q1.setMaxResults(1);
        List<Municipio> municipio = null;
        try {
            municipio = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println("Municipio :"+ex);
            return null;
        }
        if (municipio.size() > 0) {
            return municipio.get(0);
        }
        return null;
    }
}
