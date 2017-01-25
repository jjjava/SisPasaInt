package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpEndVLITempBean {

    ModeloEndPeople obter(ModeloEndPeople modeloEndVli);
    ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id);
    void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI);
    List<ModeloEndPeople> list(String empresa, String matricula);
    Long contar();
}
