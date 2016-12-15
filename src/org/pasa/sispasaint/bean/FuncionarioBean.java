package org.pasa.sispasaint.bean;

import org.pasa.sispasa.core.model.Funcionario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface FuncionarioBean {
    Funcionario obter(Funcionario f);
    Funcionario obter(String empresa, String matricula);
    void cadastar(Funcionario f);
    void atualizar(Funcionario f);
    void apagar(Funcionario f);
}
