package org.pasa.sispasaint.model;

import java.io.Serializable;

/**
 *
 * @author Hudson Schumaker
 */
abstract class EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    protected abstract Long getId();
    
    private Integer situacao;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }
}