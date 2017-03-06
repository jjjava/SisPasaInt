package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenPeopleDAO {
    ModeloBenPeople obter(Long id);
    boolean cadastrar(ModeloBenPeople modelo);
    Long contar();
    void limpaTB();
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI);
    List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula);
    void copiarTabela();
    List<ModeloBenPeople> verificarInativos();
}