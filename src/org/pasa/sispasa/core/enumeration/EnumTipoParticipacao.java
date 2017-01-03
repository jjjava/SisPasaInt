/**
 * 
 */
package org.pasa.sispasa.core.enumeration;

/**
 * @author Andre Gomes
 *
 */
public enum EnumTipoParticipacao {
	
	PATROCINIO(1L, "Patrocínio"),
	PATROCINIO_TEMPORARIO(2L, "Patrocínio Temporário"),
	INTERMEDIACAO(3L, "Intermediação"),
	SEM_PARTICIPACAO(4L, "Sem Participação");
	
	private Long indice;
	private String descricao;
	
	EnumTipoParticipacao(Long indice, String descricao){
		this.indice = indice;
		this.descricao = descricao;
	}
	
	public static EnumTipoParticipacao getTipoParticipacaoByIndice(Long indice){
		
		switch (indice.intValue()) {
			
			case 1:
				return EnumTipoParticipacao.PATROCINIO;
				
			case 2:
				return EnumTipoParticipacao.PATROCINIO_TEMPORARIO;
			
			case 3:
				return EnumTipoParticipacao.INTERMEDIACAO;
				
			case 4:
				return EnumTipoParticipacao.SEM_PARTICIPACAO;	

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
