package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.Query;
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
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[MODELO]', RESEED, 0)");
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
                System.err.println(ex);
                getEntityManager().getTransaction().rollback();
            }
        }
    }
}
