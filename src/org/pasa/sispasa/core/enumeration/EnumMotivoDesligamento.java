package org.pasa.sispasa.core.enumeration;

/**
*
* @author Andre Gomes
*/

public enum EnumMotivoDesligamento {

	SEM_JUSTA_CAUSA(1L,"Desligado sem justa causa"),
	COM_JUSTA_CAUSA(2L,"Desligado por justa causa"),
	ABANDONO(3L,"Desligado por abandono de emprego"),
	TERMINO_CONTRATO(4L,"Desligado por término de contrato"),
	APOSENTADORIA(5L,"Desligado por aposentadoria"),
	INVALIDEZ(6L,"Desligado por invalidez"),
	FALECIMENTO(7L,"Desligado por falecimento");
	
	private Long indice;
	private String descricao;
	
	private EnumMotivoDesligamento(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumMotivoDesligamento getMotivoDesligamentoByIndice(int indice){
		
		switch (indice) {
			
			case 1:
				return EnumMotivoDesligamento.SEM_JUSTA_CAUSA;
				
			case 2:
				return EnumMotivoDesligamento.COM_JUSTA_CAUSA;
			
			case 3:
				return EnumMotivoDesligamento.ABANDONO;
				
			case 4:
				return EnumMotivoDesligamento.TERMINO_CONTRATO;
				
			case 5:
				return EnumMotivoDesligamento.APOSENTADORIA;
				
			case 6:
				return EnumMotivoDesligamento.INVALIDEZ;
				
			case 7:
				return EnumMotivoDesligamento.FALECIMENTO;	

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
