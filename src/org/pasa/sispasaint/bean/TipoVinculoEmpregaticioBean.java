package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface TipoVinculoEmpregaticioBean {
    void cadastrar(TipoVinculoEmpregaticio tve);
    void atualizar(TipoVinculoEmpregaticio tve);
    void apagar(TipoVinculoEmpregaticio tve);
    TipoVinculoEmpregaticio obter(Long id);
    TipoVinculoEmpregaticio obter(String cdExterno);
    List<TipoVinculoEmpregaticio> listar();
}
