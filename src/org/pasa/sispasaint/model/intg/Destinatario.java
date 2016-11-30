package org.pasa.sispasaint.model.intg;

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
 * @author 90J00318
 */
@Entity
@Table(name = "CARG_DESTINATARIO")
public class Destinatario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_DESTINATARIO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String area;
    
    public Destinatario(){
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
