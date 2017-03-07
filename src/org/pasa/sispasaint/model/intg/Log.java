package org.pasa.sispasaint.model.intg;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "CARG_LOG")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOG", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoJob;
    private String  empresaVale;
    private Integer qtdLinhasArquivo;
    private Integer qtdRegistros;
    private Integer qtdAssocIncluidos;
    private Integer qtdAssocAlterados;
    private Integer qtdErrosAssoc;
    private Integer qtdErroLinhaArquivo;
    private Integer qtdAssocInativo;
    private String nomeArquivoBen;
    private String nomeArquivoEnd;
    private Integer qtdThreads;
    private Long qtdLote;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_LOG")
    private List<LogDetalhe> listaErros;

    @Column(name = "DT_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "DT_FIM", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    public Log() {
        listaErros = new ArrayList<>();
        qtdLinhasArquivo = 0;
        qtdErroLinhaArquivo = 0;
        qtdRegistros = 0;
        qtdAssocIncluidos = 0;
        qtdAssocAlterados = 0;
        qtdErrosAssoc = 0;
        qtdAssocInativo = 0;
        dataInicio = DateUtil.obterDataAtual();
    }

    public void addMatriculaErro(String codEmpresa, String tipoErro, String erro) {
        LogDetalhe log = new LogDetalhe();
        log.setCodEmpresa(codEmpresa);
        log.setTipoErro(tipoErro);
        log.setErro(erro);
        getListaErros().add(log);
        listaErros.add(log);
    }

    public void addMatriculaErro(String codEmpresa, String matricula, String tipoErro, String erro) {
        LogDetalhe log = new LogDetalhe(matricula);
        log.setCodEmpresa(codEmpresa);
        log.setTipoErro(tipoErro);
        log.setErro(erro);
        getListaErros().add(log);
        listaErros.add(log);
    }

    public void addMatriculaErro(String codEmpresa, String matricula, String codBenef, String tipoErro, String erro) {
        LogDetalhe log = new LogDetalhe(matricula);
        log.setCodEmpresa(codEmpresa);
        log.setCodBeneficiario(codBenef);
        log.setTipoErro(tipoErro);
        log.setErro(erro);
        getListaErros().add(log);
        listaErros.add(log);
    }

    public void addMatriculaErro(String codEmpresa, String matricula, String codBenef, String cpf, String tipoErro, String erro) {
        LogDetalhe log = new LogDetalhe(matricula);
        log.setCodEmpresa(codEmpresa);
        log.setCodBeneficiario(codBenef);
        log.setCpf(cpf);
        log.setTipoErro(tipoErro);
        log.setErro(erro);
        getListaErros().add(log);
        listaErros.add(log);
    }

    public void addClasseErro(String classe, String tipoErro, String erro) {
        LogDetalhe log = new LogDetalhe();
        log.setCodEmpresa(SisPasaIntCommon.COD_PASA);
        log.setClasse(classe);
        log.setTipoErro(tipoErro);
        log.setErro(erro);
        listaErros.add(log);
    }

    public void addLinhaArq() {
        qtdLinhasArquivo++;
    }

    public void addRegistro() {
        qtdRegistros++;
    }

    public void addAssocIncluidos() {
        qtdAssocIncluidos++;
    }

    public void addAlterados() {
        qtdAssocAlterados++;
    }

    public void addErrosAssoc() {
        qtdErrosAssoc++;
    }

    public void addLinhaArqErro() {
        qtdErroLinhaArquivo++;
    }

    public void addAsocInativo() {
        qtdAssocInativo++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtdLinhasArquivo() {
        return qtdLinhasArquivo;
    }

    public Integer getQtdRegistros() {
        return qtdRegistros;
    }

    public Integer getQtdAssocIncluidos() {
        return qtdAssocIncluidos;
    }

    public Integer getQtdAssocAlterados() {
        return qtdAssocAlterados;
    }

    public Integer getQtdErrosAssoc() {
        return qtdErrosAssoc;
    }

    public Integer getQtdAssocInativo() {
        return qtdAssocInativo;
    }

    public String getNomeArquivoBen() {
        return nomeArquivoBen;
    }

    public void setNomeArquivoBen(String nomeArquivoBen) {
        this.nomeArquivoBen = nomeArquivoBen;
    }

    public String getNomeArquivoEnd() {
        return nomeArquivoEnd;
    }

    public void setNomeArquivoEnd(String nomeArquivoEnd) {
        this.nomeArquivoEnd = nomeArquivoEnd;
    }

    public List<LogDetalhe> getListaErros() {
        return listaErros;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getQtdErroLinhaArquivo() {
        return qtdErroLinhaArquivo;
    }

    public void setQtdErroLinhaArquivo(Integer qtdErroLinhaArquivo) {
        this.qtdErroLinhaArquivo = qtdErroLinhaArquivo;
    }

    public void setQtdAssocInativo(Integer qtdAssocInativo) {
        this.qtdAssocInativo = qtdAssocInativo;
    }

    public String getEmpresaVale() {
        return empresaVale;
    }

    public void setEmpresaVale(String empresaVale) {
        this.empresaVale = empresaVale;
    }

    public String getTipoJob() {
        return tipoJob;
    }

    public void setTipoJob(String tipoJob) {
        this.tipoJob = tipoJob;
    }

    public Integer getQtdThreads() {
        return qtdThreads;
    }

    public void setQtdThreads(Integer qtdThreads) {
        this.qtdThreads = qtdThreads;
    }

    public Long getQtdLote() {
        return qtdLote;
    }

    public void setQtdLote(Long qtdLote) {
        this.qtdLote = qtdLote;
    }
}
