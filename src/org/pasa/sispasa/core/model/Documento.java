package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "DOCUMENTO")
public class Documento extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_DOCUMENTO", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMERO", nullable = false, length = 20)
	private String numero;

	@Column(name = "ORGAO_EMISSOR", length = 30)
	private String orgaoEmissor;

	@Column(name = "SERIE", length = 10)
	private String serie;

	@Column(name = "DATA_EMISSAO", columnDefinition = ConstantesBanco.DATE)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@Column(name = "DATA_VALIDADE", columnDefinition = ConstantesBanco.DATE)
	@Temporal(TemporalType.DATE)
	private Date dataValidade;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;
	
	@Column(name = "DT_ULT_ATULZ", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	 @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	 private Integer indAtivo;

	@ManyToOne()
	@JoinColumn(name = "ID_ESTADO")
	private Estado estado;

	@ManyToOne()
	@JoinColumn(name = "ID_TP_DOCUMENTO")
	private TipoDocumento tipoDocumento;
	
    @ManyToMany(mappedBy = "documentos", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Pessoa> pessoa;


	
	//GETTERS E SETTERS
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie
	 *            the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the dataUltimaAtualizacao
	 */
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	/**
	 * @param dataUltimaAtualizacao the dataUltimaAtualizacao to set
	 */
	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	/**
	 * @return the indAtivo
	 */
	public Integer getIndAtivo() {
		return indAtivo;
	}

	/**
	 * @param indAtivo the indAtivo to set
	 */
	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}

	/**
	 * @return the pessoa
	 */
	public Set<Pessoa> getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Set<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}


}
