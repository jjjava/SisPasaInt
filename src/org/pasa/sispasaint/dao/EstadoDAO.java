package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Estado;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface EstadoDAO {
    boolean cadastrar(Estado e);
    boolean atualizar(Estado e);
    void apagar(Estado e);
    Estado obter(Long id);
    Estado obter(String uf);
    List<Estado> listar();
}
