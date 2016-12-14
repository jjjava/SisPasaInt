package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasaint.dao.DadosBancariosDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

public class DadosBancariosDAOImpl extends DaoGenerico<DadosBancarios> implements DadosBancariosDAO{

	public DadosBancariosDAOImpl() {
		super(DadosBancarios.class);
	}
}
