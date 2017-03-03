package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.MunicipioDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class MunicipioDAOImpl extends DaoGenerico<Municipio> implements MunicipioDAO {

    public MunicipioDAOImpl() {
        super(Municipio.class);
    }

    @Override
    public Municipio existe(String nome) {
        Query q1 = getEntityManager().
        createQuery("Select m From Municipio m Where m.nome = :nome");
        q1.setParameter("nome", nome);
        q1.setMaxResults(1);
        List<Municipio> municipio = null;
        try {
            municipio = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(ex);
            Logger.getLogger(MunicipioDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (municipio.size() > 0) {
            return municipio.get(0);
        }
        return null;
    }
}
