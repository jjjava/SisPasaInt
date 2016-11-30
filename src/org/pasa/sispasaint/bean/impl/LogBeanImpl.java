package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.LogBean;
import org.pasa.sispasaint.dao.impl.LogDAOImpl;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author 90J00318
 */
public class LogBeanImpl implements LogBean{

    public LogBeanImpl(){
    }

    @Override
    public void cadastrar(Log l) {
        new LogDAOImpl().cadastrar(l);
    }

    @Override
    public void atualizar(Log l) {
        new LogDAOImpl().atualizar(l);
    }

    @Override
    public void apagar(Log l) {
        new LogDAOImpl().apagar(l);
    }

    @Override
    public List<Log> listar() {
        return new LogDAOImpl().listar();
    }   
}