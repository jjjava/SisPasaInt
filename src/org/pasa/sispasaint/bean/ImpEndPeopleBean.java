package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ImpEndPeopleBean {

    ModeloEndPeople obter(ModeloEndPeople modeloEndVli);
    ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli);
    void copiarTabela();
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id, Log log);
    void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI);
    List<ModeloEndPeople> list(String empresa, String matricula);
    Long contar();
}
