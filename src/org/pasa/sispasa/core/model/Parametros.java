package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "PARAMETROS")
public class Parametros  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name ="CHAVE", columnDefinition = ConstantesBanco.CHAR_15)
    private String chave; 
    
    @Column(name ="VALOR", length = 1024)
    private String valor;
    
    public Parametros(){
    }

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
