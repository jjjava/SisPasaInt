package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Municipio;

/**
 *
 * @author Hudson Schumaker
 */

public interface MunicipioDAO {

    void cadastrar(Municipio m);
    void atualizar(Municipio m);
    void apagar(Municipio m);
    Municipio obter(Long id);
    List<Municipio> listar();
    Municipio existe(Municipio m);
}
