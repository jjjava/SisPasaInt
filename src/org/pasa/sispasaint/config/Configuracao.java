package org.pasa.sispasaint.config;

import org.pasa.sispasaint.dao.impl.BancoConfiguracaoDAOImpl;
import org.pasa.sispasaint.dao.impl.DadosConfiguracaoDAOImpl;
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
    private BancoConfiguracao bancoConfiguracao;

    private Configuracao() {
        this.setUp();
    }

    private void setUp() {
        this.mailConfig = new MailConfigDAOImpl().obter(1L);//melhorar
        this.bancoConfiguracao = new BancoConfiguracaoDAOImpl().obter(1L);//melhorar 
    }

    public static synchronized Configuracao getInstance() {
        if (null == instance) {
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
    
    public String getBanco(){
    	return bancoConfiguracao.getDataBase();
    }
    
    public String getEsquema(){
    	return bancoConfiguracao.getOwner();
    }

    public String getBenNomeArqComPath(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getBenNomeArqComPath();
    }

    public String getEndNomeArqComPath(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getEndNomeArqComPath();
    }

    public String getNomeArqBen(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getNomeBen();
    }

    public String getNomeArqEnd(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getNomeEnd();
    }

    public String getBenNomeProcComPath(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getBenNomeProcComPath();
    }

    public String getEndNomeProcComPath(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getEndNomeProcComPath();
    }

    public String getPathIn(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getPathIn();
    }

    public String getPathOut(String id) {
        return new DadosConfiguracaoDAOImpl().obterPorEmpresa(id).getPathOut();
    }
}
