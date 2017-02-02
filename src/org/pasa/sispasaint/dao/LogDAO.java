package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author Hudson Schumaker
 */
public interface LogDAO {
    Log obter(Long id);
    boolean cadastrar(Log l);
    boolean atualizar (Log l);
    void apagar(Log l);
    List<Log> listar();
}
