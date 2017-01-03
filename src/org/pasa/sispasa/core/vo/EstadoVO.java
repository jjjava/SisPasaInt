package org.pasa.sispasa.core.vo;

/**
 *
 * Andre Gomes
 */
public class EstadoVO extends AtributosComunsVO{

	private String idEstado;
	private String nome;
	private PaisVO pais;

	public EstadoVO(){
		//CONSTRUTOR DEFAULT
	}
	
	public EstadoVO(String idEstado, String nome){
		this.idEstado = idEstado;
		this.nome = nome;
	}
	
	
	//GETTERS E SETTERS
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PaisVO getPais() {
		return pais;
	}

	public void setPais(PaisVO pais) {
		this.pais = pais;
	}

	/**
	 * @return the idEstado
	 */
	public String getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
}
