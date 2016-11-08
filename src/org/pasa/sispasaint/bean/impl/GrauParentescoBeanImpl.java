package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.GrauParentesco;
import org.pasa.sispasaint.bean.GrauParentescoBean;
import org.pasa.sispasaint.dao.impl.GrauParentescoDAOImpl;


/**
 *
 * @author 90J00318
 */
public class GrauParentescoBeanImpl implements GrauParentescoBean {

    public GrauParentescoBeanImpl() {
    }

    @Override
    public GrauParentesco obter(GrauParentesco g) {
        return new GrauParentescoDAOImpl().obter(g.getId());
    }

    @Override
    public void cadastrar(GrauParentesco g) {
        new GrauParentescoDAOImpl().cadastrar(g);
    }

    @Override
    public void atualizar(GrauParentesco g) {
        new GrauParentescoDAOImpl().atualizar(g);
    }

    @Override
    public void apagar(GrauParentesco g) {
        new GrauParentescoDAOImpl().apagar(g);
    }

    @Override
    public List<GrauParentesco> listar() {
        return new GrauParentescoDAOImpl().listar();
    }

    @Override
    public GrauParentesco existe(String codigo) {
       return new GrauParentescoDAOImpl().existe(codigo);
    }
}