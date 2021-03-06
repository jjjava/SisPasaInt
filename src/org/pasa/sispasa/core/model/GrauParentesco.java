package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "GRAU_PARENTESCO")
public class GrauParentesco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_GRAU_PARENT", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false,length=30)
    private String descricao;

    @Column(name = "CD_EXTERNO", columnDefinition = ConstantesBanco.CHAR_1)
    private String codExterno;
    
    
   //CONSTRUTORES
    
    public GrauParentesco() {
    	//CONSTRUTOR DEFAULT
    }

    //GETTERS E SETTERS
    
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

    public String getCodExterno() {
        return codExterno;
    }

    public void setCodExterno(String codExterno) {
        this.codExterno = codExterno;
    }
}
