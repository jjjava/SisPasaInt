package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.FuncionarioDAO;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class FuncionarioDAOImpl extends DaoGenerico<Funcionario> implements FuncionarioDAO {

    public FuncionarioDAOImpl() {
        super(Funcionario.class);
    }

    @Override
    public Funcionario obter(String empresa, String matricula) {
        Query q1 = getEntityManager().
                createQuery("select f from Funcionario f where f.empresa.codEmpresaVale = :emp AND f.matriculaOrigem = :mat");
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        q1.setMaxResults(1);
        List<Funcionario> funcionarios = null;
        try {
            funcionarios = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (funcionarios.size() > 0) {
            return funcionarios.get(0);
        }
        return null;
    }

    @Override
    public Integer atualizaStatus(Long empresa) {
        try {
            getEntityManager().getTransaction().begin();
            Query q1 = getEntityManager().
                    createQuery("update Funcionario f set f.indAtivo = :status");
            return q1.setParameter("status", SisPasaIntCommon.INATIVO).executeUpdate();
        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(FuncionarioDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        } finally {
            getEntityManager().getTransaction().commit();
        }
        return -1;
    }

    public Funcionario atualizaComID(Funcionario func) {
        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.merge(func);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex);
            Logger.getLogger(DaoGenerico.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        return f;
    }
}
