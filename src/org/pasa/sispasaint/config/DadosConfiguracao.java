package org.pasa.sispasaint.config;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.pasa.sispasaint.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "CARG_DADOS_CONFIGURACAO")
public class DadosConfiguracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_EMPRESA_VALE")
    private String idEmpresa;

    private String pathIn;
    private String pathOut;
    private String pathProc;
    private String nomeBen;
    private String nomeEnd;

    public DadosConfiguracao() {
    }

    public String getBenNomeArqComPath() {
        return pathIn + "/" + nomeBen + "_" + DateUtil.dataParaArquivo() + ".TXT";
    }

    public String getEndNomeArqComPath() {
        return pathIn + "/" + nomeEnd + "_" + DateUtil.dataParaArquivo() + ".TXT";
    }

    public String getBenNomeProcComPath() {
        return pathProc + "/" + nomeBen + "_" + DateUtil.dataParaArquivo() + ".zip";
    }

    public String getEndNomeProcComPath() {
        return pathProc + "/" + nomeEnd + "_" + DateUtil.dataParaArquivo() + ".zip";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathIn() {
        return pathIn;
    }

    public void setPathIn(String pathIn) {
        this.pathIn = pathIn;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getPathOut() {
        return pathOut;
    }

    public void setPathOut(String pathOut) {
        this.pathOut = pathOut;
    }

    public String getNomeBen() {
        return nomeBen + "_" + DateUtil.dataParaArquivo() + ".TXT";
    }

    public void setNomeBen(String nomeBen) {
        this.nomeBen = nomeBen;
    }

    public String getNomeEnd() {
        return nomeEnd + "_" + DateUtil.dataParaArquivo() + ".TXT";
    }

    public void setNomeEnd(String nomeEnd) {
        this.nomeEnd = nomeEnd;
    }

    public String getPathProc() {
        return pathProc;
    }

    public void setPathProc(String pathProc) {
        this.pathProc = pathProc;
    }
}
