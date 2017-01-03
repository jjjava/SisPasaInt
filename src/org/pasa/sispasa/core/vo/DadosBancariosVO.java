package org.pasa.sispasa.core.vo;

import org.pasa.sispasa.core.enumeration.EnumBanco;
import org.pasa.sispasa.core.enumeration.EnumTipoConta;

/**
 *
 * @author  Andre Gomes
 */
public class DadosBancariosVO extends AtributosComunsVO{

    private String agencia;
    private String conta;
    
    private EnumBanco enumBanco;
    private EnumTipoConta enumTipoConta;
    

    //GETTERS E SETTERS
    
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

	/**
	 * @return the enumBanco
	 */
	public EnumBanco getEnumBanco() {
		return enumBanco;
	}

	/**
	 * @param enumBanco the enumBanco to set
	 */
	public void setEnumBanco(EnumBanco enumBanco) {
		this.enumBanco = enumBanco;
	}

	/**
	 * @return the enumTipoConta
	 */
	public EnumTipoConta getEnumTipoConta() {
		return enumTipoConta;
	}

	/**
	 * @param enumTipoConta the enumTipoConta to set
	 */
	public void setEnumTipoConta(EnumTipoConta enumTipoConta) {
		this.enumTipoConta = enumTipoConta;
	}
}
