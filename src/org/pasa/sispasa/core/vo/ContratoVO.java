package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumOperadora;
import org.pasa.sispasa.core.enumeration.EnumTipoContrato;

/**
*
* @author Andre Gomes
* @author Hudson Schumaker
*/
public class ContratoVO extends AtributosComunsVO {


    private String numeroContrato;
    private String observacao;
    private Date dataInicioVigencia;
    private Date dataFimVigencia;
    private Integer idadeComEstudo;
    private Integer idadeSemEstudo;

    private OperadoraVO operadora;
    private EmpresaVO empresa;
    
    private PlanoVO plano;
    private List<PlanoVO> planos;
    
    EnumTipoContrato enumTipoContrato;
    EnumOperadora enumOperadora;
    

    //GETTERS E SETTERS
    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(Date dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public Date getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(Date dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public Integer getIdadeComEstudo() {
        return idadeComEstudo;
    }

    public void setIdadeComEstudo(Integer idadeComEstudo) {
        this.idadeComEstudo = idadeComEstudo;
    }

    public Integer getIdadeSemEstudo() {
        return idadeSemEstudo;
    }

    public void setIdadeSemEstudo(Integer idadeSemEstudo) {
        this.idadeSemEstudo = idadeSemEstudo;
    }

	/**
	 * @return the empresa
	 */
	public EmpresaVO getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EmpresaVO empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the operadora
	 */
	public OperadoraVO getOperadora() {
		return operadora;
	}

	/**
	 * @param operadora the operadora to set
	 */
	public void setOperadora(OperadoraVO operadora) {
		this.operadora = operadora;
	}

	/**
	 * @return the planos
	 */
	public List<PlanoVO> getPlanos() {
		return planos;
	}

	/**
	 * @param planos the planos to set
	 */
	public void setPlanos(List<PlanoVO> planos) {
		this.planos = planos;
	}

	public EnumTipoContrato getEnumTipoContrato() {
		return enumTipoContrato;
	}

	public void setEnumTipoContrato(EnumTipoContrato enumTipoContrato) {
		this.enumTipoContrato = enumTipoContrato;
	}

	public EnumOperadora getEnumOperadora() {
		return enumOperadora;
	}

	public void setEnumOperadora(EnumOperadora enumOperadora) {
		this.enumOperadora = enumOperadora;
	}

	public PlanoVO getPlano() {
		return plano;
	}

	public void setPlano(PlanoVO plano) {
		this.plano = plano;
	}

}
