package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Telefone;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface TelefoneBean {
    void cadastrar(Telefone t);
    void atualizar(Telefone t);
    void apagar(Telefone t);
    Telefone obter(Telefone t);
    List<Telefone> listar();
}
