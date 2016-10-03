package org.pasa.sispasaint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "ID_CPF")
    private CPF cpf;

    @OneToOne
    @JoinColumn(name = "ID_IDENTIDADE")
    private Identidade identidade;

    @OneToOne
    @JoinColumn(name = "ID_PIS")
    private PIS pis;

    @Override
    protected Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Identidade getIdentidade() {
        return identidade;
    }

    public void setIdentidade(Identidade identidade) {
        this.identidade = identidade;
    }

    public PIS getPis() {
        return pis;
    }

    public void setPis(PIS pis) {
        this.pis = pis;
    }
}
