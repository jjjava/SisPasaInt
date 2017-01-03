package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "ESTADO")
@Audited
@AuditTable(value="HIST_ESTADO")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ESTADO", columnDefinition = ConstantesBanco.CHAR_2)
	private String id;

	@Column(name = "NOME", length = 30)
	private String nome;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PAIS")
	@NotAudited
	private Pais pais;

	//CONSTRUTORES
	
	public Estado(){
		//CONSTRUTOR DEFAULT
	}
	
	public Estado(String id){
		this.id = id;
	}
	
	//GETTERS E SETTERS
	
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
