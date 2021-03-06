
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Plano;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface PlanoDAO {
    Plano obter(Long id);
    boolean cadastrar(Plano p);
    boolean atualizar(Plano p);
    void apagar(Plano p);
    List<Plano> listar();
    Plano existe(String codPlano, String codEmpresa);
}
