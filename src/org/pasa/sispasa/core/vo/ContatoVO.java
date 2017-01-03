package org.pasa.sispasa.core.vo;

/**
 *
 * @author Andre Gomes
 */
public class ContatoVO extends AtributosComunsVO{

    private String nome;
    private String email;
    private String setor;

    private TelefoneVO telefoneComercial;
    private TelefoneVO telefoneCelular;


    //GETTERS E SETTERS
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

	public TelefoneVO getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(TelefoneVO telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public TelefoneVO getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(TelefoneVO telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	
}