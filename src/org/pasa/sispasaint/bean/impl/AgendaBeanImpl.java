package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.AgendaBean;
import org.pasa.sispasaint.dao.impl.AgendaDAOImpl;
import org.pasa.sispasaint.model.intg.Agenda;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class AgendaBeanImpl implements AgendaBean{
    
    public AgendaBeanImpl(){
    }

    @Override
    public Agenda obter(Agenda a) {
        return new AgendaDAOImpl().obter(a.getId());
    }

    @Override
    public void cadastrar(Agenda a) {
       new AgendaDAOImpl().cadastrar(a);
    }

    @Override
    public void atualizar(Agenda a) {
       new AgendaDAOImpl().atualizar(a);
    }

    @Override
    public void apagar(Agenda a) {
        new AgendaDAOImpl().apagar(a);
    }

    @Override
    public List<Agenda> listar() {
        return new AgendaDAOImpl().listar();
    }

    @Override
    public Agenda existe(String codigo) {
       return new AgendaDAOImpl().existe(codigo);
    }
}
