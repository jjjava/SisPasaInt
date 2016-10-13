package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.GrauParentesco;

/**
 *
 * @author 90J00318
 */
public interface GrauParentescoDAO {
    GrauParentesco obter(Long id);
    void cadastrar(GrauParentesco g);
    void atualizar(GrauParentesco g);
    void apagar(GrauParentesco g);
    List<GrauParentesco> listar();
    GrauParentesco existe(String codigo);
}
