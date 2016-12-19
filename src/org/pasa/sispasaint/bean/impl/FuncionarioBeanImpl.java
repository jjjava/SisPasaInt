package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.FuncionarioBean;
import org.pasa.sispasaint.dao.impl.FuncionarioDAOImpl;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class FuncionarioBeanImpl implements FuncionarioBean {

    public FuncionarioBeanImpl() {
    }
    
    @Override
    public Funcionario obter(Funcionario f) {
        return new FuncionarioDAOImpl().obter(f.getId());
    }
    
    @Override
    public Funcionario obter(String empresa, String matricula){
        return new FuncionarioDAOImpl().obter(empresa, matricula);
    }

    @Override
    public void cadastar(Funcionario funcionario) {
        new FuncionarioDAOImpl().cadastrar(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        new FuncionarioDAOImpl().atualizar(funcionario);
    }

    @Override
    public void apagar(Funcionario funcionario) {
        new FuncionarioDAOImpl().apagar(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
         return new FuncionarioDAOImpl().listar();
    }

    @Override
    public Integer atualizaStatus(Long empresa) {
        return new FuncionarioDAOImpl().atualizaStatus(empresa);
    }
}
