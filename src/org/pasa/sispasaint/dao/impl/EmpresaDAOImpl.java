package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EmpresaDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class EmpresaDAOImpl extends DaoGenerico<Empresa> implements EmpresaDAO{

    public EmpresaDAOImpl() {
        super(Empresa.class);
    }

    @Override
    public Empresa existe(String codigo) {
        Query q1 = getEntityManager().
        createQuery("select e from Empresa e where e.codEmpresaVale = :cod");
        q1.setParameter("cod", codigo);
        q1.setMaxResults(1);
        List<Empresa> empresa = null;
        try {
            empresa = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(EmpresaDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (empresa.size() > 0) {
            return empresa.get(0);
        }
        return null;
    }
}
