package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author 90J00318
 */
public interface LogBean {
    
    void cadastrar(Log l);
    void atualizar (Log l);
    void apagar(Log l);
    List<Log> listar(); 
}
