package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpBenVLITempDAO;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpBenVLITempDAOImpl extends DaoGenerico<ModeloBenVLI> implements ImpBenVLITempDAO {

    public ImpBenVLITempDAOImpl() {
        super(ModeloBenVLI.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasaint].[dbo].[TEMP_BEN_VLI]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenVLI> listaModeloBenVLI) {
        for (ModeloBenVLI model : listaModeloBenVLI) {
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