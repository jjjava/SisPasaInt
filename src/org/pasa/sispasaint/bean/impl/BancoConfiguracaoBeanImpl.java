package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.BancoConfiguracaoBean;
import org.pasa.sispasaint.config.BancoConfiguracao;
import org.pasa.sispasaint.dao.impl.BancoConfiguracaoDAOImpl;

public class BancoConfiguracaoBeanImpl implements BancoConfiguracaoBean {

    public BancoConfiguracaoBeanImpl() {
    }

    @Override
    public BancoConfiguracao obter(Long id) {
        return new BancoConfiguracaoDAOImpl().obter(id);
    }

    @Override
    public boolean cadastrar(BancoConfiguracao bc) {
        return new BancoConfiguracaoDAOImpl().cadastrar(bc);
    }

    @Override
    public boolean atualizar(BancoConfiguracao bc) {
        return false;// Uselless
    }

    @Override
    public void apagar(BancoConfiguracao bc) {
        new BancoConfiguracaoDAOImpl().apagar(bc);
    }
}
