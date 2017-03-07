package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Destinatario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface DestinatarioBean {
    Destinatario obter(Long id);
    void cadastrar(Destinatario d);
    void atualizar(Destinatario d);
    void apagar(Destinatario d);
    List<Destinatario> listar();
}
