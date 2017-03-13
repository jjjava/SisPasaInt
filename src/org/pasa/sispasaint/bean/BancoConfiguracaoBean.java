package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.config.BancoConfiguracao;

public interface BancoConfiguracaoBean {

		BancoConfiguracao obter(Long id);
		boolean cadastrar(BancoConfiguracao bc);
		boolean atualizar(BancoConfiguracao bc);
		void apagar(BancoConfiguracao bc);
}
