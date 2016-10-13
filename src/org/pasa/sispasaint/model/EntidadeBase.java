package org.pasa.sispasaint.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Hudson Schumaker
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
abstract class EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    protected abstract Long getId();
    
    @Column(name= "CD_SITUACAO")
    public static volatile Integer situacao;
    @Column(name= "CD_STATUS")
    public static volatile Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        EntidadeBase.status = status;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        EntidadeBase.situacao = situacao;
    }
}