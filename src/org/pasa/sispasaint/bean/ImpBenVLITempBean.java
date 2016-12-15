package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpBenVLITempBean {
    ModeloBenVLI obter(Long id);
    ModeloBenVLI obter(ModeloBenVLI modeloBenVli);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id);
    void salvarTbTemp(List<ModeloBenVLI> listaModeloBenVLI);
    Long contar();
    public List<ModeloBenVLI> listar(String empresa, String matricula);
}
