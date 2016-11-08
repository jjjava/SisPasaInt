package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasaint.bean.EstadoBean;
import org.pasa.sispasaint.dao.impl.EstadoDAOImpl;
/**
 *
 * @author Hudson Schumaker
 */
public class EstadoBeanImpl implements EstadoBean {

    public EstadoBeanImpl() {
    }

    @Override
    public void cadastrar(Estado e) {
        new EstadoDAOImpl().cadastrar(e);
    }

    @Override
    public void atualizar(Estado e) {
        new EstadoDAOImpl().atualizar(e);
    }

    @Override
    public void apagar(Estado e) {
        new EstadoDAOImpl().apagar(e);
    }

    @Override
    public Estado obter(Long id) {
        return new EstadoDAOImpl().obter(id);
    }

    @Override
    public Estado obter(String uf) {
        return new EstadoDAOImpl().obter(uf);
    }

    @Override
    public List<Estado> listar() {
        return new EstadoDAOImpl().listar();
    }

    @Override
    public Estado existe(Estado e) {
        return new EstadoDAOImpl().existe(e);
    }
}
