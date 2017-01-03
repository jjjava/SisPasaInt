package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;

/**
 *
 * @author Andre Gomes
 */
public class DocumentoVO extends AtributosComunsVO {

	private String numero;
	private String orgaoEmissor;
	private EstadoVO estadoEmissor;
	private Date dataEmissao;
	private Date dataValidade;
	private String serie;
	private EnumTipoDocumento enumTipoDocumento;

	// GETTERS E SETTERS

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
	 * @return the enumTipoDocumento
	 */
	public EnumTipoDocumento getEnumTipoDocumento() {
		return enumTipoDocumento;
	}

	/**
	 * @param enumTipoDocumento
	 *            the enumTipoDocumento to set
	 */
	public void setEnumTipoDocumento(EnumTipoDocumento enumTipoDocumento) {
		this.enumTipoDocumento = enumTipoDocumento;
	}

	/**
	 * @return the estadoEmissor
	 */
	public EstadoVO getEstadoEmissor() {
		return estadoEmissor;
	}

	/**
	 * @param estadoEmissor
	 *            the estadoEmissor to set
	 */
	public void setEstadoEmissor(EstadoVO estadoEmissor) {
		this.estadoEmissor = estadoEmissor;
	}
}