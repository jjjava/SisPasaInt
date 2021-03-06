package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Funcionario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface FuncionarioBean {
    Funcionario obter(Funcionario f);
    Funcionario obter(String empresa, String matricula);
    boolean cadastrar(Funcionario f);
    boolean atualizar(Funcionario f);
    void apagar(Funcionario f);
    List<Funcionario> listar();
    Integer atualizaStatus(Long empresa);
}
