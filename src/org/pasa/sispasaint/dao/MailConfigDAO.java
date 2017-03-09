package org.pasa.sispasaint.dao;

import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author Hudson Schumaker
 */
public interface MailConfigDAO {
    MailConfig obter(Long id);
    boolean cadastrar(MailConfig mc);
    boolean atualizar(MailConfig mc);
    void apagar(MailConfig mc);
}
