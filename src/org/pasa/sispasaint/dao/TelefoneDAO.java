package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Telefone;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface TelefoneDAO {
    boolean cadastrar(Telefone t);
    void atualizar(Telefone t);
    void apagar(Telefone t);
    Telefone obter(Long id);
    List<Telefone> listar();
}
