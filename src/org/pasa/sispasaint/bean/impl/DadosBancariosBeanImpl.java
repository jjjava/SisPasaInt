package org.pasa.sispasaint.bean.impl;

import java.util.List;

import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasaint.bean.DadosBancariosBean;
import org.pasa.sispasaint.dao.impl.DadosBancariosDAOImpl;

public class DadosBancariosBeanImpl implements DadosBancariosBean {

	@Override
	public void cadastrar(DadosBancarios db) {
		new DadosBancariosDAOImpl().cadastrar(db);
	}

	@Override
	public void atualizar(DadosBancarios db) {
		new DadosBancariosDAOImpl().atualizar(db);
	}

	@Override
	public void apagar(DadosBancarios db) {
		new DadosBancariosDAOImpl().apagar(db);
	}

	@Override
	public DadosBancarios obter(Long id) {
		return new DadosBancariosDAOImpl().obter(id);
	}

	@Override
	public List<DadosBancarios> listar() {
		return new DadosBancariosDAOImpl().listar();
	}

}
