package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.BeneficiarioDAO;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.Beneficiario;

/**
 *
 * @author 90J00318
 */
public class BeneficiarioDAOImpl extends DaoGenerico<Beneficiario> implements BeneficiarioDAO{

    public BeneficiarioDAOImpl() {
        super(Beneficiario.class);
    }

    @Override
    public Beneficiario obter(String empresa, String matricula, String codBeneficiario) {
       Query q1 = getEntityManager().
                createQuery("select b from Beneficiario b where b.codEmpresa = :emp AND b.matricula = :mat AND b.codBeneficiario =: cod" );
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        q1.setParameter("cod", codBeneficiario);
        q1.setMaxResults(1);
        List<Beneficiario> beneficiario = null;
        try {
            beneficiario = q1.getResultList();
            System.err.println(beneficiario.size());
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        }
        if (beneficiario.size() > 0) {
          return  beneficiario.get(0);
        }
        return null;
    }
    
}
