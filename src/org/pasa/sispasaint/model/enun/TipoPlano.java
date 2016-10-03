package org.pasa.sispasaint.model.enun;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

public enum TipoPlano {
	
	Medico(0, "Médico"),
	Odontologico(1, "Odontológico"),
	Ambos(2,"Médico e Odontológico");
	
	private int indice;
	private String descricao;
	
	private TipoPlano(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}
	
    public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	} 
}
