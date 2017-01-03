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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "EMPRESA")
@Audited
@AuditTable(value="HIST_EMPRESA")
public class Empresa extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_EMPRESA", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "RZ_SOCIAL", length = 60)
	private String razaoSocial;

	@Column(name = "NM_FANTASIA", length = 60)
	private String nomeFantasia;

	@Column(name = "CNPJ", columnDefinition = ConstantesBanco.CHAR_14)
	private String cnpj;

	@Column(name = "DT_INICIO", nullable = false, columnDefinition = ConstantesBanco.DATE)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DT_FIM", columnDefinition = ConstantesBanco.DATE)
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "CD_CNAE", columnDefinition = ConstantesBanco.CHAR_7)
	private String codCNAE;

	@Column(name = "EMAIL", length = 60)
	private String email;
	
	@Column(name = "SITE", length=60)
	private String site;

	@Column(name = "CD_EMPRESA_VALE", length = 3)
	private String codEmpresaVale;

	@Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indAtivo;

	@Column(name = "ID_USUARIO", columnDefinition = ConstantesBanco.BIGINT)
	private Long idUsuario;

	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;

	//RELACIONAMENTOS
	
	@ManyToOne
	@JoinColumn(name = "ID_TP_EMPRESA")
	@NotAudited
	private TipoEmpresa tipoEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "ID_TP_INTEGRACAO")
	@NotAudited
	private TipoIntegracao tipoIntegracao;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ENDERECO_EMPRESA", 
	joinColumns = @JoinColumn(name = "ID_EMPRESA"), 
	inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
	@NotAudited
	private List<Endereco> enderecos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTATO_EMPRESA",
	joinColumns = @JoinColumn(name = "ID_EMPRESA"),
	inverseJoinColumns = @JoinColumn(name = "ID_CONTATO"))
	@NotAudited
	private	List<Contato> contatos;
	
	@OneToMany
	@JoinColumn(name = "ID_CONTRATO")
	@NotAudited
	private	List<Contrato> contratos;
	
	
	//CONSTRUTORES
	
	public Empresa(Long id){
		this.id = id;
	}
	
	public Empresa(Long id, String nomeFantasia){
		this.id = id;
		this.nomeFantasia = nomeFantasia;
	}

	public Empresa() {
		enderecos = new ArrayList<>();
		contatos = new ArrayList<>();
	}

	
	//MÉTODOS ADD
	
	public void addEndereco(Endereco e) {
		enderecos.add(e);
	}

	public void addContato(Contato c) {
		contatos.add(c);
	}

	// GETTERS E SETTERS

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

	public String getCodEmpresaVale() {
		return codEmpresaVale;
	}

	public void setCodEmpresaVale(String codEmpresaVale) {
		this.codEmpresaVale = codEmpresaVale;
	}

	public Integer getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
		

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the tipoIntegracao
	 */
	public TipoIntegracao getTipoIntegracao() {
		return tipoIntegracao;
	}

	public void setTipoIntegracao(TipoIntegracao tipoIntegracao) {
		this.tipoIntegracao = tipoIntegracao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
}
