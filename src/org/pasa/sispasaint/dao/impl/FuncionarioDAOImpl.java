package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.FuncionarioDAO;
import org.pasa.sispasaint.model.Funcionario;

/**
 *
 * @author Hudson Schumaker
 */
public class FuncionarioDAOImpl extends DaoGenerico<Funcionario> implements FuncionarioDAO {

    public FuncionarioDAOImpl() {
        super(Funcionario.class);
    }

    @Override
    public Funcionario obter(String empresa, String matricula) {
        Query q1 = getEntityManager().
                createQuery("select f from Funcionario f where f.empresa.codEmpresa = :emp AND f.matricula = :mat");
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        q1.setMaxResults(1);
        List<Funcionario> funcionarios = null;
        try {
            funcionarios = q1.getResultList();
            System.err.println(funcionarios.size());
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        }
        if (funcionarios.size() > 0) {
          return  funcionarios.get(0);
        }
        return null;
    }
}
