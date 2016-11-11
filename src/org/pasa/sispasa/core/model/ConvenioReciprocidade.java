package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "CONVENIO_RECIPROCIDADE")
public class ConvenioReciprocidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONVENIO_RECIPROCIDAE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ConvenioReciprocidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
