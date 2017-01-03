package org.pasa.sispasa.core.enumeration;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Allan Garcia
 */
public enum EnumFiltroPesquisaFuncionario {

	M_ORIGEM("Mátricula Origem"), 
	M_PASA("Mátricula PASA"), 
	CPF("CPF");

	private String descricao;

	private EnumFiltroPesquisaFuncionario(String descricao) {
		this.descricao = descricao;
	}

	public static EnumFiltroPesquisaFuncionario[] valuesSemPASA() {

		Collection<EnumFiltroPesquisaFuncionario> lista = new ArrayList<EnumFiltroPesquisaFuncionario>();

		for (EnumFiltroPesquisaFuncionario enumFiltro : EnumFiltroPesquisaFuncionario.values()) {
			if (!enumFiltro.equals(EnumFiltroPesquisaFuncionario.M_PASA)) {
				lista.add(enumFiltro);
			}
		}
		EnumFiltroPesquisaFuncionario[] array = new EnumFiltroPesquisaFuncionario[2];
		array = lista.toArray(array);
		return array;
	}

	public String getDescricao() {
		return descricao;
	}
}
