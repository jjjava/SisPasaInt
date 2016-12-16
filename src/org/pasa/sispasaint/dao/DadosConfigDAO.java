package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.config.DadosConfig;

/**
 *
 * @author Hudson Schumaker
 */

public interface DadosConfigDAO {
    boolean cadastrar(DadosConfig  dadosConfig);
    void atualizar(DadosConfig  dadosConfig);
    void apagar(DadosConfig  dadosConfig);
    DadosConfig obter(Long id);
    DadosConfig obterPorEmpresa(Long id);
    List<DadosConfig> listar();
}
