package org.pasa.sispasa.core.model;

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
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "TIPO_PAGAMENTO")
public class TipoPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PAGAMENTO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", length = 30, nullable = false)
    private String descricao;

    @Column(name = "TP_PAGADOR", columnDefinition = ConstantesBanco.CHAR_1, nullable = false)
    private String tipoPagador;

    //CONSTRUTORES
    public TipoPagamento() {
    }

    public TipoPagamento(Long id) {
        this.id = id;
    }

    //GETTERS E SETTERS
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

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }
}
