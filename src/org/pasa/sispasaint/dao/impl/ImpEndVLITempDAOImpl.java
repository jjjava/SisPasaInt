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
            getEntityManager().getTransaction().begin();
            System.out.println("select * from TEMP_END_VLI where empresa ='" + empresa
                    + "' and matricula ='" + matricula + "' and codbeneficiario ='" + codBeneficiario + "'");
            
            Query q1 = getEntityManager().createNativeQuery("select * from TEMP_END_VLI where empresa = '" + empresa
                    + "' and matricula = '" + matricula + "' and codbeneficiario = '" + codBeneficiario + "' ");
            m = (ModeloEndVLI) q1.getSingleResult();
            System.err.println("Bairo: "+m.getBairro());
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
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasaint].[dbo].[TEMP_END_VLI]', RESEED, 0)");
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
                getEntityManager().getTransaction().rollback();
            }
        }
    }
}
