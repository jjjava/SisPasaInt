package org.pasa.sispasa.core.vo;

import org.pasa.sispasa.core.enumeration.EnumFiltroPesquisaFuncionario;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;

/**
 * VO que presenta os campos de pesquisa de funcionário na tela de incluir
 * associado.
 * 
 * @author Allan Garcia
 *
 */
public class PesquisaFuncionarioVO {

	private EnumFiltroPesquisaFuncionario enumFiltroPesquisaFuncionario = EnumFiltroPesquisaFuncionario.M_ORIGEM;
	private EnumTipoAssociado enumTipoAssociado = EnumTipoAssociado.A;

	private boolean bloquearFiltroPesquisaFuncionario = false;
	private EmpresaVO empresaVO;
	private String nrDocFuncionario;

	private boolean exibirTabInfoGerais = Boolean.FALSE;

	public boolean isTipoAssociadoPensionista() {
		return null != enumTipoAssociado && EnumTipoAssociado.P.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoExEmpregado() {
		return null != enumTipoAssociado && EnumTipoAssociado.E.equals(enumTipoAssociado);
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

}
