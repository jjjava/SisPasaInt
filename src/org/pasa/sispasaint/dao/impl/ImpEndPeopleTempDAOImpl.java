package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpEndPeopleTempDAO;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author hudson
 */
public class ImpEndPeopleTempDAOImpl extends DaoGenerico<ModeloEndPeople> implements ImpEndPeopleTempDAO{

    public ImpEndPeopleTempDAOImpl() {
        super(ModeloEndPeople.class);
    }

    @Override
    public ModeloEndPeople obterPorMatricula(String empresa, String matricula, String codBeneficiario) {
        ModeloEndPeople m = new ModeloEndPeople();
        try {
            getEntityManager().getTransaction().begin();            
            
            Query q1 = getEntityManager().createNativeQuery("select * from TEMP_END_PEOPLE where empresa = '" + empresa
                    + "' and matricula = '" + matricula + "' and codbeneficiario = '" + codBeneficiario + "' ");
            m = (ModeloEndPeople) q1.getSingleResult();
            getEntityManager().getTransaction().commit();
            
        } catch (NoResultException e) {
            System.out.println(e);
            return m;
        } finally {
            return m;
        }
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa].[dbo].[TEMP_END_PEOPLE]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndPeople) {

        for (ModeloEndPeople model : listaModeloEndPeople) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                getEntityManager().getTransaction().rollback();
            }
        }
    }
}
