package org.pasa.sispasa.core.vo;

/**
 * Classe resposnsavel por conter os dados para apresentação na grid de histórico
 * de planos por empresa na tela de beneficiarios. 
 * @author Andre Gomes
 */
public class HistoricoPlanoVO {

	EmpresaVO empresa;
	PlanoVO plano;
	
	
	//GETTERS E SETTERS
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EmpresaVO empresa) {
		this.empresa = empresa;
	}
	/**
	 * @param plano the plano to set
	 */
	public void setPlano(PlanoVO plano) {
		this.plano = plano;
	}
	/**
	 * @return the empresa
	 */
	public EmpresaVO getEmpresa() {
		return empresa;
	}
	/**
	 * @return the plano
	 */
	public PlanoVO getPlano() {
		return plano;
	}
	
	
	
}
