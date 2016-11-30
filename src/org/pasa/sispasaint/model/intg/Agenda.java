package org.pasa.sispasaint.model.intg;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 90J00318
 */
@Entity
@Table(name = "CARG_AGENDA")
public class Agenda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_AGENDA")
    private Long id;

    @Column(name = "DES_AGENDA")
    private String descricao;
    private String grupo;
    private String segundo;
    private String minuto;
    private String hora;
    private String dia;
    private String diaSemana;
    private String mes;
    private String ano;
    
    @Column(name = "ID_LISTA")
    private Long idLista;

    public Agenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSegundo() {
        if (segundo == null) {
            return "*";
        } else {
            return segundo;
        }
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getMinuto() {
        if (minuto == null) {
            return "*";
        } else {
            return minuto;
        }
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getHora() {
        if (hora == null) {
            return "*";
        } else {
            return hora;
        }
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        if (dia == null) {
            return "*";
        } else {
            return dia;
        }
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDiaSemana() {
        if (diaSemana == null) {
            return "*";
        } else {
            return diaSemana;
        }
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getMes() {
        if (mes == null) {
            return "*";
        } else {
            return mes;
        }
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        if (ano == null) {
            return "";
        } else {
            return ano;
        }
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }
}
