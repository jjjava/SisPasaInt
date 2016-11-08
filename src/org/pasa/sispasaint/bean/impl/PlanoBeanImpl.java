package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasaint.bean.PlanoBean;
import org.pasa.sispasaint.dao.impl.PlanoDAOImpl;


/**
 *
 * @author 90J00318
 */
public class PlanoBeanImpl implements PlanoBean {

    public PlanoBeanImpl() {
    }

    @Override
    public Plano obter(Plano p) {
        return new PlanoDAOImpl().obter(p.getId());
    }

    @Override
    public void cadastrar(Plano p) {
        new PlanoDAOImpl().cadastrar(p);
    }

    @Override
    public void atualizar(Plano p) {
        new PlanoDAOImpl().atualizar(p);
    }

    @Override
    public void apagar(Plano p) {
        new PlanoDAOImpl().apagar(p);
    }

    @Override
    public List<Plano> listar() {
        return new PlanoDAOImpl().listar();
    }

    @Override
    public Plano existe(String codigo) {
        return new PlanoDAOImpl().existe(codigo);
    }
}
