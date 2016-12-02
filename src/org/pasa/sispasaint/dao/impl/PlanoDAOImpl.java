package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.PlanoDAO;


/**
 *
 * @author 90J00318
 */
public class PlanoDAOImpl extends DaoGenerico<Plano> implements PlanoDAO{
    
    public PlanoDAOImpl() {
        super(Plano.class);
    }

    @Override
    public Plano existe(String codigo) {
        Query q1 = getEntityManager().
        createQuery("select p from Plano p where p.codPlano = :cod");
        q1.setParameter("cod", codigo);
        q1.setMaxResults(1);
        List<Plano> plano = null;
        try {
            plano = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println("Plano "+ex);
            return null;
        }
        if (plano.size() > 0) {
            return plano.get(0);
        }
        return null;
    }    
}