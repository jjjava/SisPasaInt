package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpEndPeopleTempBean {

    ModeloEndPeople obter(ModeloEndPeople modeloEndPeople);
    ModeloEndPeople obterPorMatricula(ModeloEndPeople modeloBenPeolpe);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo();
    void salvarTbTemp(List<ModeloEndPeople> listaModeloEndPeolpe);
    Long contar();
}
