package org.pasa.sispasaint.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column(name = "CD_EMPRESA_PEOPLE")
    private String matriculaParticipante;
    
    @Column(name = "BL_PLANO_DE_RECIPROCIDADE_CASSI")
    private Integer planoDeReciprocidadeCassi;
    
    @Column(name = "CD_NACIONAL_DE_SAUDE")
    private String codigoNacionalDeSaude;
    
    @Column(name = "BR_CASSI_DATA")
    private String cassiData;// BRANCO
    
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

    public String getCodBeneficiario() {
        return codBeneficiario;
    }

    public void setCodBeneficiario(String codBeneficiario) {
        this.codBeneficiario = codBeneficiario;
    }

    public Integer getDireitoAMSCredenciamento() {
        return direitoAMSCredenciamento;
    }

    public void setDireitoAMSCredenciamento(Integer direitoAMSCredenciamento) {
        this.direitoAMSCredenciamento = direitoAMSCredenciamento;
    }

    public Date getDataValidadeCredenciado() {
        return dataValidadeCredenciado;
    }

    public void setDataValidadeCredenciado(Date dataValidadeCredenciado) {
        this.dataValidadeCredenciado = dataValidadeCredenciado;
    }

    public Integer getDireitoAmsReembolso() {
        return direitoAmsReembolso;
    }

    public void setDireitoAmsReembolso(Integer direitoAmsReembolso) {
        this.direitoAmsReembolso = direitoAmsReembolso;
    }

    public Date getDataValidadeReembolso() {
        return dataValidadeReembolso;
    }

    public void setDataValidadeReembolso(Date dataValidadeReembolso) {
        this.dataValidadeReembolso = dataValidadeReembolso;
    }

    public Date getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(Date dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public String getCodigoCR() {
        return codigoCR;
    }

    public void setCodigoCR(String codigoCR) {
        this.codigoCR = codigoCR;
    }

    public String getOrgaoPessoal() {
        return orgaoPessoal;
    }

    public void setOrgaoPessoal(String orgaoPessoal) {
        this.orgaoPessoal = orgaoPessoal;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getFaixaNivel() {
        return faixaNivel;
    }

    public void setFaixaNivel(String faixaNivel) {
        this.faixaNivel = faixaNivel;
    }

    public Integer getDireitoAbaterIR() {
        return direitoAbaterIR;
    }

    public void setDireitoAbaterIR(Integer direitoAbaterIR) {
        this.direitoAbaterIR = direitoAbaterIR;
    }

    public String getNucleoDaAms() {
        return nucleoDaAms;
    }

    public void setNucleoDaAms(String nucleoDaAms) {
        this.nucleoDaAms = nucleoDaAms;
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

    public String getMatriculaParticipante() {
        return matriculaParticipante;
    }

    public void setMatriculaParticipante(String matriculaParticipante) {
        this.matriculaParticipante = matriculaParticipante;
    }

    public Integer getPlanoDeReciprocidadeCassi() {
        return planoDeReciprocidadeCassi;
    }

    public void setPlanoDeReciprocidadeCassi(Integer planoDeReciprocidadeCassi) {
        this.planoDeReciprocidadeCassi = planoDeReciprocidadeCassi;
    }

    public String getCodigoNacionalDeSaude() {
        return codigoNacionalDeSaude;
    }

    public void setCodigoNacionalDeSaude(String codigoNacionalDeSaude) {
        this.codigoNacionalDeSaude = codigoNacionalDeSaude;
    }

    public String getCassiData() {
        return cassiData;
    }

    public void setCassiData(String cassiData) {
        this.cassiData = cassiData;
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