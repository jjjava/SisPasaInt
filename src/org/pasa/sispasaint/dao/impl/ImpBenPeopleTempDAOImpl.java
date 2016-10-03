package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpBenPeopleTempDAO;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author hudson
 */
public class ImpBenPeopleTempDAOImpl extends DaoGenerico<ModeloBenPeople> implements ImpBenPeopleTempDAO {

    public ImpBenPeopleTempDAOImpl() {
        super(ModeloBenPeople.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasaint].[dbo].[TEMP_BEN_PEOPLE]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople) {
        for (ModeloBenPeople model : listaModeloBenPeople) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                System.err.println(ex);
                getEntityManager().getTransaction().begin();
                getEntityManager().getTransaction().rollback();
                getEntityManager().getTransaction().commit();
            }
        }
    }
}
