package org.pasa.sispasaint.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    
    @OneToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "CD_MATRICULA")
    private String matricula;

    @Column(name = "VL_VINCULO")
    private String vinculo;

    @Column(name = "BOL_DIREITO_ABATER_IR")
    private Integer direitoAbaterIR;
    
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
    
    @Column(name = "NR_MATRICULA_ORIGEM")
    private String matriculaOrigem;
    
    @Column(name = "CD_EMPRESA_PEOPLE")
    private String empresaPeople;
    
    @Column(name = "CD_MATRIUCLA_PEOPLE") 
    private String matriculaPeople;
    
    @Column(name = "CD_UNIDADE_DE_CONTROLE")
    private String unidadeDeControle;
    
    @Column(name = "CD_CENTRO_DE_CUSTO")
    private String centroDeCusto;
    
    @Column(name = "BR_BRANCO")
    private String branco;
    
    @Column(name = "CD_FILIAL_VLI")
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public Integer getDireitoAbaterIR() {
        return direitoAbaterIR;
    }

    public void setDireitoAbaterIR(Integer direitoAbaterIR) {
        this.direitoAbaterIR = direitoAbaterIR;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getFinanceira() {
        return financeira;
    }

    public void setFinanceira(String financeira) {
        this.financeira = financeira;
    }

    public String getContratoTrabalho() {
        return contratoTrabalho;
    }

    public void setContratoTrabalho(String contratoTrabalho) {
        this.contratoTrabalho = contratoTrabalho;
    }

    public String getEmpresaAtualizador() {
        return empresaAtualizador;
    }

    public void setEmpresaAtualizador(String empresaAtualizador) {
        this.empresaAtualizador = empresaAtualizador;
    }

    public String getMatriculaAtulizador() {
        return matriculaAtulizador;
    }

    public void setMatriculaAtulizador(String matriculaAtulizador) {
        this.matriculaAtulizador = matriculaAtulizador;
    }

    public String getCodigoDireitoPasa() {
        return codigoDireitoPasa;
    }

    public void setCodigoDireitoPasa(String codigoDireitoPasa) {
        this.codigoDireitoPasa = codigoDireitoPasa;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getEmpresaOrigem() {
        return empresaOrigem;
    }

    public void setEmpresaOrigem(String empresaOrigem) {
        this.empresaOrigem = empresaOrigem;
    }

    public String getMatriculaOrigem() {
        return matriculaOrigem;
    }

    public void setMatriculaOrigem(String matriculaOrigem) {
        this.matriculaOrigem = matriculaOrigem;
    }

    public String getEmpresaPeople() {
        return empresaPeople;
    }

    public void setEmpresaPeople(String empresaPeople) {
        this.empresaPeople = empresaPeople;
    }

    public String getMatriculaPeople() {
        return matriculaPeople;
    }

    public void setMatriculaPeople(String matriculaPeople) {
        this.matriculaPeople = matriculaPeople;
    }

    public String getUnidadeDeControle() {
        return unidadeDeControle;
    }

    public void setUnidadeDeControle(String unidadeDeControle) {
        this.unidadeDeControle = unidadeDeControle;
    }

    public String getCentroDeCusto() {
        return centroDeCusto;
    }

    public void setCentroDeCusto(String centroDeCusto) {
        this.centroDeCusto = centroDeCusto;
    }

    public String getBranco() {
        return branco;
    }

    public void setBranco(String branco) {
        this.branco = branco;
    }

    public String getCodigoFilialVLI() {
        return codigoFilialVLI;
    }

    public void setCodigoFilialVLI(String codigoFilialVLI) {
        this.codigoFilialVLI = codigoFilialVLI;
    } 
}