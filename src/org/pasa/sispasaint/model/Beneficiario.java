package org.pasa.sispasaint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author hudson schumaker
 */
@Entity
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
public class Beneficiario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_BENEFICIARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_EMPRESA")
    private String codEmpresa;

    @Column(name = "CD_MATRICULA")
    private String matricula;
    
    @Column(name=" CD_BENEFICIARIO")
    private String codBeneficiario;

    public Beneficiario() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
