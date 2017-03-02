package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Plano;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface PlanoBean {
    Plano obter(Plano p);
    void cadastrar(Plano p);
    void atualizar(Plano p);
    void apagar(Plano p);
    List<Plano> listar();
    Plano existe(String codPlano, String codEmpresa);
}
