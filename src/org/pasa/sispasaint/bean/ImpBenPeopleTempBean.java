package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;


/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenPeopleTempBean {
    ModeloBenPeople obter(Long id);
    ModeloBenPeople obter(ModeloBenPeople modelo);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id);
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople);
    Long contar();
}
