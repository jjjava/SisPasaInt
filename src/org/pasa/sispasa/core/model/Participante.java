package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.enumeration.EnumIndAtivo;
import org.pasa.sispasa.core.enumeration.EnumTipoTelefone;

@Entity
@Table(name = "PARTICIPANTE")
@Audited
@AuditTable(value = "HIST_PARTICIPANTE")
public class Participante extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PARTICIPANTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "DT_FALECIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataFalecimento;

	@Column(name = "DT_INCLUSAO_SISTEMA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusaoSistema;

	@Column(name = "DT_INATIVACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInativacao;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "NM_MAE")
	private String nomeMae;

	@Column(name = "NM_PAI")
	private String nomePai;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ID_CONCL_ESCOL")
	private Integer indConclusaoEscolaridade;

	@Column(name = "IND_ATIVO")
	private Integer indAtivo = EnumIndAtivo.ATIVO.getIndice();

	@Column(name = "DT_ULT_ATULZ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;

	@ManyToMany
	@JoinTable(name = "PARTICIPANTE_ENDERECO", 
	joinColumns = @JoinColumn(name = "ID_PARTICIPANTE"), 
	inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
	@NotAudited
	private List<Endereco> enderecos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PARTICIPANTE_TELEFONE", 
	joinColumns = @JoinColumn(name = "ID_PARTICIPANTE"), 
	inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE"))
	@NotAudited
	private List<Telefone> telefones;

	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	@NotAudited
	private Pais nacionalidade;

	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	@NotAudited
	private Estado naturalidade;

	@ManyToOne
	@JoinColumn(name = "ID_MUNICIPIO")
	@NotAudited
	private Municipio cidadeOrigem;

	@ManyToOne
	@JoinColumn(name = "ID_NIVEL_ESCOL")
	@NotAudited
	private NivelEscolaridade nivelEscolaridade;

	@ManyToOne
	@JoinColumn(name = "ID_ESTADO_CIVIL")
	@NotAudited
	private EstadoCivil estadoCivil;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Associado associado;

	public Telefone getTelefoneComercial() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.getTipoTelefone().getId().equals(EnumTipoTelefone.COMERCIAL.getId())) {
				return telefone;
			}
		}
		return null;
	}

	public Telefone getTelefoneResidencial() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.getTipoTelefone().getId().equals(EnumTipoTelefone.RESIDENCIAL.getId())) {
				return telefone;
			}
		}
		return null;
	}

	public Telefone getTelefoneCelular() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.getTipoTelefone().getId().equals(EnumTipoTelefone.CELULAR.getId())) {
				return telefone;
			}
		}
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataFalecimento() {
		return dataFalecimento;
	}

	public void setDataFalecimento(Date dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}

	public Date getDataInclusaoSistema() {
		return dataInclusaoSistema;
	}

	public void setDataInclusaoSistema(Date dataInclusaoSistema) {
		this.dataInclusaoSistema = dataInclusaoSistema;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
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

	public Integer getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Estado getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Estado naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Municipio getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(Municipio cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public NivelEscolaridade getNivelEscolaridade() {
		return nivelEscolaridade;
	}

	public void setNivelEscolaridade(NivelEscolaridade nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Telefone> getTelefones() {
		if(null == telefones) {
			telefones = new ArrayList<Telefone>();
		}
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

}
