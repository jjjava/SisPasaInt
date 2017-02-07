package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.bean.MunicipioBean;
import org.pasa.sispasaint.dao.impl.MunicipioDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class MunicipioBeanImpl implements MunicipioBean {

    private final MunicipioDAOImpl municipioDAO;
    
    public MunicipioBeanImpl() {
        this.municipioDAO = new MunicipioDAOImpl();
    }
    
    @Override
    public Municipio obter(Municipio  m) {
        return municipioDAO.obter(m.getId());
    }

    @Override
    public void cadastrar(Municipio m) {
        municipioDAO.cadastrar(m);
    }

    @Override
    public void atualizar(Municipio m) {
        municipioDAO.atualizar(m);
    }

    @Override
    public void apagar(Municipio m) {
        municipioDAO.apagar(m);
    }

    @Override
    public List<Municipio> listar() {
        return municipioDAO.listar();
    }

    @Override
    public Municipio existe(String nome) {
        return municipioDAO.existe(nome.trim());
    }
}
