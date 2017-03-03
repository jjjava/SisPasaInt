package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.GrauParentesco;
import org.pasa.sispasaint.bean.GrauParentescoBean;
import org.pasa.sispasaint.dao.impl.GrauParentescoDAOImpl;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class GrauParentescoBeanImpl implements GrauParentescoBean {

    private final GrauParentescoDAOImpl grauParentescoDAO;
    
    public GrauParentescoBeanImpl() {
        this.grauParentescoDAO = new GrauParentescoDAOImpl();
    }

    @Override
    public GrauParentesco obter(GrauParentesco g) {
        return grauParentescoDAO.obter(g.getId());
    }

    @Override
    public void cadastrar(GrauParentesco g) {
        grauParentescoDAO.cadastrar(g);
    }

    @Override
    public void atualizar(GrauParentesco g) {
        grauParentescoDAO.atualizar(g);
    }

    @Override
    public void apagar(GrauParentesco g) {
        grauParentescoDAO.apagar(g);
    }

    @Override
    public List<GrauParentesco> listar() {
        return grauParentescoDAO.listar();
    }

    @Override
    public GrauParentesco existe(String codigo) {
       return grauParentescoDAO.existe(codigo);
    }
}
