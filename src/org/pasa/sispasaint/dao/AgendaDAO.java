package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Agenda;

/**
 *
 * @author Hudson Schumaker
 */
public interface AgendaDAO {
    Agenda obter(Long id);
    boolean cadastrar(Agenda a);
    boolean atualizar(Agenda a);
    void apagar(Agenda a);
    List<Agenda> listar();
    Agenda existe(String codigo);
}
