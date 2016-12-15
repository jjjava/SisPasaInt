package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
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
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[TEMP_BEN_VLI]', RESEED, 0)");
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
                getEntityManager().getTransaction().rollback();
            }
        }
    }

    @Override
    public List<ModeloBenVLI> listar(String empresa, String matricula) {
        Query q1 = getEntityManager().
        createQuery("select m from ModeloBenVLI m where m.matricula = :mat and m.empresa = :emp and m.tipoBeneficiario <> 'T'");
        q1.setParameter("emp", empresa); 
        q1.setParameter("mat", matricula); 
        List<ModeloBenVLI> ModeloBenVLIs = null;
        try {
            ModeloBenVLIs = q1.getResultList();
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        }
        return ModeloBenVLIs;
    }
}