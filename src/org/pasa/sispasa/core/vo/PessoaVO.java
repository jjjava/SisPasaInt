package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumEstadoCivil;
import org.pasa.sispasa.core.enumeration.EnumNivelEscolaridade;
import org.pasa.sispasa.core.enumeration.EnumOrigemInformacoes;
import org.pasa.sispasa.core.enumeration.EnumSexo;
import org.pasa.sispasa.core.util.Utils;

/**
 * @author andre
 *
 */
public class PessoaVO extends AtributosComunsVO  {

	private Date dataUltimaAtualizacao;
	private String cpfFormatado;
	private String nome;
	private Date dataNascimento;
	private Date dataInclusaoSistema;
	private String nomeMae;
	private String nomePai;
	private String email;
	private Integer indConclusaoEscolaridade;

	private PaisVO nacionalidade;
	private EstadoVO naturalidade;
	private MunicipioVO cidadeOrigem;

	private EnumSexo enumSexo;
	private EnumNivelEscolaridade enumNivelEscolaridade;
	private EnumOrigemInformacoes enumOrigemInformacoes;
	private EnumEstadoCivil enumEstadoCivil;

	public String getDataNascimentoFormatada() {
		return Utils.formatarData(dataNascimento, "dd/MM/yyyy");
	}

	/**
	 * @return the dataUltimaAtualizacao
	 */
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	/**
	 * @param dataUltimaAtualizacao
	 *            the dataUltimaAtualizacao to set
	 */
	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	/**
	 * @return the cpfFormatado
	 */
	public String getCpfFormatado() {
		return cpfFormatado;
	}

	/**
	 * @param cpfFormatado
	 *            the cpfFormatado to set
	 */
	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the dataInclusaoSistema
	 */
	public Date getDataInclusaoSistema() {
		return dataInclusaoSistema;
	}

	/**
	 * @param dataInclusaoSistema
	 *            the dataInclusaoSistema to set
	 */
	public void setDataInclusaoSistema(Date dataInclusaoSistema) {
		this.dataInclusaoSistema = dataInclusaoSistema;
	}

	/**
	 * @return the enumSexo
	 */
	public EnumSexo getEnumSexo() {
		return enumSexo;
	}

	/**
	 * @param enumSexo
	 *            the enumSexo to set
	 */
	public void setEnumSexo(EnumSexo enumSexo) {
		this.enumSexo = enumSexo;
	}

	/**
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae
	 *            the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return the nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai
	 *            the nomePai to set
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the indConclusaoEscolaridade
	 */
	public Integer getIndConclusaoEscolaridade() {
		return indConclusaoEscolaridade;
	}

	/**
	 * @param indConclusaoEscolaridade
	 *            the indConclusaoEscolaridade to set
	 */
	public void setIndConclusaoEscolaridade(Integer indConclusaoEscolaridade) {
		this.indConclusaoEscolaridade = indConclusaoEscolaridade;
	}

	/**
	 * @return the enumNivelEscolaridade
	 */
	public EnumNivelEscolaridade getEnumNivelEscolaridade() {
		return enumNivelEscolaridade;
	}

	/**
	 * @param enumNivelEscolaridade
	 *            the enumNivelEscolaridade to set
	 */
	public void setEnumNivelEscolaridade(EnumNivelEscolaridade enumNivelEscolaridade) {
		this.enumNivelEscolaridade = enumNivelEscolaridade;
	}

	/**
	 * @return the enumOrigemInformacoes
	 */
	public EnumOrigemInformacoes getEnumOrigemInformacoes() {
		return enumOrigemInformacoes;
	}

	/**
	 * @param enumOrigemInformacoes
	 *            the enumOrigemInformacoes to set
	 */
	public void setEnumOrigemInformacoes(EnumOrigemInformacoes enumOrigemInformacoes) {
		this.enumOrigemInformacoes = enumOrigemInformacoes;
	}

	/**
	 * @return the enumEstadoCivil
	 */
	public EnumEstadoCivil getEnumEstadoCivil() {
		return enumEstadoCivil;
	}

	/**
	 * @param enumEstadoCivil
	 *            the enumEstadoCivil to set
	 */
	public void setEnumEstadoCivil(EnumEstadoCivil enumEstadoCivil) {
		this.enumEstadoCivil = enumEstadoCivil;
	}

	/**
	 * @return the nacionalidade
	 */
	public PaisVO getNacionalidade() {
		if (null == nacionalidade) {
			nacionalidade = new PaisVO();
		}
		return nacionalidade;
	}

	/**
	 * @param nacionalidade
	 *            the nacionalidade to set
	 */
	public void setNacionalidade(PaisVO nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	/**
	 * @return the naturalidade
	 */
	public EstadoVO getNaturalidade() {
		if (null == naturalidade) {
			naturalidade = new EstadoVO();
		}
		return naturalidade;
	}

	/**
	 * @param naturalidade
	 *            the naturalidade to set
	 */
	public void setNaturalidade(EstadoVO naturalidade) {
		this.naturalidade = naturalidade;
	}

	/**
	 * @return the cidadeOrigem
	 */
	public MunicipioVO getCidadeOrigem() {
		if (null == cidadeOrigem) {
			cidadeOrigem = new MunicipioVO();
		}
		return cidadeOrigem;
	}

	/**
	 * @param cidadeOrigem
	 *            the cidadeOrigem to set
	 */
	public void setCidadeOrigem(MunicipioVO cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
}