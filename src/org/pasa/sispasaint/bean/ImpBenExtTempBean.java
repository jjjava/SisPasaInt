package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenExt;


/**
 *
 * @author Hudson Schumaker
 */

public interface ImpBenExtTempBean {
    ModeloBenExt obter(Long id);
    ModeloBenExt obter(ModeloBenExt modelo);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo();
    void salvarTbTemp(List<ModeloBenExt> listaModeloBenExt);
    Long contar();
}