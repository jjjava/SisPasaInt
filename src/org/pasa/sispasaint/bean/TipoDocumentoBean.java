package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.TipoDocumento;

/**
 *
 * @author Hudson Schuamker
 * @version 1.0.0
 */
public interface TipoDocumentoBean {
    TipoDocumento obter(Long id);
    boolean cadastrar(TipoDocumento td);
    boolean atualizar(TipoDocumento td);
    void apagar(TipoDocumento td);
    List<TipoDocumento> listar();
}
