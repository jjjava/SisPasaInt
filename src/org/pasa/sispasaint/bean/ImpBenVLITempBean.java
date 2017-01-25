package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpBenVLITempBean {
    ModeloBenPeople obter(Long id);
    ModeloBenPeople obter(ModeloBenPeople modeloBenVli);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id);
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI);
    Long contar();
    public List<ModeloBenPeople> listar(String empresa, String matricula);
}
