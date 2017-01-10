package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ListaDestinatariosDAO;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ListaDestinatariosDAOImpl extends DaoGenerico<ListaDestinatarios> implements ListaDestinatariosDAO {

    public ListaDestinatariosDAOImpl() {
        super(ListaDestinatarios.class);
    }

    @Override
    public List<ListaDestinatarios> listar(Long id) {
        Query q1 = getEntityManager().
        createQuery("select l from ListaDestinatarios l where l.idLista = :idLista");
        q1.setParameter("idLista", id);
        List<ListaDestinatarios> listaDestinatarios = null;
        try {
            listaDestinatarios = q1.getResultList();
        } catch (NoResultException e) {
            System.err.println("Listadestina "+e);
            return null;
        }
        return listaDestinatarios;
    }
}
