package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasaint.bean.TelefoneBean;
import org.pasa.sispasaint.dao.impl.TelefoneDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class TelefoneBeanImpl implements TelefoneBean {

    private final TelefoneDAOImpl telefoneDAO;
    
    public TelefoneBeanImpl() {
        this.telefoneDAO = new TelefoneDAOImpl();
    }

    @Override
    public void cadastrar(Telefone t) {
        telefoneDAO.cadastrar(t);
    }

    @Override
    public void atualizar(Telefone t) {
        telefoneDAO.atualizar(t);
    }

    @Override
    public void apagar(Telefone t) {
        telefoneDAO.apagar(t);
    }

    @Override
    public Telefone obter(Telefone t) {
        return telefoneDAO.obter(t.getId());
    }

    @Override
    public List<Telefone> listar() {
        return telefoneDAO.listar();
    }
}
