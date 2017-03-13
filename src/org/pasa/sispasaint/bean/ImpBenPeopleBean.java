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
    Long contar();
    void copiarTabela();
    void limparTabela();
    void resetarIdentity();
    void carregarArquivo(String cdVale, Log log);
    void inativar(List<ModeloBenPeople> listaInativar);
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenPeople);
    List<ModeloBenPeople> verificarInativos();
    List<ModeloBenPeople> listarBeneficiarios(ModeloBenPeople modeloBenPeople);
    List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula);
}
