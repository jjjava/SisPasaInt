package org.pasa.sispasaint.model;

import org.pasa.sispasaint.model.enun.TipoTelefone;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "TELEFONE")
public class Telefone extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TELEFONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_NACIONAL")
    private String codigoNacional;

    @Column(name = "NR_DDD")
    private int ddd;

    @Column(name = "NR_TELEFONE")
    private int numeroTelefone;

    @Column(name = "NR_RAMAL")
    private int ramal;

    @Column(name = "NM_PRESTADORA")
    private String prestadora;

    @Column(name = "TP_TELFONE")
    @Enumerated(EnumType.ORDINAL)
    private TipoTelefone tipoTelefone;

    public Telefone() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoNacional() {
        return codigoNacional;
    }

    public void setCodigoNacional(String codigoNacional) {
        this.codigoNacional = codigoNacional;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public String getPrestadora() {
        return prestadora;
    }

    public void setPrestadora(String prestadora) {
        this.prestadora = prestadora;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
