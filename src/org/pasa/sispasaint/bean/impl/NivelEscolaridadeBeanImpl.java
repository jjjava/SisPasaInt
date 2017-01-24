package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasaint.bean.NivelEscolaridadeBean;
import org.pasa.sispasaint.dao.impl.NivelEscolaridadeDaoImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class NivelEscolaridadeBeanImpl implements NivelEscolaridadeBean{

    private final NivelEscolaridadeDaoImpl nivelEscolaridadeDao;
    
    public NivelEscolaridadeBeanImpl(){
        nivelEscolaridadeDao = new NivelEscolaridadeDaoImpl();
    }
    
    @Override
    public void cadastrar(NivelEscolaridade ne) {
        nivelEscolaridadeDao.cadastrar(ne);
    }

    @Override
    public void atualizar(NivelEscolaridade ne) {
        nivelEscolaridadeDao.cadastrar(ne);
    }

    @Override
    public void apagar(NivelEscolaridade ne) {
        nivelEscolaridadeDao.apagar(ne);
    }

    @Override
    public NivelEscolaridade obter(Long id) {
        return nivelEscolaridadeDao.obter(id);
    }

    @Override
    public NivelEscolaridade obter(String codExterno) {
        return nivelEscolaridadeDao.obter(codExterno);
    }

    @Override
    public List<NivelEscolaridade> listar() {
        return nivelEscolaridadeDao.listar();
    }
}
