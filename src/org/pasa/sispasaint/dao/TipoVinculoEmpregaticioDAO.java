package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;

/**
 *
 * @author 90J00318
 */
public interface TipoVinculoEmpregaticioDAO  {
    void cadastrar(TipoVinculoEmpregaticio tve);
    void atualizar(TipoVinculoEmpregaticio tve);
    void apagar(TipoVinculoEmpregaticio tve);
    TipoVinculoEmpregaticio obter(Long id);
    TipoVinculoEmpregaticio obter(String cdExterno);
    List<TipoVinculoEmpregaticio> listar();
    TipoVinculoEmpregaticio existe(TipoVinculoEmpregaticio tve);
}
