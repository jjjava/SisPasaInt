package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */

public interface EnderecoDAO {
    void cadastrar(Endereco e);
    void atualizar(Endereco e);
    void apagar(Endereco e);
    Endereco obter(Long id);
    List<Endereco> listar();
}
