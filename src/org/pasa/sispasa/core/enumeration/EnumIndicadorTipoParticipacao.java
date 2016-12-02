/**
 * 
 */
package org.pasa.sispasa.core.enumeration;

/**
 * @author Luzia Nascimento
 *
 */
public enum EnumIndicadorTipoParticipacao {
	
	TaxaAssociativa(0, "Taxa Associativa"),
	Contribuicao(1, "Contribuição" ),
	Coparticipacao(2, "Coparticipação");
	
	private final int idIndicadorTipoParticipacao;
	private final String descricaoIndicadorTipoParticipacao;
	
	EnumIndicadorTipoParticipacao(int indice, String descricao){
		this.idIndicadorTipoParticipacao = indice;
		this.descricaoIndicadorTipoParticipacao = descricao;
	}

	public int getIdIndicadorTipoParticipacao() {
		return idIndicadorTipoParticipacao;
	}

	public String getDescricaoIndicadorTipoParticipacao() {
		return descricaoIndicadorTipoParticipacao;
	}	
}
