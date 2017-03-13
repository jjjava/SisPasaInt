package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.ListaDestinatariosBean;
import org.pasa.sispasaint.dao.impl.ListaDestinatariosDAOImpl;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ListaDestinatariosBeanImpl implements ListaDestinatariosBean {

    public ListaDestinatariosBeanImpl(){
    }
    
    @Override
    public ListaDestinatarios obter(Long id) {
        return new ListaDestinatariosDAOImpl().obter(id);
    }

    @Override
    public void cadastrar(ListaDestinatarios ld) {
        new ListaDestinatariosDAOImpl().cadastrar(ld);
    }

    @Override
    public void atualizar(ListaDestinatarios ld) {
        new ListaDestinatariosDAOImpl().atualizar(ld);
    }

    @Override
    public void apagar(ListaDestinatarios ld) {
        new ListaDestinatariosDAOImpl().apagar(ld);
    }

    @Override
    public List<ListaDestinatarios> listar() {
        return new ListaDestinatariosDAOImpl().listar();
    }

    @Override
    public List<ListaDestinatarios> listar(Long id) {
        return new ListaDestinatariosDAOImpl().listar(id);
    }
}
