package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EmpresaDAO;
import org.pasa.sispasaint.model.Empresa;
import org.pasa.sispasaint.model.Municipio;

/**
 *
 * @author 90J00318
 */
public class EmpresaDAOImpl extends DaoGenerico<Empresa> implements EmpresaDAO{

    public EmpresaDAOImpl() {
        super(Empresa.class);
    }

    @Override
    public Empresa existe(Empresa e) {
        Query q1 = getEntityManager().
        createQuery("select e from Empresa e where e.codEmpresa = :cod");
        q1.setParameter("cod", e.getNome());
        q1.setMaxResults(1);
        List<Empresa> empresa = null;
        try {
            empresa = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(ex);
            return null;
        }
        if (empresa.size() > 0) {
            return empresa.get(0);
        }
        return null;
    }
    
}
