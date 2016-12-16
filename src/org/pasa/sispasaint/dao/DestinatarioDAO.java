package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Destinatario;

/**
 *
 * @author 90J00318
 */
public interface DestinatarioDAO {
    Destinatario obter(Long id);
    boolean cadastrar(Destinatario d);
    void atualizar(Destinatario d);
    void apagar(Destinatario d);
    List<Destinatario> listar();
}
