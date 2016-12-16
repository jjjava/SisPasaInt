package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasaint.bean.EmpresaBean;
import org.pasa.sispasaint.dao.impl.EmpresaDAOImpl;

/**
 *
 * @author 90J00318
 */
public class EmpresaBeanImpl implements EmpresaBean{
    
    public EmpresaBeanImpl(){
    }

    @Override
    public Empresa obter(Long id) {
        return new EmpresaDAOImpl().obter(id);
    }
    
    @Override
    public Empresa obter(Empresa e) {
        return new EmpresaDAOImpl().obter(e.getId());
    }

    @Override
    public void cadastrar(Empresa e) {
       new EmpresaDAOImpl().cadastrar(e);
    }

    @Override
    public void atualizar(Empresa e) {
        new EmpresaDAOImpl().atualizar(e);
    }

    @Override
    public void apagar(Empresa e) {
        new EmpresaDAOImpl().apagar(e);
    }

    @Override
    public List<Empresa> listar() {
        return new EmpresaDAOImpl().listar();
    }

    @Override
    public Empresa existe(String codigo) {
        return new EmpresaDAOImpl().existe(codigo);
    }
}
