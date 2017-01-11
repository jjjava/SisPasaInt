package org.pasa.sispasa.core.enumeration;

/**
*
* @author Andre Gomes
*/

public enum EnumNivelEscolaridade {

        SEM(0L,"Sem instrução"),
	FUNDAMENTAL(1L,"Ensino Fundamental"),
	MEDIO(2L,"Ensino Médio"),
	SUPERIOR(3L,"Ensino Superior"),
	POS(4L,"Pós Graduação"),
	MESTRADO(5L,"Mestrado"),
	DOUTORADO(6L,"Doutorado");
	
	private Long indice;
	private String descricao;
	
	private EnumNivelEscolaridade(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumNivelEscolaridade getNivelEscolaridadeByIndice(int indice){
		
		switch (indice) {
			
			case 1:
				return EnumNivelEscolaridade.FUNDAMENTAL;
				
			case 2:
				return EnumNivelEscolaridade.MEDIO;
			
			case 3:
				return EnumNivelEscolaridade.SUPERIOR;
				
			case 4:
				return EnumNivelEscolaridade.POS;
				
			case 5:
				return EnumNivelEscolaridade.MESTRADO;
				
			case 6:
				return EnumNivelEscolaridade.DOUTORADO;

			default:
				break;
		}
		
		return null;
	}
	
	//getters e setters
    public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
