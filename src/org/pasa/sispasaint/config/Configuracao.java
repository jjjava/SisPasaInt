package org.pasa.sispasaint.config;

import org.pasa.sispasaint.dao.impl.DadosConfigDAOImpl;

/**
 *
 * @author 90J00318
 */
public class Configuracao {

    private static Configuracao instance = null;
    private DadosConfig dadosConfig;

    private Configuracao() {
        this.setUp();
    }

    private void setUp() {
        dadosConfig = new DadosConfigDAOImpl().obter(1L);
    }

    public static synchronized Configuracao getInstance() {
        if (instance == null) {
            instance = new Configuracao();
        }
        return instance;
    }

    public String getPathComArquivoBenVLI() {
        return getPathInEmpVli() + "/" + getNomeBenVLIarq();// trocar quando for linux
    }

    public String getPathComArquivoEndVLI() {
        return getPathInEmpVli() + "/" + getNomeEndVLIarq();// trocar quando for linux
    }

    public String getPathComArquivoBenPeople() {
        return getPathInEmpPeoples() + "/" + getNomeBenPeople();
    }

    public String getPathComArquivoEndPeople() {
        return getPathInEmpPeoples() + "/" + getNomeEndPeople();
    }

    public String getPathComArquivoBenExt() {
        return getPathInEmpExternas() + "/" + getNomeBenExt();
    }

    public String getPathComArquivoEndExt() {
        return getPathInEmpExternas() + "/" + getNomeEndExt();
    }

    public String getPathInEmpPeoples() {
        return dadosConfig.getPathInEmpPeoples();
    }

    public String getPathInEmpVli() {
        return dadosConfig.getPathInEmpVli();
    }

    public String getPathInEmpExternas() {
        return dadosConfig.getPathInEmpExternas();
    }

    public String getPathOutEmpPeoples() {
        return dadosConfig.getPathOutEmpPeoples();
    }

    public String getPathOutEmpVli() {
        return dadosConfig.getPathOutEmpVli();
    }

    public String getPathOutEmpExternas() {
        return dadosConfig.getPathOutEmpExternas();
    }

    public String getNomeBenVLIarq() {
        return dadosConfig.getNomeBenVLIarq();
    }

    public String getNomeEndVLIarq() {
        return dadosConfig.getNomeEndVLIarq();
    }

    public String getNomeBenPeople() {
        return dadosConfig.getNomeBenPeople();
    }

    public String getNomeEndPeople() {
        return dadosConfig.getNomeEndPeople();
    }

    public String getNomeBenExt() {
        return dadosConfig.getNomeBenExt();
    }

    public String getNomeEndExt() {
        return dadosConfig.getNomeEndext();
    }
}
