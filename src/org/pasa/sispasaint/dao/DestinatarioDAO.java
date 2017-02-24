package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.Destinatario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface DestinatarioDAO {
    Destinatario obter(Long id);
    boolean cadastrar(Destinatario d);
    boolean atualizar(Destinatario d);
    void apagar(Destinatario d);
    List<Destinatario> listar();
}
