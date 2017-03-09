package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Beneficiario;

/**
 *
 * @author Hudson Schumaker
 */
public interface BeneficiarioDAO {
    boolean cadastrar(Beneficiario b);
    boolean atualizar(Beneficiario b);
    void apagar(Beneficiario b);
    Beneficiario obter(Long id);
    Beneficiario obter(String matricula, String codBeneficiario);
    List<Beneficiario> listar();
    List<Beneficiario> listar(String empresa, String matricula);
    Integer atulizaStatus(String empresa);
    Long getInativos(String empresa);
}
