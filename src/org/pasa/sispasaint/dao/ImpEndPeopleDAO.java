package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

public interface ImpEndPeopleDAO {
    ModeloEndPeople obter(Long id);
    ModeloEndPeople obterPorMatricula(String empresa, String matricula, String codBeneficiario);
    List<ModeloEndPeople> list(String empresa, String matricula);
    void resetarIdentity(); 
    void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI);
    void copiarTabela();
}