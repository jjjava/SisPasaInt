package org.pasa.sispasa.core.enumeration;

/**
 *
 * @author Andre Gomes
 */

public enum EnumTipoPlano {

	MEDICO(1L, "Médico"), 
	ODONTOLOGICO(2L, "Odontológico"),
	MEDICO_E_ODONTOLOGICO(3L, "Médico e Odontológico");

	private Long indice;
	private String descricao;

	EnumTipoPlano(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public static EnumTipoPlano getTipoPlanoByIndice(Long indice) {

		switch (indice.intValue()) {

		case 1:
			return EnumTipoPlano.MEDICO;

		case 2:
			return EnumTipoPlano.ODONTOLOGICO;

		case 3:
			return EnumTipoPlano.MEDICO_E_ODONTOLOGICO;

		default:
			break;
		}
		return null;
	}

	// GETTERS E SETTERS

	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}