package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.config.DadosConfiguracao;

/**
 *
 * @author Hudson Schumaker
 */
public interface DadosConfigDAO {
    boolean cadastrar(DadosConfiguracao  dadosConfig);
    boolean atualizar(DadosConfiguracao  dadosConfig);
    void apagar(DadosConfiguracao  dadosConfig);
    DadosConfiguracao obter(Long id);
    DadosConfiguracao obterPorEmpresa(Long id);
    List<DadosConfiguracao> listar();
}
