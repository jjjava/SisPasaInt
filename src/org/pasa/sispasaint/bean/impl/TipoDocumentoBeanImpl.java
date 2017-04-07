package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasaint.bean.TipoDocumentoBean;
import org.pasa.sispasaint.dao.impl.TipoDocumentoDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class TipoDocumentoBeanImpl implements TipoDocumentoBean {

    private final TipoDocumentoDAOImpl tipoDocumentoDAO;

    public TipoDocumentoBeanImpl() {
        tipoDocumentoDAO = new TipoDocumentoDAOImpl();
    }

    @Override
    public TipoDocumento obter(Long id) {
        return tipoDocumentoDAO.obter(id);
    }

    @Override
    public boolean cadastrar(TipoDocumento td) {
        return tipoDocumentoDAO.cadastrar(td);
    }

    @Override
    public boolean atualizar(TipoDocumento td) {
        return true;
    }

    @Override
    public void apagar(TipoDocumento td) {
        tipoDocumentoDAO.apagar(td);
    }

    @Override
    public List<TipoDocumento> listar() {
        return tipoDocumentoDAO.listar();
    }
}
