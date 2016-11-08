package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasaint.bean.MunicipioBean;
import org.pasa.sispasaint.dao.impl.MunicipioDAOImpl;

/**
 *
 * @author Hudson Schumaker
 */
public class MunicipioBeanImpl implements MunicipioBean {

    public MunicipioBeanImpl() {
    }
    
    @Override
    public Municipio obter(Municipio  m) {
        return new MunicipioDAOImpl().obter(m.getId());
    }

    @Override
    public void cadastrar(Municipio m) {
        new MunicipioDAOImpl().cadastrar(m);
    }

    @Override
    public void atualizar(Municipio m) {
        new MunicipioDAOImpl().atualizar(m);
    }

    @Override
    public void apagar(Municipio m) {
        new MunicipioDAOImpl().apagar(m);
    }

    @Override
    public List<Municipio> listar() {
        return new MunicipioDAOImpl().listar();
    }

    @Override
    public Municipio existe(String nome) {
        return new MunicipioDAOImpl().existe(nome);
    }
}
