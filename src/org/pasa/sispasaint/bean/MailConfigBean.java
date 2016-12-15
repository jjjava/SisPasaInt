package org.pasa.sispasaint.bean;

import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface MailConfigBean { 
    MailConfig obter(MailConfig mc);
    void cadastrar(MailConfig mc);
    void atualizar(MailConfig mc);
    void apagar(MailConfig mc);
}
