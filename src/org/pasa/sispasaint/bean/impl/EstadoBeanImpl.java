package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasaint.bean.EstadoBean;
import org.pasa.sispasaint.dao.impl.EstadoDAOImpl;
/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class EstadoBeanImpl implements EstadoBean {

    private final EstadoDAOImpl estadoDAO;
    
    public EstadoBeanImpl() {
        this.estadoDAO = new EstadoDAOImpl();
    }

    @Override
    public void cadastrar(Estado e) {
        estadoDAO.cadastrar(e);
    }

    @Override
    public void atualizar(Estado e) {
        estadoDAO.atualizar(e);
    }

    @Override
    public void apagar(Estado e) {
        estadoDAO.apagar(e);
    }

    @Override
    public Estado obter(Long id) {
        return estadoDAO.obter(id);
    }

    @Override
    public Estado obter(String uf) {
        return estadoDAO.obter(uf);
    }

    @Override
    public List<Estado> listar() {
        return estadoDAO.listar();
    }

    @Override
    public Estado existe(Estado e) {
        return estadoDAO.existe(e);
    }
}
