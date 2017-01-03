package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Andre Gomes
 */
public class OperadoraReciprocidadeVO extends AtributosComunsVO{


	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private Date dataInicio;
	private Date dataFim;
	private String codCNAE;
	private String email;
	private String site;

	private List<ContatoVO> contatos;


	
	//GETTERS E SETTERS
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getCodCNAE() {
		return codCNAE;
	}

	public void setCodCNAE(String codCNAE) {
		this.codCNAE = codCNAE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the contatos
	 */
	public List<ContatoVO> getContatos() {
		return contatos;
	}

	/**
	 * @param contatos the contatos to set
	 */
	public void setContatos(List<ContatoVO> contatos) {
		this.contatos = contatos;
	}
}
