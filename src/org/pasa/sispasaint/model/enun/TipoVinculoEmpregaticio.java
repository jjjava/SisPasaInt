package org.pasa.sispasa.core.enumeration;

/**
*
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum TipoVinculoEmpregaticio {
	
	Estagiario(0,"Estagiário"),
	MenorAprendiz(1,"Menor aprendiz"),
	TrabalahdorTemporario(2,"Trabalahdor temporario"),
	EmpregadoAtivo(3,"Empregado ativo"),
	Aposentado(4,"Aposentado"),
	Pensionista(5,"Pensionista"),
	ExEmpregado(6,"Ex-Empregado");
	
	private int indice;
	private String descricao;
	
	private TipoVinculoEmpregaticio(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}