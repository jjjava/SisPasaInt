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
@Table(name = "DOCUMENTOS")
public class Documentos extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DOCUMENTOS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    protected Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
