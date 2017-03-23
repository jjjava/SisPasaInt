package org.pasa.sispasa.core.enumeration;

/**
 * 
 * @author Andre Gomes
 *
 */
public enum EnumTipoTelefone {

	RESIDENCIAL(1L,"Residencial"),
	COMERCIAL(2L,"Comercial"),
	CELULAR(3L,"Celular");
	
	private final Long id;
	private final String descricao;
	
	EnumTipoTelefone(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumTipoTelefone getTipoTelefoneByIndice(int indice){
		
		switch (indice) {
			
			case 1:
				return EnumTipoTelefone.RESIDENCIAL;
				
			case 2:
				return EnumTipoTelefone.COMERCIAL;
			
			case 3:
				return EnumTipoTelefone.CELULAR;

			default:
				break;
		}
		
		return null;
	}
	
	//GETTERS E SETTERS 
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
}