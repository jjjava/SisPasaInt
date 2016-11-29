package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "CONVENIO_PLANO")
public class ConvenioPlano implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONVENIO_PLANO",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_PARA")
    private String codigoPara;

    @OneToOne(targetEntity = Plano.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PLANO", referencedColumnName = "ID_PLANO")
    private Plano plano;

    @OneToOne(targetEntity = Convenio.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CONVENIO", referencedColumnName = "ID_CONVENIO")
    private Convenio convenio;

    public ConvenioPlano() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPara() {
        return codigoPara;
    }

    public void setCodigoPara(String codigoPara) {
        this.codigoPara = codigoPara;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}
