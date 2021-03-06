package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.TipoVinculoEmpregaticioDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class TipoVinculoEmpregaticioDAOImpl extends DaoGenerico<TipoVinculoEmpregaticio> implements TipoVinculoEmpregaticioDAO {

    public TipoVinculoEmpregaticioDAOImpl() {
        super(TipoVinculoEmpregaticio.class);
    }

    @Override
    public TipoVinculoEmpregaticio obter(String cdExterno) {
        Query q1 = getEntityManager().
                createQuery("select t from TipoVinculoEmpregaticio t where t.codExterno  = :cd");
        q1.setParameter("cd", cdExterno);
        q1.setMaxResults(1);
        List<TipoVinculoEmpregaticio> tve = null;
        try {
            tve = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(TipoVinculoEmpregaticioDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (tve.size() > 0) {
            return tve.get(0);
        }
        return null;
    }
}
