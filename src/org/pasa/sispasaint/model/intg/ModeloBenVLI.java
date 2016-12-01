package org.pasa.sispasaint.model.intg;

import java.io.Serializable;
import javax.persistence.Entity;
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
@Table(name = "TEMP_BEN_VLI")
public class ModeloBenVLI implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String matricula;
    private String codBeneficiario;
    private String direitoAMSCredenciamento;
    private String dataValidadeCredenciado;
    private String direitoAmsReembolso;
    private String dataValidadeReembolso;
    private String dataDeAtualizacao;
    private String nomeBeneficiarioAbreviado;
    private String codigoCR;
    private String orgaoPessoal;
    private String vinculo;
    private String plano;
    private String faixaNivel;
    private String dataNascimento;
    private String direitoAbaterIR;
    private String nucleoDaAms;
    private String agenciaBancaria;
    private String banco;
    private String contaCorrente;
    private String dataAdmissao;
    private String grauParentesco;
    private String financeira;
    private String contratoTrabalho;
    private String sexo;
    private String empresaAtualizador;
    private String matriculaAtulizador;
    private String tipoBeneficiario;
    private String codigoDireitoPasa;
    private String grauEscolaridade;
    private String indicadorConclusao;
    private String dataFalecimento;
    private String matriculaPasa;
    private String nomeDaMae;
    private String pis;
    private String cpf;
    private String empresaOrigem;
    private String matriculaOrigem;
    private String empresaPeople;
    private String matriculaPeople;
    private String unidadeDeControle;
    private String centroDeCusto;
    private String matriculaParticipante;
    private String matriculaRepresentanteLegal;
    private String nomeBeneficiario;
    private String planoDeReciprocidadeCassi;
    private String codigoNacionalDeSaude;
    private String declaracaoNascidoVivo;
    private String cassiData;// BRANCO
    private String branco;
    private String codigoFilialVLI;
    private String nomeArquivo;

    public ModeloBenVLI() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodBeneficiario() {
        return codBeneficiario;
    }

    public void setCodBeneficiario(String codBeneficiario) {
        this.codBeneficiario = codBeneficiario;
    }

    public String getDireitoAMSCredenciamento() {
        return direitoAMSCredenciamento;
    }

    public void setDireitoAMSCredenciamento(String direitoAMSCredenciamento) {
        this.direitoAMSCredenciamento = direitoAMSCredenciamento;
    }

    public String getDataValidadeCredenciado() {
        return dataValidadeCredenciado;
    }

    public void setDataValidadeCredenciado(String dataValidadeCredenciado) {
        this.dataValidadeCredenciado = dataValidadeCredenciado;
    }

    public String getDireitoAmsReembolso() {
        return direitoAmsReembolso;
    }

    public void setDireitoAmsReembolso(String direitoAmsReembolso) {
        this.direitoAmsReembolso = direitoAmsReembolso;
    }

    public String getDataValidadeReembolso() {
        return dataValidadeReembolso;
    }

    public void setDataValidadeReembolso(String dataValidadeReembolso) {
        this.dataValidadeReembolso = dataValidadeReembolso;
    }

    public String getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(String dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public String getNomeBeneficiarioAbreviado() {
        return nomeBeneficiarioAbreviado;
    }

    public void setNomeBeneficiarioAbreviado(String nomeBeneficiarioAbreviado) {
        this.nomeBeneficiarioAbreviado = nomeBeneficiarioAbreviado;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDireitoAbaterIR() {
        return direitoAbaterIR;
    }

    public void setDireitoAbaterIR(String direitoAbaterIR) {
        this.direitoAbaterIR = direitoAbaterIR;
    }

    public String getNucleoDaAms() {
        return nucleoDaAms;
    }

    public void setNucleoDaAms(String nucleoDaAms) {
        this.nucleoDaAms = nucleoDaAms;
    }

    public String getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public void setAgenciaBancaria(String agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getCodigoDireitoPasa() {
        return codigoDireitoPasa;
    }

    public void setCodigoDireitoPasa(String codigoDireitoPasa) {
        this.codigoDireitoPasa = codigoDireitoPasa;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public String getIndicadorConclusao() {
        return indicadorConclusao;
    }

    public void setIndicadorConclusao(String indicadorConclusao) {
        this.indicadorConclusao = indicadorConclusao;
    }

    public String getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(String dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getMatriculaRepresentanteLegal() {
        return matriculaRepresentanteLegal;
    }

    public void setMatriculaRepresentanteLegal(String matriculaRepresentanteLegal) {
        this.matriculaRepresentanteLegal = matriculaRepresentanteLegal;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getPlanoDeReciprocidadeCassi() {
        return planoDeReciprocidadeCassi;
    }

    public void setPlanoDeReciprocidadeCassi(String planoDeReciprocidadeCassi) {
        this.planoDeReciprocidadeCassi = planoDeReciprocidadeCassi;
    }

    public String getCodigoNacionalDeSaude() {
        return codigoNacionalDeSaude;
    }

    public void setCodigoNacionalDeSaude(String codigoNacionalDeSaude) {
        this.codigoNacionalDeSaude = codigoNacionalDeSaude;
    }

    public String getDeclaracaoNascidoVivo() {
        return declaracaoNascidoVivo;
    }

    public void setDeclaracaoNascidoVivo(String declaracaoNascidoVivo) {
        this.declaracaoNascidoVivo = declaracaoNascidoVivo;
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

    public String getChaveMatricula() {
        return empresa + matricula + codBeneficiario;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
