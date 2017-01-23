package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasaint.dao.BeneficiarioDAO;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class BeneficiarioDAOImpl extends DaoGenerico<Beneficiario> implements BeneficiarioDAO {

    public BeneficiarioDAOImpl() {
        super(Beneficiario.class);
    }

    @Override
    public Beneficiario obter(String matricula, String codBeneficiario) {
        Query q1 = getEntityManager().
                createQuery("select b from Beneficiario b where b.matriculaAMS = :mat AND b.codBeneficiario = :cod");
        q1.setParameter("mat", matricula);
        q1.setParameter("cod", codBeneficiario);
        q1.setMaxResults(1);
        List<Beneficiario> beneficiario = null;
        try {
            beneficiario = q1.getResultList();
        } catch (NoResultException e) {
            System.err.println("Ben:" + e);
            Logger.getLogger(BeneficiarioDAOImpl.class).error(e);
            return null;
        }
        if (beneficiario.size() > 0) {
            return beneficiario.get(0);
        }
        return null;
    }

    @Override
    public List<Beneficiario> listar(String empresa, String matricula) {
        Query q1 = getEntityManager().
                createQuery("select b from Beneficiario b where b.matriculaAMS = :mat AND b.funcionario.empresa.codEmpresaVale = :emp");
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        List<Beneficiario> beneficiarios = null;
        try {
            beneficiarios = q1.getResultList();
        } catch (NoResultException e) {
            System.err.println(e);
            Logger.getLogger(BeneficiarioDAOImpl.class).error(e);
            return null;
        }
        return beneficiarios;
    }

    @Override
    public Integer atulizaStatus(String empresa) {
        try {
            getEntityManager().getTransaction().begin();
            Query q1 = getEntityManager().
                    createQuery("update Beneficiario b set b.indAtivo = :status where SUBSTRING(b.carteirinha,1,2) = '" + empresa + "'");
            q1.setParameter("status", SisPasaIntCommon.INATIVO);
            return q1.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BeneficiarioDAOImpl.class).error(e);
            System.err.println(e);
        } finally {
            getEntityManager().getTransaction().commit();
        }
        return -1;
    }

    @Override
    public Long getInativos(String empresa) {
        Query q1 = getEntityManager().
        createQuery("select count(b) from Beneficiario b where b.indAtivo = :status and SUBSTRING(b.carteirinha,1,2) = '" + empresa + "'");
        q1.setParameter("status",SisPasaIntCommon.INATIVO);
        Long count = 0L;
        try {
            count = (Long) q1.getSingleResult();
        } catch (NoResultException e) {
            Logger.getLogger(BeneficiarioDAOImpl.class).error(e);
            System.err.println(e);
        }
        return count;
    }
}
