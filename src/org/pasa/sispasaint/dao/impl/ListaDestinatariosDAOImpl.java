package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ListaDestinatariosDAO;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author 90J00318
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
        q1.setMaxResults(1);
        List<ListaDestinatarios> listaDestinatarios = null;
        try {
            listaDestinatarios = q1.getResultList();
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        }
        return listaDestinatarios;
    }
}