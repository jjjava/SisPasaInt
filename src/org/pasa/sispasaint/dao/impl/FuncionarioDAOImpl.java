package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Funcionario;
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
        } catch (NoResultException e) {
            Logger.getLogger(FuncionarioDAOImpl.class).error(e);
            System.err.println("Func " + e);
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
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAOImpl.class).error(e);
            System.err.println(e);
        } finally {
            getEntityManager().getTransaction().commit();
        }
        return -1;
    }
}
