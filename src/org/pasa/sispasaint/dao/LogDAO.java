package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author 90J00318
 */
public interface LogDAO {
    Log obter(Long id);
    boolean cadastrar(Log l);
    void atualizar (Log l);
    void apagar(Log l);
    List<Log> listar();
}
