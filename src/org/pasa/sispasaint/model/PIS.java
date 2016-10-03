package org.pasa.sispasaint.model;

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
@Table(name = "PIS")
public class PIS extends EntidadeBase {

    @Id
    @Column(name = "ID_PIS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NM_PIS")
    private String pis;

    public PIS() {
    }

    @Override
    protected Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }
}
