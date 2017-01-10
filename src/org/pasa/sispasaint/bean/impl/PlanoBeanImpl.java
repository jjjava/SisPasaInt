package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasaint.bean.PlanoBean;
import org.pasa.sispasaint.dao.impl.PlanoDAOImpl;


/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class PlanoBeanImpl implements PlanoBean {

    private final PlanoDAOImpl planoDAO;
    
    public PlanoBeanImpl() {
        this.planoDAO = new PlanoDAOImpl();
    }

    @Override
    public Plano obter(Plano p) {
        return planoDAO.obter(p.getId());
    }

    @Override
    public void cadastrar(Plano p) {
        planoDAO.cadastrar(p);
    }

    @Override
    public void atualizar(Plano p) {
        planoDAO.atualizar(p);
    }

    @Override
    public void apagar(Plano p) {
        planoDAO.apagar(p);
    }

    @Override
    public List<Plano> listar() {
        return planoDAO.listar();
    }

    @Override
    public Plano existe(String codigo) {
        return planoDAO.existe(codigo);
    }
}
