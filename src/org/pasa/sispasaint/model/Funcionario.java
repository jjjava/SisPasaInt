package org.pasa.sispasaint.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hudson Schumaker
 */
@Entity
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_EMPRESA")
    private String codEmpresa;

    @Column(name = "CD_MATRICULA")
    private String matricula;

    @Column(name = "CD_BENEFICIARIO")
    private String codBeneficiario;

    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "DT_DESLIGAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataDesligamento;

    @Column(name = "BL_INDICADOR_CARGA_MANUAL")
    private int indicadorCargaManual;

    @Column(name = "CD_CR")
    private String codigoCR;

    @Column(name = "NM_ORGAO_PESSOAL")
    private String orgaoPessoal;

    @Column(name = "NM_CONTRATO_TRABALHO")
    private String contratoTrabalho;

    @Column(name = "NM_MATRICULA_PASA")
    private String matriculaPASA;

    @Column(name = "NM_MATRICULA_ORIGEM")
    private String matriculaOrigem;

    @Column(name = "NM_CENTRO_CUSTO")
    private String centroCusto;

    public Funcionario() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
}
