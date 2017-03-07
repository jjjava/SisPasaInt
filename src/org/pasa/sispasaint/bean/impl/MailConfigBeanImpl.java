package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.MailConfigBean;
import org.pasa.sispasaint.dao.impl.MailConfigDAOImpl;
import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class MailConfigBeanImpl implements MailConfigBean {

    public MailConfigBeanImpl() {
    }

    @Override
    public MailConfig obter(MailConfig mc) {
        return new MailConfigDAOImpl().obter(1L);
    }

    @Override
    public void cadastrar(MailConfig mc) {
        new MailConfigDAOImpl().cadastrar(mc);
    }

    @Override
    public void atualizar(MailConfig mc) {
        new MailConfigDAOImpl().apagar(mc);
    }

    @Override
    public void apagar(MailConfig mc) {
        new MailConfigDAOImpl().apagar(mc);
    }
}
