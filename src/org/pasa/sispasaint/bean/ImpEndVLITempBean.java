package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpEndVLITempBean {

    ModeloEndVLI obter(ModeloEndVLI modeloEndVli);
    ModeloEndVLI obterPorMatricula(ModeloBenVLI modeloBenVli);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo();
    void salvarTbTemp(List<ModeloEndVLI> listaModeloEndVLI);
    Long contar();
}
