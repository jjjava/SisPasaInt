package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker / Andr� Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ESTADO", columnDefinition = ConstantesBanco.CHAR_2)
    private String id;

    @Column(name = "NOME", length = 30)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private Pais pais;

    public Estado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
