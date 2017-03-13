package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EstadoDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class EstadoDAOImpl extends DaoGenerico<Estado> implements EstadoDAO {

    public EstadoDAOImpl() {
        super(Estado.class);
    }

    @Override
    public Estado obter(String uf) {
        Query q1 = getEntityManager().
        createQuery("Select e From Estado e Where e.id = :uf");
        q1.setParameter("uf", uf);
        q1.setMaxResults(1);
        List<Estado> estado = null;
        try {
            estado = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(EstadoDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (estado.size() > 0) {
            return estado.get(0);
        }
        return null;
    }
}
