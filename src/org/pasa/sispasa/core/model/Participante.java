package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumEstadoCivil;
import org.pasa.sispasa.core.enumeration.EnumIndAtivo;
import org.pasa.sispasa.core.enumeration.EnumNivelEscolaridade;
import org.pasa.sispasa.core.enumeration.EnumSexo;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.util.Utils;

/**
 * 
 * @author Allan Garcia
 *
 */

@Entity
@Table(name = "PARTICIPANTE", 
indexes = {@Index(name = "CPF_PARTICIP_IDX", columnList = "CPF", unique = false),
		@Index(name = "NOME_IDX", columnList = "NOME", unique = false)})
@Audited
@AuditTable(value = "HIST_PARTICIPANTE")
public class Participante extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PARTICIPANTE", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
	private Long idUsuario;

	@Column(name = "CPF", columnDefinition = ConstantesBanco.CHAR_11)
	private String cpf;

	@Column(name = "NOME", length = 60, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_NASCIMENTO", columnDefinition = ConstantesBanco.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_FALECIMENTO", columnDefinition = ConstantesBanco.DATE)
	private Date dataFalecimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_INATIVACAO")
	private Date dataInativacao;

	@Column(name = "SEXO", columnDefinition = ConstantesBanco.CHAR_1)
	private String sexo;

	@Column(name = "NM_MAE", length = 60)
	private String nomeMae;

	@Column(name = "NM_PAI", length = 60)
	private String nomePai;

	@Column(name = "EMAIL", length = 60)
	private String email;

	@Column(name = "EMAIL_COMERCIAL", length = 60)
	private String emailComercial;

	@Column(name = "ID_CONCL_ESCOL", columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indConclusaoEscolaridade;

	@Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indAtivo = EnumIndAtivo.ATIVO.getIndice();

	@Column(name = "DT_ULT_ATULZ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Associado associado;

	@OneToOne
	@JoinColumn(name = "ID_ENDERECO")
	@NotAudited
	private Endereco endereco;

	@OneToMany(mappedBy = "participante")
	@NotAudited
	private List<ParticipanteDadosBancarios> partDadosBancarios;

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

	@ManyToMany
	@JoinTable(	name = "PARTICIPANTE_TELEFONE", 
				joinColumns = @JoinColumn(name = "ID_PARTICIPANTE"), 
				inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE"))
	@NotAudited
	private List<Telefone> telefones;

	@ManyToMany
	@JoinTable(	name = "PARTICIPANTE_DOCUMENTO", 
				joinColumns = @JoinColumn(name = "ID_PARTICIPANTE"), 
				inverseJoinColumns = @JoinColumn(name = "ID_DOCUMENTO"))
	@NotAudited
	private List<Documento> documentos;

	public DadosBancarios getDadosBancariosPagamento() {
		for (ParticipanteDadosBancarios partDadosBancarios : partDadosBancarios) {
			if (partDadosBancarios.isTipoContaPagamento()) {
				return partDadosBancarios.getDadosBancarios();
			}
		}
		return null;
	}

	public DadosBancarios getDadosBancariosReembolso() {
		for (ParticipanteDadosBancarios partDadosBancarios : partDadosBancarios) {
			if (partDadosBancarios.isTipoContaReembolso()) {
				return partDadosBancarios.getDadosBancarios();
			}
		}
		return null;
	}

	public Documento getDocumentoRG() {
		for (Documento documento : documentos) {
			if (documento.isTipoDocumentoRG()) {
				return documento;
			}
		}
		return null;
	}

	public Documento getDocumentoCTPS() {
		for (Documento documento : documentos) {
			if (documento.isTipoDocumentoCTPS()) {
				return documento;
			}
		}
		return null;
	}

	public Documento getDocumentoPIS() {
		for (Documento documento : documentos) {
			if (documento.isTipoDocumentoPIS()) {
				return documento;
			}
		}
		return null;
	}

	public Telefone getTelefoneComercial() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.isTipoTelfoneComercial()) {
				return telefone;
			}
		}
		return null;
	}

	public Telefone getTelefoneResidencial() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.isTipoTelfoneResidencial()) {
				return telefone;
			}
		}
		return null;
	}

	public Telefone getTelefoneCelular() {
		for (Telefone telefone : getTelefones()) {
			if (telefone.isTipoTelfoneCelular()) {
				return telefone;
			}
		}
		return null;
	}

	public EnumNivelEscolaridade getNivelEscolaridadeAsEnum() {
		return null == nivelEscolaridade ? null
				: EnumNivelEscolaridade.getNivelEscolaridadeByIndice(getNivelEscolaridade().getId());
	}

	public EnumSimNao getIndConclusaoEscolaridadeAsEnum() {
		return null == indConclusaoEscolaridade ? null : EnumSimNao.valueFromIndice(getIndConclusaoEscolaridade());
	}

	public EnumEstadoCivil getEstadoCivilAsEnum() {
		return null == estadoCivil ? null : EnumEstadoCivil.getEstadoCivilByIndice(estadoCivil.getId());
	}

	public EnumSexo getSexoAsEnum() {
		return EnumSexo.getSexoByIndice(getSexo());
	}

	public String getCpfFormatado() {
		return Utils.formataCpf(cpf);
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
		if (null == telefones) {
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

	public List<Documento> getDocumentos() {
		if (null == documentos) {
			documentos = new ArrayList<>();
		}
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailComercial() {
		return emailComercial;
	}

	public void setEmailComercial(String emailComercial) {
		this.emailComercial = emailComercial;
	}

}
