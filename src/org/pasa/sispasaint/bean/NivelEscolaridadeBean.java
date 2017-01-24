package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.NivelEscolaridade;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface NivelEscolaridadeBean {
    void cadastrar(NivelEscolaridade ne);
    void atualizar(NivelEscolaridade ne);
    void apagar(NivelEscolaridade ne);
    NivelEscolaridade obter(Long id);
    NivelEscolaridade obter(String codExterno);
    List<NivelEscolaridade> listar();
}
