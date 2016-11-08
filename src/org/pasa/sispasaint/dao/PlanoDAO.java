
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Plano;
/**
 *
 * @author 90J00318
 */
public interface PlanoDAO {
    Plano obter(Long id);
    void cadastrar(Plano p);
    void atualizar(Plano p);
    void apagar(Plano p);
    List<Plano> listar();
    Plano existe(String codigo);
}
