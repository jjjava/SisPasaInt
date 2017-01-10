package org.pasa.sispasa.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.enumeration.EnumSimNao;

@Entity
@Table(name = "TIPO_TAXA")
@Audited
@AuditTable(value = "HIST_TIPO_TAXA")
public class TipoTaxa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TIPO_TAXA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "IND_ATIVO")
    private EnumSimNao indAtivo;

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

    public EnumSimNao getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(EnumSimNao indAtivo) {
        this.indAtivo = indAtivo;
    }
}
