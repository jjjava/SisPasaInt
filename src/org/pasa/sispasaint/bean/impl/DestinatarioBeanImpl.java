package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.DestinatarioBean;
import org.pasa.sispasaint.model.intg.Destinatario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DestinatarioBeanImpl implements DestinatarioBean {

    public DestinatarioBeanImpl() {
    }

    @Override
    public Destinatario obter(Long id) {
        return new DestinatarioBeanImpl().obter(id);
    }

    @Override
    public void cadastrar(Destinatario d) {
        new DestinatarioBeanImpl().cadastrar(d);
    }

    @Override
    public void atualizar(Destinatario d) {
        new DestinatarioBeanImpl().atualizar(d);
    }

    @Override
    public void apagar(Destinatario d) {
        new DestinatarioBeanImpl().apagar(d);
    }

    @Override
    public List<Destinatario> listar() {
        return new DestinatarioBeanImpl().listar();
    }
}
