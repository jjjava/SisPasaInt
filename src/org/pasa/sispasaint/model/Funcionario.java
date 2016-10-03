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

    @Column(name = "BOL_DIREITO_AMS_CREDENCIAMENTO")
    private Integer direitoAMSCredenciamento;

    @Column(name = "DT_VALIDADE_CREDENCIADO")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeCredenciado;

    @Column(name = "BOL_DIREITO_AMS_REEMBOLSO")
    private Integer direitoAmsReembolso;

    @Column(name = "DT_VALIDADE_REEMBOLSO")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeReembolso;

    @Column(name = "DT_DE_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dataDeAtualizacao;

    @Column(name = "CD_CR")
    private String codigoCR;

    @Column(name = "VL_ORGAO_PESSOAL")
    private String orgaoPessoal;

    @Column(name = "VL_VINCULO")
    private String vinculo;

    @Column(name= "CD_PLANO")
    private String plano;
    
    @Column(name = "CD_FAIXA_NIVEL")
    private String faixaNivel;
    
    @Column(name = "BOL_DIREITO_ABATER_IR")
    private Integer direitoAbaterIR;
    
    @Column(name = "VL_NUCLEO_AMS")
    private String nucleoDaAms;

    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    
    @Column(name = "NM_FIMANCEIRA")
    private String financeira;
    
    @Column(name = "CD_CONTRATO_DE_TRABALHO")
    private String contratoTrabalho;

    @Column(name = "CD_EMPRESA_ATUALIZADOR")
    private String empresaAtualizador;
    
    @Column(name = "CD_MATRICULA_ATUALIZADOR")
    private String matriculaAtulizador;

    @Column(name = "CD_DIREITO_PASA")
    private String codigoDireitoPasa;

    @Column(name = "NR_MATRICULA_PASA")
    private String matriculaPasa;

    @Column(name = "CD_EMPRESA_ORIGEM")
    private String empresaOrigem;
    
    private String matriculaOrigem;
    private String empresaPeople;
    private String matriculaPeople;
    private String unidadeDeControle;
    private String centroDeCusto;
    private String matriculaParticipante;
    private String matriculaRepresentanteLegal;
    private String planoDeReciprocidadeCassi;
    private String codigoNacionalDeSaude;
    private String cassiData;// BRANCO
    private String branco;
    private String codigoFilialVLI;

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
