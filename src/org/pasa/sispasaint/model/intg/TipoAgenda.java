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
@Table(name = "CARGA")
public class TipoAgenda implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_AGENDA")
    private Long id;
    
    @Column(name = "NM_CARGA")
    private String nome;
    
    @Column(name = "TP_CARGA")
    private String tipo;
    
    public TipoAgenda() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}