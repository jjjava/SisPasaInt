package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpEndVLITempDAO {
    ModeloEndVLI obter(Long id);
    ModeloEndVLI obterPorMatricula(String empresa, String matricula, String codBeneficiario);
    List<ModeloEndVLI> list(String empresa, String matricula);
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloEndVLI> listaModeloEndVLI);
}