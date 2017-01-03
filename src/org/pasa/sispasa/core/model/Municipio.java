package org.pasa.sispasa.core.model;

import java.io.Serializable;

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
@Table(name = "MUNICIPIO")
@Audited
@AuditTable(value="HIST_MUNICIPIO")
public class Municipio extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_MUNICIPIO", columnDefinition = ConstantesBanco.BIGINT)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;

	//RELACIONAMENTOS
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	@NotAudited
	private Estado estado;

	//CONSTRUTORES
	
	public Municipio(){
		//CONSTRUTOR DEFAULT
	}
	
	public Municipio(Long id){
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
