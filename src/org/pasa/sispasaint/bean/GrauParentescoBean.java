package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.GrauParentesco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface GrauParentescoBean {
    GrauParentesco obter(GrauParentesco g);
    void cadastrar(GrauParentesco g);
    void atualizar(GrauParentesco g);
    void apagar(GrauParentesco g);
    List<GrauParentesco> listar();
    GrauParentesco existe(String codigo);
}
