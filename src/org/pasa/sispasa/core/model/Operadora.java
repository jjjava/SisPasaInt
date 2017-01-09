package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "OPERADORA")
@Audited
@AuditTable(value="HIST_OPERADORA")
public class Operadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_OPERADORA", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 30)
	private String nome;

	@Column(name = "REGISTRO_AMS", length = 30)
	private String registroANS;

	@Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
	private Integer indAtivo;

	@Column(name = "DT_ULT_ATULZ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	//CONSTRUTORES
	
	public Operadora() {
		//CONSTRUTOR DEFAULT
	}
	
	public Operadora(Long id) {
		this.id = id;
	}

	//GETTERS E SETTERS
	
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

	public String getRegistroANS() {
		return registroANS;
	}

	public void setRegistroANS(String registroANS) {
		this.registroANS = registroANS;
	}

	public Integer getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}

	public Date getDataUltAtulizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltAtulizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
}