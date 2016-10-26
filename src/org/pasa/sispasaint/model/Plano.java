package org.pasa.sispasaint.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 90J00318
 */
@Entity
@Table(name = "PLANO")
public class Plano implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PLANO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CD_PLANO")
    private String codPlano;
    
    public Plano(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodPlano() {
        return codPlano;
    }

    public void setCodPlano(String codPlano) {
        this.codPlano = codPlano;
    }
}