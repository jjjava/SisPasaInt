package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.PlanoDAO;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class PlanoDAOImpl extends DaoGenerico<Plano> implements PlanoDAO{
    
    public PlanoDAOImpl() {
        super(Plano.class);
    }

    @Override
    public Plano existe(String codPlano, String codEmpresa) {
        Query q1 = getEntityManager().
        createQuery("Select p from Plano p Where p.codPlano = :codPlan And p.contrato.empresa.codEmpresaVale = :codEmp");
        q1.setParameter("codPlan", codPlano);
        q1.setParameter("codEmp", codEmpresa);
        q1.setMaxResults(1);
        List<Plano> plano = null;
        try {
            plano = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(PlanoDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (plano.size() > 0) {
            return plano.get(0);
        }
        return null;
    }    
}