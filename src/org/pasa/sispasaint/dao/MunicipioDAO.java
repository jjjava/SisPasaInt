package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Municipio;
/**
 *
 * @author Hudson Schumaker
 */
public interface MunicipioDAO {
    boolean cadastrar(Municipio m);
    boolean atualizar(Municipio m);
    void apagar(Municipio m);
    Municipio obter(Long id);
    List<Municipio> listar();
    Municipio existe(String nome);
}
