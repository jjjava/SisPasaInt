package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoEmpresa;
import org.pasa.sispasa.core.enumeration.EnumTipoIntegracao;

/**
 *
 * @author Andre Gomes
 */
public class EmpresaVO extends AtributosComunsVO{

	private String razaoSocial;
	private String nomeFantasia;
	private String cnpjFormatado;
	private Date dataInicio;
	private Date dataFim;
	private String codCNAE;
	private String email;
	private String site;
	private String codEmpresaVale;
	
	private EmpresaVO filtroRazaoSocial; 
	private EmpresaVO filtroNomeFantasia;
	
	private EnumTipoEmpresa enumTipoEmpresa;
	private EnumTipoIntegracao enumTipoIntegracao;
	
	private EnderecoVO endereco;
	
	private ContatoVO contato;
	private List<ContatoVO> contatos;
	
	private ContratoVO contrato;
	private List<ContratoVO> contratos;
	
	private ConvenioVO convenio;
	private List<ConvenioVO> convenios;

	
	//CONSTRUTORES
	
	public EmpresaVO(){
		//CONSTRUTOR DEFAULT
	}
	
	public EmpresaVO(Long id, String nomeFantasia, String razaoSocial){
		super.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
	}
	
	// GETTERS E SETTERS

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	public String getCodEmpresaVale() {
		return codEmpresaVale;
	}

	public void setCodEmpresaVale(String codEmpresaVale) {
		this.codEmpresaVale = codEmpresaVale;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
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

	/**
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @return the cnpjFormatado
	 */
	public String getCnpjFormatado() {
		return cnpjFormatado;
	}

	/**
	 * @param cnpjFormatado the cnpjFormatado to set
	 */
	public void setCnpjFormatado(String cnpjFormatado) {
		this.cnpjFormatado = cnpjFormatado;
	}

	/**
	 * @return the filtroRazaoSocial
	 */
	public EmpresaVO getFiltroRazaoSocial() {
		return filtroRazaoSocial;
	}

	/**
	 * @param filtroRazaoSocial the filtroRazaoSocial to set
	 */
	public void setFiltroRazaoSocial(EmpresaVO filtroRazaoSocial) {
		this.filtroRazaoSocial = filtroRazaoSocial;
	}

	/**
	 * @return the filtroNomeFantasia
	 */
	public EmpresaVO getFiltroNomeFantasia() {
		return filtroNomeFantasia;
	}

	/**
	 * @param filtroNomeFantasia the filtroNomeFantasia to set
	 */
	public void setFiltroNomeFantasia(EmpresaVO filtroNomeFantasia) {
		this.filtroNomeFantasia = filtroNomeFantasia;
	}

	/**
	 * @return the enumTipoEmpresa
	 */
	public EnumTipoEmpresa getEnumTipoEmpresa() {
		return enumTipoEmpresa;
	}

	/**
	 * @param enumTipoEmpresa the enumTipoEmpresa to set
	 */
	public void setEnumTipoEmpresa(EnumTipoEmpresa enumTipoEmpresa) {
		this.enumTipoEmpresa = enumTipoEmpresa;
	}

	/**
	 * @return the enumTipoIntegracao
	 */
	public EnumTipoIntegracao getEnumTipoIntegracao() {
		return enumTipoIntegracao;
	}

	/**
	 * @param enumTipoIntegracao the enumTipoIntegracao to set
	 */
	public void setEnumTipoIntegracao(EnumTipoIntegracao enumTipoIntegracao) {
		this.enumTipoIntegracao = enumTipoIntegracao;
	}

	/**
	 * @return the endereco
	 */
	public EnderecoVO getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public ContatoVO getContato() {
		return contato;
	}

	public void setContato(ContatoVO contato) {
		this.contato = contato;
	}

	public ContratoVO getContrato() {
		return contrato;
	}

	public void setContrato(ContratoVO contrato) {
		this.contrato = contrato;
	}

	public List<ContratoVO> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoVO> contratos) {
		this.contratos = contratos;
	}

	public ConvenioVO getConvenio() {
		return convenio;
	}

	public void setConvenio(ConvenioVO convenio) {
		this.convenio = convenio;
	}

	public List<ConvenioVO> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<ConvenioVO> convenios) {
		this.convenios = convenios;
	}

}
