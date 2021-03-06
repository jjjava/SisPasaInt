package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.GrauParentesco;

/**
 *
 * @author Hudson Schumaker
 */
public interface GrauParentescoDAO {
    GrauParentesco obter(Long id);
    boolean cadastrar(GrauParentesco g);
    boolean atualizar(GrauParentesco g);
    void apagar(GrauParentesco g);
    List<GrauParentesco> listar();
    GrauParentesco existe(String codigo);
}
