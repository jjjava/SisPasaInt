package org.pasa.sispasaint.config;

import org.pasa.sispasaint.dao.impl.DadosConfigDAOImpl;
import org.pasa.sispasaint.dao.impl.MailConfigDAOImpl;
import org.pasa.sispasaint.mail.MailConfig;
import org.pasa.sispasaint.util.DateUtil;

/**
 *
 * @author 90J00318
 */
public class Configuracao {

    private static Configuracao instance = null;
    private MailConfig mailConfig;

    private Configuracao() {
        this.setUp();
    }

    private void setUp() {
        mailConfig = new MailConfigDAOImpl().obter(1L);
    }

    public static synchronized Configuracao getInstance() {
        if (instance == null) {
            instance = new Configuracao();
        }
        return instance;
    }

    public String getUsuario() {
        return mailConfig.getUsuario();
    }

    public String getSenha() {
        return mailConfig.getSenha();
    }

    public String getServidor() {
        return mailConfig.getServidor();
    }
    
    public String getBenNomeArqComPath(Long id){
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getBenNomeArqComPath();
    }
    
    public String getNomeArqComPath(Long id){
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getEndNomeArqComPath();
    }
}
