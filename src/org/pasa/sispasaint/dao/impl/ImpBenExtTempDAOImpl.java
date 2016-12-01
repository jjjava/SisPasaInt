package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.ModeloBenExt;
import org.pasa.sispasaint.dao.ImpBenExtTemDAO;

/**
 *
 * @author hudson schumaker
 */
public class ImpBenExtTempDAOImpl extends DaoGenerico<ModeloBenExt> implements ImpBenExtTemDAO {

    public ImpBenExtTempDAOImpl() {
        super(ModeloBenExt.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[TEMP_BEN_EXT]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenExt> listaModeloBenExt) {
        listaModeloBenExt.stream().forEach((model) -> {
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
        });
    }
}
