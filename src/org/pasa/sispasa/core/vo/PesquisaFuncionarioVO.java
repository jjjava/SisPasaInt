package org.pasa.sispasa.core.vo;

import org.pasa.sispasa.core.enumeration.EnumFiltroPesquisaFuncionario;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.util.Utils;

/**
 * VO que presenta os campos de pesquisa de funcionário na tela de incluir
 * associado.
 * 
 * @author Allan Garcia
 *
 */
public class PesquisaFuncionarioVO {

	public static final String LABEL_ABA_DADOS_PENSIONISTA = "Informações da Pensionista";
	public static final String LABEL_ABA_INFO_GERAIS = "Informações Gerais";
	public static final String LABEL_EMPRESA_TITULAR = "Empresa do Funcionário";
	public static final String LABEL_EMPRESA = "Empresa";

	private EnumFiltroPesquisaFuncionario enumFiltroPesquisaFuncionario = EnumFiltroPesquisaFuncionario.M_ORIGEM;
	private EnumTipoAssociado enumTipoAssociado = EnumTipoAssociado.A;

	private boolean bloquearFiltroPesquisaFuncionario = false;
	private String nrDocFuncionario;
	private String cpfTitularOrigem;
	private String cpfPensionista;
	private EmpresaVO empresaVO;

	private boolean exibirTabInfoGerais = Boolean.FALSE;

	private String labelAbaInfoGerais = LABEL_ABA_INFO_GERAIS;
	private String labelEmpresa = LABEL_EMPRESA;

	public boolean isTipoAssociadoPrePASA() {
		return null != enumTipoAssociado && EnumTipoAssociado.R.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoPensionista() {
		return null != enumTipoAssociado && EnumTipoAssociado.P.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoExEmpregado() {
		return null != enumTipoAssociado && EnumTipoAssociado.E.equals(enumTipoAssociado);
	}

	public String getCpfPensionistaSemMascara() {
		return Utils.desformataCpfCnpj(cpfPensionista);
	}

	public String getCpfSemMascara() {
		return Utils.desformataCpfCnpj(nrDocFuncionario);
	}

	public boolean isFiltroPesquisaFuncMatrOrigem() {
		return EnumFiltroPesquisaFuncionario.M_ORIGEM == enumFiltroPesquisaFuncionario;
	}

	public boolean isFiltroPesquisaFuncCPF() {
		return EnumFiltroPesquisaFuncionario.CPF == enumFiltroPesquisaFuncionario;
	}

	public EnumFiltroPesquisaFuncionario getEnumFiltroPesquisaFuncionario() {
		return enumFiltroPesquisaFuncionario;
	}

	public void setEnumFiltroPesquisaFuncionario(EnumFiltroPesquisaFuncionario enumFiltroPesquisaFuncionario) {
		this.enumFiltroPesquisaFuncionario = enumFiltroPesquisaFuncionario;
	}

	public EnumTipoAssociado getEnumTipoAssociado() {
		return enumTipoAssociado;
	}

	public void setEnumTipoAssociado(EnumTipoAssociado enumTipoAssociado) {
		this.enumTipoAssociado = enumTipoAssociado;
	}

	public String getNrDocFuncionario() {
		return nrDocFuncionario;
	}

	public void setNrDocFuncionario(String nrDocFuncionario) {
		this.nrDocFuncionario = nrDocFuncionario;
	}

	public boolean isExibirTabInfoGerais() {
		return exibirTabInfoGerais;
	}

	public void setExibirTabInfoGerais(boolean exibirTabInfoGerais) {
		this.exibirTabInfoGerais = exibirTabInfoGerais;
	}

	public EmpresaVO getEmpresaVO() {
		if (null == empresaVO) {
			empresaVO = new EmpresaVO();
		}
		return empresaVO;
	}

	public void setEmpresaVO(EmpresaVO empresaVO) {
		this.empresaVO = empresaVO;
	}

	public boolean isBloquearFiltroPesquisaFuncionario() {
		return bloquearFiltroPesquisaFuncionario;
	}

	public void setBloquearFiltroPesquisaFuncionario(boolean bloquearFiltroPesquisaFuncionario) {
		this.bloquearFiltroPesquisaFuncionario = bloquearFiltroPesquisaFuncionario;
	}

	public String getLabelEmpresa() {
		return labelEmpresa;
	}

	public void setLabelEmpresa(String labelEmpresa) {
		this.labelEmpresa = labelEmpresa;
	}

	public String getLabelAbaInfoGerais() {
		return labelAbaInfoGerais;
	}

	public void setLabelAbaInfoGerais(String labelAbaInfoGerais) {
		this.labelAbaInfoGerais = labelAbaInfoGerais;
	}

	public String getCpfPensionista() {
		return cpfPensionista;
	}

	public void setCpfPensionista(String cpfPensionista) {
		this.cpfPensionista = cpfPensionista;
	}

	public String getCpfTitularOrigem() {
		return cpfTitularOrigem;
	}

	public void setCpfTitularOrigem(String cpfTitularOrigem) {
		this.cpfTitularOrigem = cpfTitularOrigem;
	}

}