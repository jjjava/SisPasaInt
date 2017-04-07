package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.GrauParentesco;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.GrauParentescoDAO;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class GrauParentescoDAOImpl extends DaoGenerico<GrauParentesco> implements GrauParentescoDAO {

    public GrauParentescoDAOImpl() {
        super(GrauParentesco.class);
    }

    @Override
    public GrauParentesco existe(String codigo) {
        Query q1 = getEntityManager().
                createQuery("select g from GrauParentesco g where g.codExterno = :cod");
        q1.setParameter("cod", codigo);
        q1.setMaxResults(1);
        List<GrauParentesco> grauParentesco = null;
        try {
            grauParentesco = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(GrauParentescoDAOImpl.class).error(ex); 
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (grauParentesco.size() > 0) {
            return grauParentesco.get(0);
        }
        return null;
    }
}
