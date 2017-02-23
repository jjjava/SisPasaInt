package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.dao.ImpEndPeopleTempDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleTempDAOImpl extends DaoGenerico<ModeloEndPeople> implements ImpEndPeopleTempDAO {

    public ImpEndPeopleTempDAOImpl() {
        super(ModeloEndPeople.class);
    }

    @Override
    public ModeloEndPeople obterPorMatricula(String empresa, String matricula, String codBeneficiario) {
        ModeloEndPeople m = new ModeloEndPeople();
        try {
            Query q1 = getEntityManager().
            createQuery("select e from ModeloEndPeople e WHERE e.empresa = :empresa AND e.matricula = :matricula");
            q1.setParameter("empresa", empresa);
            q1.setParameter("matricula", matricula);
           //q1.setParameter("cod", codBeneficiario);
            m = (ModeloEndPeople) q1.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("empresa: "+empresa+ " mat :"+matricula);
            System.err.println("ImpEndPeopleTempDAOImpl :"+ e);
            return m;
        }
        return m;
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[CARG_END_PEOPLE]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        for (ModeloEndPeople model : listaModeloEndVLI) {
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

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        Query q1 = getEntityManager().
        createQuery("select m from ModeloEndVLI m where m.matricula and = :mat and m.empresa = :emp and m.codBeneficiario <> '00'");
        q1.setParameter("emp", empresa); 
        q1.setParameter("mat", matricula); 
        List<ModeloEndPeople> ModeloEndVLIs = null;
        try {
            ModeloEndVLIs = q1.getResultList();
        } catch (NoResultException e) {
            System.out.println("empresa: "+empresa+ " mat :"+matricula);
            System.err.println("ImpEndPeopleTempDAOImpl :"+e);
            return null;
        }
        return ModeloEndVLIs;
    }
}
