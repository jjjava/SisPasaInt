package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ImpBenPeopleBean {
    ModeloBenPeople obter(Long id);
    ModeloBenPeople obter(ModeloBenPeople modeloBenPeople);
    void copiarTabela();
    void limparTabela();
    void resetarIdentity();
    void carregarArquivo(Long id, Log log);
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople);
    Long contar();
    List<ModeloBenPeople> listarBeneficiarios(ModeloBenPeople modeloBenPeople);
    List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula);
    List<ModeloBenPeople> verificarInativos();
    void inativar(List<ModeloBenPeople> listaInativar);
}
