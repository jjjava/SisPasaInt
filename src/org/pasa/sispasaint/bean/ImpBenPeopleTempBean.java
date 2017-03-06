package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.model.intg.ModeloBenPeopleTemp;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ImpBenPeopleTempBean {
    ModeloBenPeopleTemp obter(Long id);
    void limparTabela(String nomeArquivo);
    void resetarIdentity();
    Long contar();
}
