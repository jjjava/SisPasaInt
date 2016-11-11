package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpEndVLITempDAO;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;

/**
 *
 * @author Hudson Schumaker
 */
public class ImpEndVLITempDAOImpl extends DaoGenerico<ModeloEndVLI> implements ImpEndVLITempDAO {

    public ImpEndVLITempDAOImpl() {
        super(ModeloEndVLI.class);
    }

    @Override
    public ModeloEndVLI obterPorMatricula(String empresa, String matricula, String codBeneficiario) {
        ModeloEndVLI m = new ModeloEndVLI();
        try {
            Query q1 = getEntityManager().
            createQuery("select e from ModeloEndVLI e WHERE e.empresa = :empresa AND e.matricula = :matricula AND e.codBeneficiario =:cod");
            q1.setParameter("empresa", empresa);
            q1.setParameter("matricula", matricula);
            q1.setParameter("cod", codBeneficiario);
            m = (ModeloEndVLI) q1.getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e);
            return m;
        }
        return m;
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[TEMP_END_VLI]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloEndVLI> listaModeloEndVLI) {
        for (ModeloEndVLI model : listaModeloEndVLI) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
                getEntityManager().getTransaction().rollback();
            }
        }
    }
}
