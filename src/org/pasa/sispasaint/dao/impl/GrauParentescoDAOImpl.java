package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasa.core.model.GrauParentesco;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.GrauParentescoDAO;


/**
 *
 * @author 90J00318
 */
public class GrauParentescoDAOImpl extends DaoGenerico<GrauParentesco> implements GrauParentescoDAO {

    public GrauParentescoDAOImpl() {
        super(GrauParentesco.class);
    }

    @Override
    public GrauParentesco existe(String codigo) {
        Query q1 = getEntityManager().
                createQuery("select g from GrauParentesco g where g.descricao = :cod");
        q1.setParameter("cod", codigo);
        q1.setMaxResults(1);
        List<GrauParentesco> grauParentesco = null;
        try {
            grauParentesco = q1.getResultList();
            System.err.println(grauParentesco.size());
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        }
        if (grauParentesco.size() > 0) {
            return grauParentesco.get(0);
        }
        return null;
    }
}
