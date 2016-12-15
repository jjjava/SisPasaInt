package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface EnderecoBean {
    void cadastrar(Endereco e);
    void atualizar(Endereco e);
    void apagar(Endereco e);
    Endereco obter(Long id);
    List<Endereco> listar();
}
