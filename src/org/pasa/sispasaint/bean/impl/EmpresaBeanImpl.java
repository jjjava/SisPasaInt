
package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.EmpresaBean;
import org.pasa.sispasaint.dao.impl.EmpresaDAOImpl;
import org.pasa.sispasaint.model.Empresa;

/**
 *
 * @author 90J00318
 */
public class EmpresaBeanImpl implements EmpresaBean{
    
    public EmpresaBeanImpl(){
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
    public Empresa existe(Empresa e) {
        return new EmpresaDAOImpl().existe(e);
    }
}
