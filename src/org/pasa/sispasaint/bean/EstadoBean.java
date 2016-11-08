package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Estado;

/**
 *
 * @author Hudson Schumaker
 */
public interface EstadoBean {

    void cadastrar(Estado e);
    void atualizar(Estado e);
    void apagar(Estado e);
    Estado obter(Long id);
    Estado obter(String uf);
    List<Estado> listar();
    Estado existe(Estado e);
}
