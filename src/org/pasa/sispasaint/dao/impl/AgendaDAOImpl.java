package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.AgendaDAO;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.Agenda;

/**
 *
 * @author 90J00318
 */
public class AgendaDAOImpl extends DaoGenerico<Agenda> implements AgendaDAO{

    public AgendaDAOImpl() {
        super(Agenda.class);
    }

    @Override
    public Agenda existe(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
