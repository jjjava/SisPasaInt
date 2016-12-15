package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface LogBean {
    void cadastrar(Log l);
    void atualizar (Log l);
    void apagar(Log l);
    List<Log> listar(); 
}
