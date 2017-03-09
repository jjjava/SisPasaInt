package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author Hudson Schumaker
 */
public interface ListaDestinatariosDAO {
    ListaDestinatarios obter(Long id);
    boolean cadastrar(ListaDestinatarios ld);
    boolean atualizar(ListaDestinatarios ld);
    void apagar(ListaDestinatarios ld);
    List<ListaDestinatarios> listar();
    List<ListaDestinatarios> listar(Long id);
}
