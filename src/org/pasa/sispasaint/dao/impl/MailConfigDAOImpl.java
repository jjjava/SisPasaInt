package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.MailConfigDAO;
import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class MailConfigDAOImpl extends DaoGenerico<MailConfig> implements MailConfigDAO{

    public MailConfigDAOImpl() {
        super(MailConfig.class);
    }
}
