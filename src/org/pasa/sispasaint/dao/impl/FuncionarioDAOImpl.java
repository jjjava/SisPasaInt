package org.pasa.sispasaint.dao.impl;

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
    public Funcionario obter(String empresa, String matricula){
        Funcionario f = new Funcionario();    
        System.err.println(empresa+"  "+ matricula);
        try {
            Query q1 = getEntityManager().
            createQuery("select f from Funcionario f WHERE f.codEmpresa = :empresa AND f.matricula = :matricula");
            q1.setParameter("empresa", empresa);
            q1.setParameter("matricula", matricula);
            f = (Funcionario) q1.getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e);
            return f;
        }
        return f;
    }
}
