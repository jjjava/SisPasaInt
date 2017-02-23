package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumTipoPlano;

/**
*
* @author Andre Gomes
*/
public class PlanoVO extends AtributosComunsVO{

    private String codPlano;
    private String nome;
    private String descricao;
    private Date dataInicioVigencia;
    private Date dataFimVigencia;
    private Integer qtdDiasCarencia;
    private String registroANS;
    private Integer indPermissaoAssociacao;
    private ContratoVO contrato;
    private EnumTipoPlano enumTipoPlano;
    private PlanoVO planoPai;

    
    public PlanoVO(){
    	//CONSTRUTOR DEFAULT
    }
    
    public PlanoVO(Long id, String nome, String descricao){
    	super.id = id;
    	this.nome = nome;
    	this.descricao = descricao;
    }
    
    
    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Integer getQtdDiasCarencia() {
        return qtdDiasCarencia;
    }

    public void setQtdDiasCarencia(Integer qtdDiasCarencia) {
        this.qtdDiasCarencia = qtdDiasCarencia;
    }

    public String getRegistroANS() {
        return registroANS;
    }

    public void setRegistroANS(String registroANS) {
        this.registroANS = registroANS;
    }

    public PlanoVO getPlanoPai() {
        return planoPai;
    }

    public void setPlanoPai(PlanoVO planoPai) {
        this.planoPai = planoPai;
    }

    public String getCodPlano() {
        return codPlano;
    }

    public void setCodPlano(String codPlano) {
        this.codPlano = codPlano;
    }

	public EnumTipoPlano getEnumTipoPlano() {
		return enumTipoPlano;
	}

	public void setEnumTipoPlano(EnumTipoPlano enumTipoPlano) {
		this.enumTipoPlano = enumTipoPlano;
	}

	public ContratoVO getContrato() {
		return contrato;
	}

	public void setContrato(ContratoVO contrato) {
		this.contrato = contrato;
	}

	public Integer getIndPermissaoAssociacao() {
		return indPermissaoAssociacao;
	}

	public void setIndPermissaoAssociacao(Integer indPermissaoAssociacao) {
		this.indPermissaoAssociacao = indPermissaoAssociacao;
	}
}
