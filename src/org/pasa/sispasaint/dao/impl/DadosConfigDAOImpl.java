package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.config.DadosConfig;
import org.pasa.sispasaint.dao.DadosConfigDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

/**
 *
 * @author Hudson Schumaker
 */
public class DadosConfigDAOImpl extends DaoGenerico<DadosConfig> implements DadosConfigDAO {

    public DadosConfigDAOImpl() {
        super(DadosConfig.class);
    }
}
