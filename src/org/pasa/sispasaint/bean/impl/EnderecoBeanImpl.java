package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasaint.bean.EnderecoBean;
import org.pasa.sispasaint.dao.impl.EnderecoDAOImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.1
 */
public class EnderecoBeanImpl implements EnderecoBean {

    private EnderecoDAOImpl enderecoDAO;
    public EnderecoBeanImpl() {
        this.enderecoDAO = new EnderecoDAOImpl();
    }

    @Override
    public void cadastrar(Endereco e) {
        enderecoDAO.cadastrar(e);
    }

    @Override
    public void atualizar(Endereco e) {
        enderecoDAO.atualizar(e);
    }

    @Override
    public void apagar(Endereco e) {
        enderecoDAO.apagar(e);
    }

    @Override
    public Endereco obter(Long id) {
        return enderecoDAO.obter(id);
    }

    @Override
    public List<Endereco> listar() {
        return enderecoDAO.listar();
    }
}
