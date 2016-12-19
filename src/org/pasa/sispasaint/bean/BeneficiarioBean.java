package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Beneficiario;

/**
 *
 * @author Hudson Schumaker
 */
public interface BeneficiarioBean {
    Beneficiario obter(Beneficiario b);
    Beneficiario obter(String empresa, String matricula, String codBeneficiario);
    void cadastar(Beneficiario b);
    void atualizar(Beneficiario b);
    void apagar(Beneficiario b);
    List<Beneficiario> listar();
    List<Beneficiario> listar(String empresa, String matricula);
    Integer atulizaStatus(String empresa);
}
