package org.pasa.sispasaint.model.intg;

import java.util.Date;
import java.io.Serializable;
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

    private Integer qtdRegistros;
    private Integer qtdAssocIncluidos;
    private Integer qtdAssocAlterados;
    private Integer qtdErrosAssoc;
    private Integer qtdAssocInativo;
    
    @Column(name = "DT_INICIO", nullable = false) 
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    
    @Column(name = "DT_FIM", nullable = false) 
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    public Log() {
        qtdRegistros = 0;
        qtdAssocIncluidos = 0;
        qtdAssocAlterados = 0;
        qtdErrosAssoc = 0;
        qtdAssocInativo = 0;
    }

    public void addRegistro() {
        qtdRegistros++;
    }
    
    public void addAssocIncluidos(){
        qtdAssocIncluidos++;
    }
    
    public void addAlterados(){
        qtdAssocAlterados++;
    }
    
    public void addErrosAssoc(){
        qtdErrosAssoc++;
    }
    
    public void addAsocInativo(){
        qtdAssocInativo++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtdRegistros() {
        return qtdRegistros;
    }

    public void setQtdRegistros(Integer qtdRegistros) {
        this.qtdRegistros = qtdRegistros;
    }

    public Integer getQtdAssocIncluidos() {
        return qtdAssocIncluidos;
    }

    public void setQtdAssocIncluidos(Integer qtdAssocIncluidos) {
        this.qtdAssocIncluidos = qtdAssocIncluidos;
    }

    public Integer getQtdAssocAlterados() {
        return qtdAssocAlterados;
    }

    public void setQtdAssocAlterados(Integer qtdAssocAlterados) {
        this.qtdAssocAlterados = qtdAssocAlterados;
    }

    public Integer getQtdErrosAssoc() {
        return qtdErrosAssoc;
    }

    public void setQtdErrosAssoc(Integer qtdErrosAssoc) {
        this.qtdErrosAssoc = qtdErrosAssoc;
    }

    public Integer getQtsAssocInativo() {
        return qtdAssocInativo;
    }

    public void setQtsAssocInativo(Integer qtdAssocInativo) {
        this.qtdAssocInativo = qtdAssocInativo;
    }

    public Integer getQtdAssocInativo() {
        return qtdAssocInativo;
    }

    public void setQtdAssocInativo(Integer qtdAssocInativo) {
        this.qtdAssocInativo = qtdAssocInativo;
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
}
