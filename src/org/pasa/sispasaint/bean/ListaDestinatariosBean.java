package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ListaDestinatariosBean {
    
    ListaDestinatarios obter(Long id);
    void cadastrar(ListaDestinatarios ld);
    void atualizar(ListaDestinatarios ld);
    void apagar(ListaDestinatarios ld);
    List<ListaDestinatarios> listar();
    List<ListaDestinatarios> listar(Long id);
}
