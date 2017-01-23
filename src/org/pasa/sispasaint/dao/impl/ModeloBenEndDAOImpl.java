package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ModeloBenEndDAO;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ModeloBenEndDAOImpl extends DaoGenerico<ModeloBenEnd> implements ModeloBenEndDAO{

    public ModeloBenEndDAOImpl() {
        super(ModeloBenEnd.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa-dev].[dbo].[CARG_MODELO]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd) {
         for (ModeloBenEnd model : listaModeloBenEnd) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                Logger.getLogger(ModeloBenEndDAOImpl.class).error(ex);
                System.err.println(ex);
                getEntityManager().getTransaction().rollback();
            }
        }
    }

    @Override
    public List<ModeloBenEnd> listarBeneficiarios(String empresa, String matricula) {
        Query q1 = getEntityManager().
        createQuery("select m from ModeloBenEnd m where m.matricula = :mat and m.empresa = :emp");
        q1.setParameter("emp", empresa); 
        q1.setParameter("mat", matricula); 
        List<ModeloBenEnd> modelos = null;
        try {
            modelos = q1.getResultList();
        } catch (NoResultException e) {
            Logger.getLogger(ModeloBenEndDAOImpl.class).error(e);
            System.err.println(e);
            return null;
        }
        return modelos;
    }
    
    @Override
    public List<String> listarEmpresasPorAquivo(){
        Query q1 = getEntityManager().
        createQuery("select DISTINCT(m.empresa) m from ModeloBenEnd m");
        List<String> empresas = null;
        try {
            empresas = q1.getResultList();
        } catch (NoResultException e) {
            Logger.getLogger(ModeloBenEndDAOImpl.class).error(e);
            System.err.println(e);
            return null;
        }
        return empresas;
    }
}
