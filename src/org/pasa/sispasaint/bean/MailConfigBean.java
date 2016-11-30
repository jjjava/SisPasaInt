package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author 90J00318
 */
public interface MailConfigBean {
    
    MailConfig obter(MailConfig mc);
    void cadastrar(MailConfig mc);
    void alterar(MailConfig mc);
    void apagar(MailConfig mc);
}
