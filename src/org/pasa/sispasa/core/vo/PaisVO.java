package org.pasa.sispasa.core.vo;

/**
 *
 * @author Andre Gomes
 */
public class PaisVO extends AtributosComunsVO{

	private String nome;

	public PaisVO(){
		//CONSTRUTOR DEFAULT
	}
	
	public PaisVO(Long id, String nome){
		super.id = id;
		this.nome = nome;
	}
	
	
	//GETTERS E SETTERS
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
