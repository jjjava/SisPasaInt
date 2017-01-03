package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */

public enum EnumTipoIntegracao {

	PEOPLE_SOFT_VALE(1L,"People Soft Vale"),
	PEOPLE_SOFT_VLI(2L,"People Soft VLI"),
	EXTERNA(3L,"Empresa externa");
	
	
	private Long indice;
	private String descricao;
	
	private EnumTipoIntegracao(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	
	/**
	 * @param indice
	 * @return
	 */
	public static EnumTipoIntegracao getTipoIntegracaoByIndice(int indice){
		switch (indice) {
			
			case 1:
				return EnumTipoIntegracao.PEOPLE_SOFT_VALE;
				
			case 2:
				return EnumTipoIntegracao.PEOPLE_SOFT_VLI;
				
			case 3:
				return EnumTipoIntegracao.EXTERNA;
				
			default:
				break;
		}
		return null;
	}


	//GETTERS E SETTERS
    
	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
