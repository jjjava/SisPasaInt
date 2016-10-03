package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.model.Funcionario;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public interface FuncionarioBean {
    Funcionario obter(Funcionario f);
    void cadastar(Funcionario f);
    void atualizar(Funcionario f);
    void apagar(Funcionario f);
}