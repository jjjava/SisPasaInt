package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
*
* @author Andre Gomes
*/

public enum EnumMotivoDesligamento {

	SEM_JUSTA_CAUSA(1,"Desligado sem justa causa"),
	COM_JUSTA_CAUSA(2,"Desligado por justa causa"),
	ABANDONO(3,"Desligado por abandono de emprego"),
	TERMINO_CONTRATO(4,"Desligado por término de contrato"),
	APOSENTADORIA(5,"Desligado por aposentadoria"),
	INVALIDEZ(6,"Desligado por invalidez"),
	FALECIMENTO(7,"Desligado por falecimento");
	
	private int indice;
	private String descricao;
	
	private EnumMotivoDesligamento(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public static EnumSet<EnumMotivoDesligamento> getAllMotivoDesligamento() {
        return EnumSet.of(SEM_JUSTA_CAUSA, COM_JUSTA_CAUSA, ABANDONO, TERMINO_CONTRATO, APOSENTADORIA, INVALIDEZ, FALECIMENTO);
    }
	
	//getters e setters
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
