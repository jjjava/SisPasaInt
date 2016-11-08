package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasaint.bean.TelefoneBean;
import org.pasa.sispasaint.dao.impl.TelefoneDAOImpl;

/**
 *
 * @author Hudson Schumaker
 */
public class TelefoneBeanImpl implements TelefoneBean {

    public TelefoneBeanImpl() {
    }

    @Override
    public void cadastrar(Telefone t) {
        new TelefoneDAOImpl().cadastrar(t);
    }

    @Override
    public void atualizar(Telefone t) {
        new TelefoneDAOImpl().atualizar(t);
    }

    @Override
    public void apagar(Telefone t) {
        new TelefoneDAOImpl().apagar(t);
    }

    @Override
    public Telefone obter(Telefone t) {
        return new TelefoneDAOImpl().obter(t.getId());
    }

    @Override
    public List<Telefone> listar() {
        return new TelefoneDAOImpl().listar();
    }
}
