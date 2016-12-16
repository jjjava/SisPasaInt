package org.pasa.sispasaint.model.intg;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "CARG_LOG")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOG", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtdLinhasArquivo;
    private Integer qtdRegistros;
    private Integer qtdAssocIncluidos;
    private Integer qtdAssocAlterados;
    private Integer qtdErrosAssoc;
    private Integer qtdErroLinhaArquivo;
    private Integer qtdAssocInativo;
    private String nomeArquivoBen;
    private String nomeArquivoEnd;
    private List<String> matriculasErros;

    @Column(name = "DT_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "DT_FIM", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    public Log() {
        matriculasErros = new ArrayList<>();
        qtdLinhasArquivo = 0;
        qtdErroLinhaArquivo = 0;
        qtdRegistros = 0;
        qtdAssocIncluidos = 0;
        qtdAssocAlterados = 0;
        qtdErrosAssoc = 0;
        qtdAssocInativo = 0;
    }
    
    public void addMatriculaErro(String mat){
        getMatriculasErros().add(mat);
    }
    
    public void addLinhaArq(){
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
    
    public void addLinhaArqErro(){
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

    public List<String> getMatriculasErros() {
        return matriculasErros;
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
}
