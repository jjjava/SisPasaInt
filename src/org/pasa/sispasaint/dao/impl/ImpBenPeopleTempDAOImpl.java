package org.pasa.sispasaint.dao.impl;

import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ImpBenPeopleTempDAO;
import org.pasa.sispasaint.model.intg.ModeloBenPeopleTemp;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleTempDAOImpl extends DaoGenerico<ModeloBenPeopleTemp> implements ImpBenPeopleTempDAO {

    public ImpBenPeopleTempDAOImpl() {
        super(ModeloBenPeopleTemp.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[sispasa-dev].[dbo].[CARG_BEN_PEOPLE_TMP]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    public void limpaTB(String nomeArquivo) {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("delete from [sispasa-dev].[dbo].[CARG_BEN_PEOPLE_TMP]"
                + " WHERE [NOMEARQUIVO] = '" + nomeArquivo + "'");
        getEntityManager().getTransaction().commit();
    }
}
