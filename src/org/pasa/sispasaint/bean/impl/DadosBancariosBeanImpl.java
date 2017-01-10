package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasaint.bean.DadosBancariosBean;
import org.pasa.sispasaint.dao.impl.DadosBancariosDAOImpl;

public class DadosBancariosBeanImpl implements DadosBancariosBean {
    
    private final DadosBancariosDAOImpl dadosBancariosDAO;
    
    public DadosBancariosBeanImpl(){
        this.dadosBancariosDAO = new DadosBancariosDAOImpl();
    }

    @Override
    public void cadastrar(DadosBancarios db) {
        dadosBancariosDAO.cadastrar(db);
    }

    @Override
    public void atualizar(DadosBancarios db) {
        dadosBancariosDAO.atualizar(db);
    }

    @Override
    public void apagar(DadosBancarios db) {
        dadosBancariosDAO.apagar(db);
    }

    @Override
    public DadosBancarios obter(Long id) {
        return dadosBancariosDAO.obter(id);
    }

    @Override
    public List<DadosBancarios> listar() {
        return dadosBancariosDAO.listar();
    }

}
