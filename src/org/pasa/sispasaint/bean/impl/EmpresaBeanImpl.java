package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasaint.bean.EmpresaBean;
import org.pasa.sispasaint.dao.impl.EmpresaDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class EmpresaBeanImpl implements EmpresaBean {

    private final EmpresaDAOImpl empresaDAO;

    public EmpresaBeanImpl() {
        this.empresaDAO = new EmpresaDAOImpl();
    }

    @Override
    public Empresa obter(Long id) {
        return empresaDAO.obter(id);
    }

    @Override
    public Empresa obter(Empresa e) {
        return empresaDAO.obter(e.getId());
    }

    @Override
    public Empresa obter(String cdVale) {
        return empresaDAO.existe(cdVale);
    }

    @Override
    public void cadastrar(Empresa e) {
        empresaDAO.cadastrar(e);
    }

    @Override
    public void atualizar(Empresa e) {
        empresaDAO.atualizar(e);
    }

    @Override
    public void apagar(Empresa e) {
        empresaDAO.apagar(e);
    }

    @Override
    public List<Empresa> listar() {
        return empresaDAO.listar();
    }

    @Override
    public Empresa existe(String codigo) {
        return empresaDAO.existe(codigo);
    }
}
