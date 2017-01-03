package org.pasa.sispasa.core.vo;

import java.util.Date;

/**
 *
 * @author Andre Gomes
 */
public class OperadoraVO extends AtributosComunsVO{


	private String nome;
	private String registroANS;

	//CONSTRUTORES
	
	public OperadoraVO(){
		//CONSTRUTOR DEFAULT
	}
	
	//GETTERS AND SETTERS
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegistroANS() {
		return registroANS;
	}

	public void setRegistroANS(String registroANS) {
		this.registroANS = registroANS;
	}

	public Date getDataUltAtulizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltAtulizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
}
