package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumIndAtivo;

/**
 * @author Andre Gomes
 */
public class AtributosComunsVO {
	
	protected Long id;
	protected EnumIndAtivo enumIndAtivo = EnumIndAtivo.ATIVO;
	protected Date dataUltimaAtualizacao;
	protected Long idUsuario;
	protected String nomeUsuario;
	
	
	//GETTERS AND SETTERS
	
	/**
	 * @return the enumIndAtivo
	 */
	public EnumIndAtivo getEnumIndAtivo() {
		return enumIndAtivo;
	}
	/**
	 * @param enumIndAtivo the enumIndAtivo to set
	 */
	public void setEnumIndAtivo(EnumIndAtivo enumIndAtivo) {
		this.enumIndAtivo = enumIndAtivo;
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	

}
