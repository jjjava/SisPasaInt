package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.FuncionarioBean;
import org.pasa.sispasaint.dao.impl.FuncionarioDAOImpl;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class FuncionarioBeanImpl implements FuncionarioBean {

    private final FuncionarioDAOImpl funcionarioDAO;
    
    public FuncionarioBeanImpl() {
        this.funcionarioDAO = new FuncionarioDAOImpl();
    }
    
    @Override
    public Funcionario obter(Funcionario f) {
        return funcionarioDAO.obter(f.getId());
    }
    
    @Override
    public Funcionario obter(String empresa, String matricula){
        return funcionarioDAO.obter(empresa, matricula);
    }

    @Override
    public void cadastar(Funcionario funcionario) {
        funcionarioDAO.cadastrar(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        funcionarioDAO.atualizar(funcionario);
    }

    @Override
    public void apagar(Funcionario funcionario) {
        funcionarioDAO.apagar(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
         return funcionarioDAO.listar();
    }

    @Override
    public Integer atualizaStatus(Long empresa) {
        return funcionarioDAO.atualizaStatus(empresa);
    }
}
