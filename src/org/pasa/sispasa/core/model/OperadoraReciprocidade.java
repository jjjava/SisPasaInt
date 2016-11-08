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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OPERADORA_RECIPROCIDADE")
public class OperadoraReciprocidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_OPERADORA_RCP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "RZ_SOCIAL", length = 60, nullable = false)
	private String razaoSocial;

	@Column(name = "NM_FANTASIA", length = 60, nullable = false)
	private String nomeFantasia;

	@Column(name = "CNPJ", length = 14, nullable = false)
	private String cnpj;

	@Column(name = "DT_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "CD_CNAE", length = 7)
	private String codCNAE;

	@Column(name = "EMAIL", length = 60)
	private String email;

	@Column(name = "SITE", length = 60)
	private String site;

	@Column(name = "ID_USUARIO", nullable = false)
	private Long idUsuario;

	@Column(name = "IND_ATIVO", length = 1, nullable = false)
	private Integer indAtivo;

	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataUltAtulizacao;
	
	@ManyToMany
	@JoinTable(name = "OPERADORA_RECIPROCIDADE_CONTATO",
	joinColumns = @JoinColumn(name = "ID_OPERADORA_RCP"), 
	inverseJoinColumns = @JoinColumn(name = "ID_CONTATO"))
	private List<Contato> contatos;
	
	public OperadoraReciprocidade(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getCodCNAE() {
		return codCNAE;
	}

	public void setCodCNAE(String codCNAE) {
		this.codCNAE = codCNAE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
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

	public Date getDataUltAtulizacao() {
		return dataUltAtulizacao;
	}

	public void setDataUltAtulizacao(Date dataUltAtulizacao) {
		this.dataUltAtulizacao = dataUltAtulizacao;
	}
}