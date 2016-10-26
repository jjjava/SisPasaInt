package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.Telefone;

/**
 *
 * @author Hudson Schumaker
 */

public interface TelefoneBean {
    void cadastrar(Telefone t);
    void atualizar(Telefone t);
    void apagar(Telefone t);
    Telefone obter(Telefone t);
    List<Telefone> listar();
}
