package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.GrauParentesco;

/**
 *
 * @author 90J00318
 */
public interface GrauParentescoBean {
    GrauParentesco obter(GrauParentesco g);
    void cadastrar(GrauParentesco g);
    void atualizar(GrauParentesco g);
    void apagar(GrauParentesco g);
    List<GrauParentesco> listar();
    GrauParentesco existe(String codigo);
}
