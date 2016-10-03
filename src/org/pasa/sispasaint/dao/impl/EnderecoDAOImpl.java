package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EnderecoDAO;
import org.pasa.sispasaint.model.Endereco;

/**
 *
 * @author Hudson Schumaker
 */
public class EnderecoDAOImpl extends DaoGenerico<Endereco> implements EnderecoDAO {

    public EnderecoDAOImpl() {
        super(Endereco.class);
    }
}
