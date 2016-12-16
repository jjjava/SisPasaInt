package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Beneficiario;
/**
 *
 * @author 90J00318
 */
public interface BeneficiarioDAO {
    boolean cadastrar(Beneficiario b);
    void atualizar(Beneficiario b);
    void apagar(Beneficiario b);
    Beneficiario obter(Long id);
    Beneficiario obter(String matricula, String codBeneficiario);
    List<Beneficiario> listar();
    List<Beneficiario> listar(String empresa, String matricula);
}
