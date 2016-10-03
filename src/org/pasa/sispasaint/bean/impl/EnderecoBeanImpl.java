package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.EnderecoBean;
import org.pasa.sispasaint.dao.impl.EnderecoDAOImpl;
import org.pasa.sispasaint.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */
public class EnderecoBeanImpl implements EnderecoBean {

    public EnderecoBeanImpl() {
    }

    @Override
    public void cadastrar(Endereco e) {
        new EnderecoDAOImpl().cadastrar(e);
    }

    @Override
    public void atualizar(Endereco e) {
        new EnderecoDAOImpl().atualizar(e);
    }

    @Override
    public void apagar(Endereco e) {
        new EnderecoDAOImpl().apagar(e);
    }

    @Override
    public Endereco obter(Long id) {
        return new EnderecoDAOImpl().obter(id);
    }

    @Override
    public List<Endereco> listar() {
        return new EnderecoDAOImpl().listar();
    }
}
