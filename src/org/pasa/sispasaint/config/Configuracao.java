package org.pasa.sispasaint.config;

import org.pasa.sispasaint.dao.impl.DadosConfigDAOImpl;
import org.pasa.sispasaint.dao.impl.MailConfigDAOImpl;
import org.pasa.sispasaint.mail.MailConfig;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Configuracao {

    private static Configuracao instance = null;
    private MailConfig mailConfig;

    private Configuracao() {
        this.setUp();
    }

    private void setUp() {
        mailConfig = new MailConfigDAOImpl().obter(1L);//melhorar
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

    public String getBenNomeArqComPath(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getBenNomeArqComPath();
    }

    public String getEndNomeArqComPath(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getEndNomeArqComPath();
    }

    public String getNomeArqBen(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getNomeBen();
    }

    public String getNomeArqEnd(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getNomeEnd();
    }

    public String getBenNomeProcComPath(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getBenNomeProcComPath();
    }

    public String getEndNomeProcComPath(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getEndNomeProcComPath();
    }

    public String getPathIn(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getPathIn();
    }

    public String getPathOut(Long id) {
        return new DadosConfigDAOImpl().obterPorEmpresa(id).getPathOut();
    }
}
