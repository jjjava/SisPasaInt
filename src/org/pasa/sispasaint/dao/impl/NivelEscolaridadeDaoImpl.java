package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.NivelEscolaridadeDao;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class NivelEscolaridadeDaoImpl extends DaoGenerico<NivelEscolaridade> implements NivelEscolaridadeDao{

    public NivelEscolaridadeDaoImpl() {
        super(NivelEscolaridade.class);
    }

    @Override
    public NivelEscolaridade obter(String codExterno) {
        Query q1 = getEntityManager().
        createQuery("Select n From NivelEscolaridade n Where n.codExterno = :cod");
        q1.setParameter("cod", codExterno);
        q1.setMaxResults(1);
        List<NivelEscolaridade> nvEscolaridade = null;
        try {
            nvEscolaridade = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(MunicipioDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (nvEscolaridade.size() > 0) {
            return nvEscolaridade.get(0);
        }
        return null;
    }    
}
