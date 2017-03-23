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

	EnumTipoParticipacao(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public static EnumTipoParticipacao getFromIndice(Long indice) {
		for (EnumTipoParticipacao enumTipoPart : EnumTipoParticipacao.values()) {
			if (enumTipoPart.getIndice().equals(indice)) {
				return enumTipoPart;
			}
		}
		return null;
	}

	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}
