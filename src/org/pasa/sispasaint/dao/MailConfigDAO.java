package org.pasa.sispasaint.dao;

import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author 90J00318
 */
public interface MailConfigDAO {
    MailConfig obter(Long id);
    boolean cadastrar(MailConfig mc);
    boolean atualizar(MailConfig mc);
    void apagar(MailConfig mc);
}
