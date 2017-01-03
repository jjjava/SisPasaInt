package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */
public enum EnumEstadoCivil {
	
	SOLTEIRO(1L, "Solteiro"),
	CASADO(2L, "Casado"),
	DIVORCIADO(3L,"Divorciado"),
	DESQUITADO(4L,"Desquitado"),
	VIUVO(5L,"Viúvo");
	
	private Long indice;
	private String descricao;
	
	private EnumEstadoCivil(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumEstadoCivil getEstadoCivilByIndice(Long indice){

		switch (indice.intValue()) {
			
			case 1:
				return EnumEstadoCivil.SOLTEIRO;
				
			case 2:
				return EnumEstadoCivil.CASADO;
			
			case 3:
				return EnumEstadoCivil.DIVORCIADO;
				
			case 4:
				return EnumEstadoCivil.DESQUITADO;	
				
			case 5:
				return EnumEstadoCivil.VIUVO;				

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
