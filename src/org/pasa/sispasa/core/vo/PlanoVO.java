package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoPlano;
import org.pasa.sispasa.core.model.FaixaEtariaPlano;
import org.pasa.sispasa.core.model.Plano;
import org.pasa.sispasa.core.model.VigenciaFaixaEtaria;

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
    private List<FaixaEtariaPlano> listaFaixaEtaria;
    
    
    private List<Plano> listaPlanos;
    
    private Plano plano;
    
    private VigenciaFaixaEtaria vigenciaPlano;
    
    private boolean exibirAbaInfoGerais;
    
    private boolean  exibirAbaFaixaEtaria;
    
    private String confirmRegraLim6x;
    
    private String confirmRegraVarAcum;
    

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
    public String getNomeFaixa(FaixaEtariaPlano faixa) {
		String ouMais =  " ou mais";
		String hifen = " - ";
		if(faixa != null){
			String idadeFim = faixa.getIdadeFim() == null ? ouMais : hifen.concat(faixa.getIdadeFim().toString());
			return faixa.getIdadeInicio().toString().concat(idadeFim);
		}
		return "";
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

	public boolean isExibirAbaInfoGerais() {
		return exibirAbaInfoGerais;
	}

	public void setExibirAbaInfoGerais(boolean exibirAbaInfoGerais) {
		this.exibirAbaInfoGerais = exibirAbaInfoGerais;
	}

	public boolean isExibirAbaFaixaEtaria() {
		return exibirAbaFaixaEtaria;
	}

	public void setExibirAbaFaixaEtaria(boolean exibirAbaFaixaEtaria) {
		this.exibirAbaFaixaEtaria = exibirAbaFaixaEtaria;
	}

	public List<FaixaEtariaPlano> getListaFaixaEtaria() {
		return listaFaixaEtaria;
	}

	public void setListaFaixaEtaria(List<FaixaEtariaPlano> listaFaixaEtaria) {
		this.listaFaixaEtaria = listaFaixaEtaria;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getListaPlanos() {
		return listaPlanos;
	}

	public void setListaPlanos(List<Plano> listaPlanos) {
		this.listaPlanos = listaPlanos;
	}

	public VigenciaFaixaEtaria getVigenciaPlano() {
		return vigenciaPlano;
	}

	public void setVigenciaPlano(VigenciaFaixaEtaria vigenciaPlano) {
		this.vigenciaPlano = vigenciaPlano;

	}

	public String getConfirmRegraLim6x() {
		return confirmRegraLim6x;
	}

	public void setConfirmRegraLim6x(String confirmRegraLim6x) {
		this.confirmRegraLim6x = confirmRegraLim6x;
	}

	public String getConfirmRegraVarAcum() {
		return confirmRegraVarAcum;
	}

	public void setConfirmRegraVarAcum(String confirmRegraVarAcum) {
		this.confirmRegraVarAcum = confirmRegraVarAcum;
	}


}
