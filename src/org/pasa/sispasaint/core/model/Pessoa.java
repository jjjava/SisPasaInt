package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME", length = 60, nullable = false)
	private String nome;

	@Column(name = "NM_ABREVIADO", length = 60, nullable = false)
	private String nomeAbreviado;

	@Column(name = "DT_NASCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "DT_OBITO")
	@Temporal(TemporalType.DATE)
	private Date dataObito;

	@Column(name = "DT_INCLUSAO_SISTEMA", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInclusaoSistema;

	@Column(name = "DT_INATIVACAO")
	@Temporal(TemporalType.DATE)
	private Date dataIn;

	@Column(name = "NM_CPF")
	private String cpf;

	@Column(name = "TP_SEXO", length = 1, nullable = false)
	private String sexo;

	@Column(name = "NM_MAE", length = 60, nullable = false)
	private String nomeMae;

	@Column(name = "NM_PAI", length = 60, nullable = false)
	private String nomePai;

	@Column(name = "EM_PESSOA", length = 60)
	private String email;

	@Column(name = "ID_CONCL_ESCOL", nullable = false)
	private Integer indConclusaoEscolaridade;

	@Column(name = "ID_USUARIO", nullable = false)
	private Long idUsuario;

	@Column(name = "IND_ATIVO", nullable = false)
	private Integer indAtivo;

	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtulizacao;

	@ManyToMany
	@JoinTable(name = "PESSOA_ENDERECO", 
	joinColumns = @JoinColumn(name = "ID_PESSOA"),
	inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
	private List<Endereco> endereco;

	@ManyToMany
	@JoinTable(name = "PESSOA_TELEFONE", 
	joinColumns = @JoinColumn(name = "ID_PESSOA"),
	inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE"))
	private List<Telefone> telefones;

	@ManyToOne
	@Column(name = "ID_PAIS", nullable = false)
	private Pais pais;

	@ManyToOne
	@Column(name = "ID_ESTADO", nullable = false)
	private Estado estado;
	
	@ManyToOne
	@Column(name = "ID_MUNICIPIO", nullable = false)
	private Municipio municipio;
	
	@ManyToOne
	@Column(name = "ID_NIVEL_ESCOL", nullable = false)
	private NivelEscolaridade nivelEscolaridade;
	
	@ManyToOne
	@Column(name = "ID_ORIGEM_INFO", nullable = false)
	private OrigemInformacoes origemInformacoes;
	
	@ManyToOne
	@Column(name = "ID_ESTADO_CIVIL", nullable = false)
	private EstadoCivil estadoCivil;

	public Pessoa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataObito() {
		return dataObito;
	}

	public void setDataObito(Date dataObito) {
		this.dataObito = dataObito;
	}

	public Date getDataInclusaoSistema() {
		return dataInclusaoSistema;
	}

	public void setDataInclusaoSistema(Date dataInclusaoSistema) {
		this.dataInclusaoSistema = dataInclusaoSistema;
	}

	public Date getDataIn() {
		return dataIn;
	}

	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIndConclusaoEscolaridade() {
		return indConclusaoEscolaridade;
	}

	public void setIndConclusaoEscolaridade(Integer indConclusaoEscolaridade) {
		this.indConclusaoEscolaridade = indConclusaoEscolaridade;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}

	public Date getDataAtulizacao() {
		return dataAtulizacao;
	}

	public void setDataAtulizacao(Date dataAtulizacao) {
		this.dataAtulizacao = dataAtulizacao;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public NivelEscolaridade getNivelEscolaridade() {
		return nivelEscolaridade;
	}

	public void setNivelEscolaridade(NivelEscolaridade nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}

	public OrigemInformacoes getOrigemInformacoes() {
		return origemInformacoes;
	}

	public void setOrigemInformacoes(OrigemInformacoes origemInformacoes) {
		this.origemInformacoes = origemInformacoes;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}