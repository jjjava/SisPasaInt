package org.pasa.sispasa.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "CONVENIO_RECIPROCIDADE")
@Audited
@AuditTable(value="HIST_CONVENIO_RECIPROCIDADE")
public class ConvenioReciprocidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONVENIO_RECIPROCIDAE",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //CONSTRUTORES
    public ConvenioReciprocidade() {
    }

   //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
