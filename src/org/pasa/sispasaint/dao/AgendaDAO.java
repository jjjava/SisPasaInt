package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Agenda;

/**
 *
 * @author 90J00318
 */
public interface AgendaDAO {
    Agenda obter(Long id);
    void cadastrar(Agenda a);
    void atualizar(Agenda a);
    void apagar(Agenda a);
    List<Agenda> listar();
    Agenda existe(String codigo);
}
