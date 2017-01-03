package org.pasa.sispasa.core.vo;

/**
 *
 * @author  Andre Gomes
 */
public class TipoEmpresaVO extends AtributosComunsVO{

	private String descricao;

	
	public TipoEmpresaVO(){
		//CONSTRUTOR DEFAULT
	}
	
	public TipoEmpresaVO(Long id, String descricao){
		super.id = id;
		this.descricao = descricao;
	}
	
	//GETTERS E SETTERS
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
