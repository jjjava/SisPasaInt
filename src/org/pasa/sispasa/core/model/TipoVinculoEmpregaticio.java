package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
*
* @author Hudson Schumaker / André Gomes
* @version 1.0.0
*/
@Entity
@Table(name = "TIPO_VINCULO_EMPREGATICIO")
public class TipoVinculoEmpregaticio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TP_VINC_EMPREG", columnDefinition = ConstantesBanco.BIGINT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRICAO", length = 60)
	private String descricao;

	@Column(name = "CD_EXTERNO", columnDefinition = ConstantesBanco.CHAR_1)
	private String codExterno;
	
	//GETTERS E SETTERS
	
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
