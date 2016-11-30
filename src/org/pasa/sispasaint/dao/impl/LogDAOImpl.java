package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.LogDAO;
import org.pasa.sispasaint.model.intg.Log;

/**
 *
 * @author 90J00318
 */
public class LogDAOImpl extends DaoGenerico<Log> implements LogDAO{

    public LogDAOImpl() {
         super(Log.class);
    }
}
