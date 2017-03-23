package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumTipoTelefone;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "TIPO_TELEFONE")
public class TipoTelefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TP_TELEFONE", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", length = 30, nullable = false)
    private String descricao;

    public TipoTelefone() {
    }

    public TipoTelefone(Long id) {
        this.id = id;
    }

    public EnumTipoTelefone getAsEnum() {
        return EnumTipoTelefone.getTipoTelefoneByIndice(id.intValue());
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
