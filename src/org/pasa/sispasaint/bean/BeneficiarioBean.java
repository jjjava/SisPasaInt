package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.model.Beneficiario;

/**
 *
 * @author 90J00318
 */
public interface BeneficiarioBean {
    Beneficiario obter(Beneficiario b);
    Beneficiario obter(String empresa, String matricula, String codBeneficiario);
    void cadastar(Beneficiario b);
    void atualizar(Beneficiario b);
    void apagar(Beneficiario b);
}
