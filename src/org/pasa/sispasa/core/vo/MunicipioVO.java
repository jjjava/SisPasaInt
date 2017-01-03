package org.pasa.sispasa.core.vo;

/**
 *
 * @author Andre Gomes
 */
public class MunicipioVO extends AtributosComunsVO{


	private String nome;
	private EstadoVO estado;

	public MunicipioVO(){
		//CONSTRUTOR DEFAULT
	}
	
	public MunicipioVO(Long id, String nome){
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

	/**
	 * @return the estado
	 */
	public EstadoVO getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoVO estado) {
		this.estado = estado;
	}

}