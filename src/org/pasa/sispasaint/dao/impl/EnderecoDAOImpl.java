package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.EnderecoDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class EnderecoDAOImpl extends DaoGenerico<Endereco> implements EnderecoDAO {

    public EnderecoDAOImpl() {
        super(Endereco.class);
    }
}
