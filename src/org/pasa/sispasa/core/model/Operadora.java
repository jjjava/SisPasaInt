package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "OPERADORA")
public class Operadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_OPERADORA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME", length = 30, nullable = false)
	private String nome;

	@Column(name = "REGISTRO_AMS")
	private String registroANS;

	@Column(name = "IND_ATIVO", nullable = false)
	private Integer indAtivo;
	
	@Column(name = "DT_ULT_ATULZ")
	private Date dataUltAtulizacao;

	public Operadora() {
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
		return dataUltAtulizacao;
	}

	public void setDataUltAtulizacao(Date dataUltAtulizacao) {
		this.dataUltAtulizacao = dataUltAtulizacao;
	}
}