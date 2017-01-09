package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.pasa.sispasa.core.enumeration.EnumFiltroPesquisaFuncionario;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;

public class PesquisaAssociadoVO {

	Collection<AssociadoVO> listaAssociadoVO;

	private EnumFiltroPesquisaFuncionario enumFiltroPesquisaFuncionario = EnumFiltroPesquisaFuncionario.M_ORIGEM;
	private EnumTipoAssociado enumTipoAssociado;

	private EmpresaVO empresaVO;
	private String nrDocFuncionario;
	private boolean exibirGridResultado;
	private String nome;

	public boolean isFiltroPesquisaMatrOrigem() {
		return EnumFiltroPesquisaFuncionario.M_ORIGEM.equals(enumFiltroPesquisaFuncionario);
	}

	public boolean isFiltroPesquisaMatrPASA() {
		return EnumFiltroPesquisaFuncionario.M_PASA.equals(enumFiltroPesquisaFuncionario);
	}

	public boolean isFiltroPesquisaCPF() {
		return EnumFiltroPesquisaFuncionario.CPF.equals(enumFiltroPesquisaFuncionario);
	}

	public EnumTipoAssociado getEnumTipoAssociado() {
		return enumTipoAssociado;
	}

	public void setEnumTipoAssociado(EnumTipoAssociado enumTipoAssociado) {
		this.enumTipoAssociado = enumTipoAssociado;
	}

	public EnumFiltroPesquisaFuncionario getEnumFiltroPesquisaFuncionario() {
		return enumFiltroPesquisaFuncionario;
	}

	public void setEnumFiltroPesquisaFuncionario(EnumFiltroPesquisaFuncionario enumFiltroPesquisaFuncionario) {
		this.enumFiltroPesquisaFuncionario = enumFiltroPesquisaFuncionario;
	}

	public String getNomeFormatado() {
		return "%" + nome.trim().toLowerCase() + "%";	
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

	public String getNrDocFuncionario() {
		return nrDocFuncionario;
	}

	public void setNrDocFuncionario(String nrDocFuncionario) {
		this.nrDocFuncionario = nrDocFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<AssociadoVO> getListaAssociadoVO() {
		if (null == listaAssociadoVO) {
			listaAssociadoVO = new ArrayList<>();
		}
		return listaAssociadoVO;
	}

	public void setListaAssociadoVO(Collection<AssociadoVO> listaAssociadoVO) {
		this.listaAssociadoVO = listaAssociadoVO;
	}

	public boolean isExibirGridResultado() {
		return exibirGridResultado;
	}

	public void setExibirGridResultado(boolean exibirGridResultado) {
		this.exibirGridResultado = exibirGridResultado;
	}

}
