package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.intg.ModeloBenExt;
import org.pasa.sispasaint.model.intg.ModeloEndExt;

/**
 *
 * @author Hudson Schumaker
 */
public interface ImpEndExtTempBean {

    ModeloEndExt obter(ModeloEndExt modeloEndExt);
    ModeloEndExt obterPorMatricula(ModeloBenExt modeloBenExt);
    void limparTbTemp();
    void resetarIdentity();
    void carregarArquivo(Long id);
    void salvarTbTemp(List<ModeloEndExt> listaModeloEndExt);
    Long contar();
}
