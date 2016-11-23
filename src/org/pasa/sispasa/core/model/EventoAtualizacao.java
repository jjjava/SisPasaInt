package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EVENTO_ATUALIZACAO")
public class EventoAtualizacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_EVENTO_ATUALIZACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPRESA_ATUALIZADORA")
    private String empresaAtualizadora;

    @Column(name = "MATRICULA_ATUALIZADOR")
    private String matriculaAtualizador;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public EventoAtualizacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresaAtualizadora() {
        return empresaAtualizadora;
    }

    public void setEmpresaAtualizadora(String empresaAtualizadora) {
        this.empresaAtualizadora = empresaAtualizadora;
    }

    public String getMatriculaAtualizador() {
        return matriculaAtualizador;
    }

    public void setMatriculaAtualizador(String matriculaAtualizador) {
        this.matriculaAtualizador = matriculaAtualizador;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
