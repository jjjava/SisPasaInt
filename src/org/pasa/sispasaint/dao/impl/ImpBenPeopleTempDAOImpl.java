package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.dao.ImpBenPeopleTempDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleTempDAOImpl extends DaoGenerico<ModeloBenPeople> implements ImpBenPeopleTempDAO {

    public ImpBenPeopleTempDAOImpl() {
        super(ModeloBenPeople.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[CARG_BEN_PEOPLE]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI) {
        for (ModeloBenPeople model : listaModeloBenVLI) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                System.err.println(ex);
                Logger.getLogger(ImpBenPeopleTempDAOImpl.class).error(ex); 
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
                getEntityManager().getTransaction().rollback();
            }
        }
    }
    
    @Override
    public List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula) {
        Query q1 = getEntityManager().
        createQuery("select m from ModeloBenPeople m where m.matricula = :mat and m.empresa = :emp");
        q1.setParameter("emp", empresa); 
        q1.setParameter("mat", matricula); 
        List<ModeloBenPeople> modelos = null;
        try {
            modelos = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(ex);
            Logger.getLogger(ImpBenPeopleTempDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        return modelos;
    }
}
