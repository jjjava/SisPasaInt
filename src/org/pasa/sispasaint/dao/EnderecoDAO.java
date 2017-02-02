package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */
public interface EnderecoDAO {
    boolean cadastrar(Endereco e);
    boolean atualizar(Endereco e);
    void apagar(Endereco e);
    Endereco obter(Long id);
    List<Endereco> listar();
}
