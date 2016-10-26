package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpEndExtTempDAO;
import org.pasa.sispasaint.model.intg.ModeloEndExt;

/**
 *
 * @author hudson
 */
public class ImpEndExtTempDAOImpl extends DaoGenerico<ModeloEndExt> implements ImpEndExtTempDAO {

    public ImpEndExtTempDAOImpl() {
        super(ModeloEndExt.class);
    }

    @Override
    public ModeloEndExt obterPorMatricula(String empresa, String matricula, String codBeneficiario) {
        ModeloEndExt m = new ModeloEndExt();
        try {
            getEntityManager().getTransaction().begin();

            Query q1 = getEntityManager().createNativeQuery("select * from TEMP_END_EXT where empresa = '" + empresa
                    + "' and matricula = '" + matricula + "' and codbeneficiario = '" + codBeneficiario + "' ");
            m = (ModeloEndExt) q1.getSingleResult();
            System.err.println("Bairo: " + m.getBairro());
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
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasaint].[dbo].[TEMP_END_EXT]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloEndExt> listaModeloEndExt) {
        for (ModeloEndExt model : listaModeloEndExt) {
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
