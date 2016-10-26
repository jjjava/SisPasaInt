package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Telefone;


/**
 *
 * @author Hudson Schumaker
 */

public interface TelefoneDAO {
    void cadastrar(Telefone t);
    void atualizar(Telefone t);
    void apagar(Telefone t);
    Telefone obter(Long id);
    List<Telefone> listar();
}
