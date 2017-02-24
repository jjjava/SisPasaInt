package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.TipoDocumento;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface TipoDocumentoDAO {
    TipoDocumento obter(Long id);
    boolean cadastrar(TipoDocumento td);
    boolean atualizar(TipoDocumento td);
    void apagar(TipoDocumento td);
    List<TipoDocumento> listar();
}
