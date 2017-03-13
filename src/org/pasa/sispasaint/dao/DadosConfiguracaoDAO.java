package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.config.DadosConfiguracao;

/**
 *
 * @author Hudson Schumaker
 */
public interface DadosConfiguracaoDAO {
    boolean cadastrar(DadosConfiguracao  dadosConfig);
    boolean atualizar(DadosConfiguracao  dadosConfig);
    void apagar(DadosConfiguracao  dadosConfig);
    DadosConfiguracao obter(Long id);
    DadosConfiguracao obterPorEmpresa(String id);
    List<DadosConfiguracao> listar();
}
