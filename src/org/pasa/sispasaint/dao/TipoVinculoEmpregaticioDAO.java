package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface TipoVinculoEmpregaticioDAO  {
    boolean cadastrar(TipoVinculoEmpregaticio tve);
    boolean atualizar(TipoVinculoEmpregaticio tve);
    void apagar(TipoVinculoEmpregaticio tve);
    TipoVinculoEmpregaticio obter(Long id);
    TipoVinculoEmpregaticio obter(String cdExterno);
    List<TipoVinculoEmpregaticio> listar();
    TipoVinculoEmpregaticio existe(TipoVinculoEmpregaticio tve);
}
