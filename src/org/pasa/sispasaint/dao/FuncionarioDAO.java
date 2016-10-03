package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Funcionario;

/**
 *
 * @author Hudson Schumaker
 */

public interface FuncionarioDAO {
    void cadastrar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void apagar(Funcionario funcionario);
    Funcionario obter(Long id);
    List<Funcionario> listar();
}
