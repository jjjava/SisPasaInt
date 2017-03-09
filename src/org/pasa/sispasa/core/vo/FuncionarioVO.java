package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;
import org.pasa.sispasa.core.util.Utils;

/**
 * Classe responsável por representar os dados de Funcionario, espelhados na
 * entidade de mesmo nome, porem com coisas peculiaridades da view desta
 * funcionalidade
 * 
 * @author Andre Gomes
 *
 */
public class FuncionarioVO extends AtributosComunsVO {

	private EnumMotivoDesligamento enumMotivoDesligamento;
	private List<BeneficiarioVO> beneficiarios;

	private DadosBancariosVO dadosBancarios;
	private TelefoneVO telefoneResidencial;
	private TelefoneVO telefoneComercial;
	private TelefoneVO telefoneCelular;
	private EnderecoVO endereco;
	private EmpresaVO empresa;
	private PessoaVO pessoa;

	private DocumentoVO pisPasep;
	private DocumentoVO ctps;
	private DocumentoVO rg;

	private String telefoneSecundarioCarga;
	private String telefonePrimarioCarga;
	private String emailCorporativo;
	private String matriculaOrigem;
	private Date dataDesligamento;
	private Date dataAdmissao;

	public String getTelefoneResidencialFormatado() {
		return null == telefoneResidencial ? null
				: Utils.formataTelefone(telefoneResidencial.getNumeroTelefoneComDDD());
	}

	public String getTelefoneCelularFormatado() {
		return null == telefoneCelular ? null : Utils.formataTelefone(telefoneCelular.getNumeroTelefoneComDDD());
	}

	/**
	 * @return the matriculaOrigem
	 */
	public String getMatriculaOrigem() {
		return matriculaOrigem;
	}

	/**
	 * @param matriculaOrigem
	 *            the matriculaOrigem to set
	 */
	public void setMatriculaOrigem(String matriculaOrigem) {
		this.matriculaOrigem = matriculaOrigem;
	}

	/**
	 * @return the dataAdmissao
	 */
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	/**
	 * @param dataAdmissao
	 *            the dataAdmissao to set
	 */
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	/**
	 * @return the dataDesligamento
	 */
	public Date getDataDesligamento() {
		return dataDesligamento;
	}

	/**
	 * @param dataDesligamento
	 *            the dataDesligamento to set
	 */
	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	/**
	 * @return the emailCorporativo
	 */
	public String getEmailCorporativo() {
		return emailCorporativo;
	}

	/**
	 * @param emailCorporativo
	 *            the emailCorporativo to set
	 */
	public void setEmailCorporativo(String emailCorporativo) {
		this.emailCorporativo = emailCorporativo;
	}

	/**
	 * @return the dadosBancarios
	 */
	public DadosBancariosVO getDadosBancarios() {
		return dadosBancarios;
	}

	/**
	 * @param dadosBancarios
	 *            the dadosBancarios to set
	 */
	public void setDadosBancarios(DadosBancariosVO dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	/**
	 * @return the enumMotivoDesligamento
	 */
	public EnumMotivoDesligamento getEnumMotivoDesligamento() {
		return enumMotivoDesligamento;
	}

	/**
	 * @param enumMotivoDesligamento
	 *            the enumMotivoDesligamento to set
	 */
	public void setEnumMotivoDesligamento(EnumMotivoDesligamento enumMotivoDesligamento) {
		this.enumMotivoDesligamento = enumMotivoDesligamento;
	}

	/**
	 * @return the empresa
	 */
	public EmpresaVO getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(EmpresaVO empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the endereco
	 */
	public EnderecoVO getEndereco() {
		if (null == endereco) {
			endereco = new EnderecoVO();
		}
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefoneResidencial
	 */
	public TelefoneVO getTelefoneResidencial() {
		if (null == telefoneResidencial) {
			telefoneResidencial = new TelefoneVO();
		}
		return telefoneResidencial;
	}

	/**
	 * @param telefoneResidencial
	 *            the telefoneResidencial to set
	 */
	public void setTelefoneResidencial(TelefoneVO telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	/**
	 * @return the telefoneCelular
	 */
	public TelefoneVO getTelefoneCelular() {
		if (null == telefoneCelular) {
			telefoneCelular = new TelefoneVO();
		}
		return telefoneCelular;
	}

	/**
	 * @param telefoneCelular
	 *            the telefoneCelular to set
	 */
	public void setTelefoneCelular(TelefoneVO telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	/**
	 * @return the telefoneComercial
	 */
	public TelefoneVO getTelefoneComercial() {
		if (null == telefoneComercial) {
			telefoneComercial = new TelefoneVO();
		}
		return telefoneComercial;
	}

	/**
	 * @param telefoneComercial
	 *            the telefoneComercial to set
	 */
	public void setTelefoneComercial(TelefoneVO telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	/**
	 * @return the rg
	 */
	public DocumentoVO getRg() {
		if (null == rg) {
			rg = new DocumentoVO();
		}
		return rg;
	}

	/**
	 * @param rg
	 *            the rg to set
	 */
	public void setRg(DocumentoVO rg) {
		this.rg = rg;
	}

	/**
	 * @return the ctps
	 */
	public DocumentoVO getCtps() {
		if (null == ctps) {
			ctps = new DocumentoVO();
		}
		return ctps;
	}

	/**
	 * @param ctps
	 *            the ctps to set
	 */
	public void setCtps(DocumentoVO ctps) {
		this.ctps = ctps;
	}

	/**
	 * @return the pisPasep
	 */
	public DocumentoVO getPisPasep() {
		if (null == pisPasep) {
			pisPasep = new DocumentoVO();
		}
		return pisPasep;
	}

	/**
	 * @param pisPasep
	 *            the pisPasep to set
	 */
	public void setPisPasep(DocumentoVO pisPasep) {
		this.pisPasep = pisPasep;
	}

	/**
	 * @return the beneficiarios
	 */
	public List<BeneficiarioVO> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * @param beneficiarios
	 *            the beneficiarios to set
	 */
	public void setBeneficiarios(List<BeneficiarioVO> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getTelefonePrimarioCarga() {
		return telefonePrimarioCarga;
	}

	public void setTelefonePrimarioCarga(String telefonePrimarioCarga) {
		this.telefonePrimarioCarga = telefonePrimarioCarga;
	}

	public String getTelefoneSecundarioCarga() {
		return telefoneSecundarioCarga;
	}

	public void setTelefoneSecundarioCarga(String telefoneSecundarioCarga) {
		this.telefoneSecundarioCarga = telefoneSecundarioCarga;
	}

	public PessoaVO getPessoa() {
		if (null == pessoa) {
			pessoa = new PessoaVO();
		}
		return pessoa;
	}

	public void setPessoa(PessoaVO pessoa) {
		this.pessoa = pessoa;
	}
}
