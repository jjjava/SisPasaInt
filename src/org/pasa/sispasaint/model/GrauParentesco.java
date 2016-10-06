package org.pasa.sispasaint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hudson
 */
@Entity
@Table(name = "GRAU_PARENTESCO")
public class GrauParentesco extends EntidadeBase{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_GRAU_PARENTESCO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NM_GRAU_PARENTESCO")
    private String grauParentesco;
    
    @Column(name= "VL_DESCRICAO")
    private String descricao;
    
    public GrauParentesco(){
    }

    @Override
    protected Long getId() {
        return id;
    }
    
     public void setId(Long id) {
        this.id = id;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
