package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ESTADO", length = 2)
	private String id;

	@Column(name = "NOME", length = 30, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;
	
	public Estado() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//@Basic(fetch = FetchType.LAZY)
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}