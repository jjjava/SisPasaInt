package org.pasa.sispasaint.config;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 */
@Entity
@Table(name = "DADOS_CONFIGURACAO")
public class DadosConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pathInEmpPeoples;
    private String pathInEmpVli;
    private String pathInEmpExternas;
    private String pathOutEmpPeoples;
    private String pathOutEmpVli;
    private String pathOutEmpExternas;
    private String nomeBenVLIarq;
    private String nomeEndVLIarq;
    private String nomeBenPeople;
    private String nomeEndPeople;
    private String nomeBenExt;
    private String nomeEndext;

    public DadosConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathInEmpPeoples() {
        return pathInEmpPeoples;
    }

    public void setPathInEmpPeoples(String pathInEmpPeoples) {
        this.pathInEmpPeoples = pathInEmpPeoples;
    }

    public String getPathInEmpVli() {
        return pathInEmpVli;
    }

    public void setPathInEmpVli(String pathInEmpVli) {
        this.pathInEmpVli = pathInEmpVli;
    }

    public String getPathInEmpExternas() {
        return pathInEmpExternas;
    }

    public void setPathInEmpExternas(String pathInEmpExternas) {
        this.pathInEmpExternas = pathInEmpExternas;
    }

    public String getPathOutEmpPeoples() {
        return pathOutEmpPeoples;
    }

    public void setPathOutEmpPeoples(String pathOutEmpPeoples) {
        this.pathOutEmpPeoples = pathOutEmpPeoples;
    }

    public String getPathOutEmpVli() {
        return pathOutEmpVli;
    }

    public void setPathOutEmpVli(String pathOutEmpVli) {
        this.pathOutEmpVli = pathOutEmpVli;
    }

    public String getPathOutEmpExternas() {
        return pathOutEmpExternas;
    }

    public void setPathOutEmpExternas(String pathOutEmpExternas) {
        this.pathOutEmpExternas = pathOutEmpExternas;
    }

    public String getNomeBenVLIarq() {
        return nomeBenVLIarq;
    }

    public void setNomeBenVLIarq(String nomeBenVLIarq) {
        this.nomeBenVLIarq = nomeBenVLIarq;
    }

    public String getNomeEndVLIarq() {
        return nomeEndVLIarq;
    }

    public void setNomeEndVLIarq(String nomeEndVLIarq) {
        this.nomeEndVLIarq = nomeEndVLIarq;
    }

    public String getNomeBenPeople() {
        return nomeBenPeople;
    }

    public void setNomeBenPeople(String nomeBenPeople) {
        this.nomeBenPeople = nomeBenPeople;
    }

    public String getNomeEndPeople() {
        return nomeEndPeople;
    }

    public void setNomeEndPeople(String nomeEndPeople) {
        this.nomeEndPeople = nomeEndPeople;
    }

    public String getNomeBenExt() {
        return nomeBenExt;
    }

    public void setNomeBenExt(String nomeBenExt) {
        this.nomeBenExt = nomeBenExt;
    }

    public String getNomeEndext() {
        return nomeEndext;
    }

    public void setNomeEndext(String nomeEndext) {
        this.nomeEndext = nomeEndext;
    }
}
