package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Allan Garcia
 * @version 1.0.0
 */
@Entity
@Table(name = "SITUACAO_ASSOCIADO")
public class SituacaoAssociado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_SITUACAO_ASSOCIADO", columnDefinition = ConstantesBanco.BIGINT)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length = 30)
    private String descricao;

    public SituacaoAssociado() {
    }

    public SituacaoAssociado(Long id) {
        this.id = id;
    }

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

}
