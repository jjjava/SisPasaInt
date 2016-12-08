
package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Pais;

/**
 *
 * @author 90J00318
 */
public interface PaisBean {
    void cadastrar(Pais p);
    void atualizar(Pais p);
    void apagar(Pais p);
    Pais obter(Long id);
    List<Pais> listar();
    Pais existe(Pais p);
}
