package org.pasa.sispasaint.dao.impl;

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
}
