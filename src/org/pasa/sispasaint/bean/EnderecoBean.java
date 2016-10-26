package org.pasa.sispasaint.bean;


import java.util.List;
import org.pasa.sispasaint.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */

public interface EnderecoBean {
    void cadastrar(Endereco e);
    void atualizar(Endereco e);
    void apagar(Endereco e);
    Endereco obter(Long id);
    List<Endereco> listar();
}
