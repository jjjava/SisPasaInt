package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.config.BancoConfiguracao;
import org.pasa.sispasaint.dao.BancoConfiguracaoDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

public class BancoConfiguracaoDAOImpl extends DaoGenerico<BancoConfiguracao> implements BancoConfiguracaoDAO {

	public BancoConfiguracaoDAOImpl() {
		super(BancoConfiguracao.class);
	}
}
