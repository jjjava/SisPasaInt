package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Agenda;

/**
 *
 * @author Hudson Schumaker
 */
public interface AgendaBean {
    Agenda obter(Agenda a);
    void cadastrar(Agenda a);
    void atualizar(Agenda a);
    void apagar(Agenda a);
    List<Agenda> listar();
    Agenda existe(String codigo);
}
