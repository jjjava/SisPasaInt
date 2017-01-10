package org.pasa.sispasa.core.vo;

import java.util.Date;

/**
 * Classe resposnsavel por conter os dados para apresentação na grid de histórico
 * de planos por empresa na tela de beneficiarios. 
 * @author Andre Gomes
 */
public class HistoricoPlanoVO {

	private String nomeEmpresa;
	private String nomePlano;
	private Date dataInicioVigenciaPlano;
	
	
	
	//GETTERS E SETTERS

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public Date getDataInicioVigenciaPlano() {
		return dataInicioVigenciaPlano;
	}
	public void setDataInicioVigenciaPlano(Date dataInicioVigenciaPlano) {
		this.dataInicioVigenciaPlano = dataInicioVigenciaPlano;
	}
	
	
	
}
