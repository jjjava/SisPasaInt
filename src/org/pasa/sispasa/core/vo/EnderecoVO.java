package org.pasa.sispasa.core.vo;

/**
 * @author Andre Gomes
 */
public class EnderecoVO extends AtributosComunsVO {

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private MunicipioVO municipio;
	private EstadoVO estado;
	
	private String regiaoSaude;
	
	private NucleoVo nucleoVo;
	
	private boolean exibirNucleoRegiao;

	// GETTERS E SETTERS

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public EstadoVO getEstado() {
		if (null == estado) {
			estado = new EstadoVO();
		}
		return estado;
	}

	public void setEstado(EstadoVO estado) {
		this.estado = estado;
	}

	/**
	 * @return the municipio
	 */
	public MunicipioVO getMunicipio() {
		if (null == municipio) {
			municipio = new MunicipioVO();
		}
		return municipio;
	}

	/**
	 * @param municipio
	 *            the municipio to set
	 */
	public void setMunicipio(MunicipioVO municipio) {
		this.municipio = municipio;
	}

	public String getRegiaoSaude() {
		return regiaoSaude;
	}

	public void setRegiaoSaude(String regiaoSaude) {
		this.regiaoSaude = regiaoSaude;
	}

	public NucleoVo getNucleoVo() {
		if (null == nucleoVo) {
			nucleoVo = new NucleoVo();
		}
		return nucleoVo;
	}

	public void setNucleoVo(NucleoVo nucleoVo) {
		this.nucleoVo = nucleoVo;
	}

	public boolean isExibirNucleoRegiao() {
		return exibirNucleoRegiao;
	}

	public void setExibirNucleoRegiao(boolean exibirNucleoRegiao) {
		this.exibirNucleoRegiao = exibirNucleoRegiao;
	}
}