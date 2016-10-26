
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Beneficiario;

/**
 *
 * @author 90J00318
 */
public interface BeneficiarioDAO {
    void cadastrar(Beneficiario b);
    void atualizar(Beneficiario b);
    void apagar(Beneficiario b);
    Beneficiario obter(Long id);
    Beneficiario obter(String empresa, String matricula, String codBeneficiario);
    List<Beneficiario> listar();
}
