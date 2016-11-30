package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author 90J00318
 */
public interface ListaDestinatariosDAO {
    ListaDestinatarios obter(Long id);
    void cadastrar(ListaDestinatarios ld);
    void atualizar(ListaDestinatarios ld);
    void apagar(ListaDestinatarios ld);
    List<ListaDestinatarios> listar();
}
