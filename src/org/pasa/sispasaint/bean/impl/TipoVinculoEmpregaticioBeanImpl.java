package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.TipoVinculoEmpregaticioBean;
import org.pasa.sispasaint.dao.impl.TipoVinculoEmpregaticioDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class TipoVinculoEmpregaticioBeanImpl implements TipoVinculoEmpregaticioBean {

    private final TipoVinculoEmpregaticioDAOImpl tipoVinculoEmpregaticioDAO;

    public TipoVinculoEmpregaticioBeanImpl() {
        this.tipoVinculoEmpregaticioDAO = new TipoVinculoEmpregaticioDAOImpl();
    }

    @Override
    public void cadastrar(TipoVinculoEmpregaticio tve) {
        tipoVinculoEmpregaticioDAO.cadastrar(tve);
    }

    @Override
    public void atualizar(TipoVinculoEmpregaticio tve) {
        tipoVinculoEmpregaticioDAO.atualizar(tve);
    }

    @Override
    public void apagar(TipoVinculoEmpregaticio tve) {
        tipoVinculoEmpregaticioDAO.apagar(tve);
    }

    @Override
    public TipoVinculoEmpregaticio obter(Long id) {
        return tipoVinculoEmpregaticioDAO.obter(id);
    }

    @Override
    public TipoVinculoEmpregaticio obter(String cdExterno) {
        return tipoVinculoEmpregaticioDAO.obter(cdExterno);
    }

    @Override
    public List<TipoVinculoEmpregaticio> listar() {
        return tipoVinculoEmpregaticioDAO.listar();
    }
}
