package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NIVEL_ESCOLARIDADE")
public class NivelEscolaridade  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_NIVEL_ESCOL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DESCRICAO", length = 30 , nullable = false)
	private String descricao;
	
	@Column(name = "CD_EXTERNO" , length = 10)
	private String codExterno;
	
	public NivelEscolaridade(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodExterno() {
		return codExterno;
	}

	public void setCodExterno(String codExterno) {
		this.codExterno = codExterno;
	}
}
