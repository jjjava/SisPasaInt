package org.pasa.sispasaint.dao;

import org.pasa.sispasaint.config.BancoConfiguracao;

public interface BancoConfiguracaoDAO {

    BancoConfiguracao obter(Long id);
    boolean cadastrar(BancoConfiguracao bc);
    boolean atualizar(BancoConfiguracao bc);
    void apagar(BancoConfiguracao bc);
}
