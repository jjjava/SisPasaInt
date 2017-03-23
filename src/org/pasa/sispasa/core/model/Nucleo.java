package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "NUCLEO")
@Audited
@AuditTable(value = "HIST_NUCLEO")
public class Nucleo implements Serializable{

	private static final long serialVersionUID = -5722315282383336785L;

    @Id
    @Column(name = "COD_NUCLEO", columnDefinition = ConstantesBanco.CHAR_2)
	private String codNucleo;
	
    @Column(name="NOME", length=60)
	private String nome;
	
    @Column(name="DESCRICAO",  length=100)
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name = "ID_REGIONAL")
	private Regional regional;
	
	 @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

	public String getCodNucleo() {
		return codNucleo;
	}

	public void setCodNucleo(String codNucleo) {
		this.codNucleo = codNucleo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codNucleo == null) ? 0 : codNucleo.hashCode());
		result = prime * result + ((regional == null) ? 0 : regional.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nucleo other = (Nucleo) obj;
		if (codNucleo == null) {
			if (other.codNucleo != null)
				return false;
		} else if (!codNucleo.equals(other.codNucleo))
			return false;
		if (regional == null) {
			if (other.regional != null)
				return false;
		} else if (!regional.equals(other.regional))
			return false;
		return true;
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

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
	
	
}
