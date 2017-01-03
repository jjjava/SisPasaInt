package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;
import org.pasa.sispasa.core.enumeration.EnumTipoParticipacao;

/**
 * 
 * @author Andre Gomes
 *
 */
public class ConvenioVO extends AtributosComunsVO {


    private Date dataInicio;
    private Date dataFim;
    private Integer qtdDiasAssociacao;
    private Integer qtdDiasAdesao;

    private Integer indParticipacaoTaxaAssociado;
    private Integer indContribuicaoAssociado;
    private Integer indContribuicaoAgregado;
    private Integer indContribDependente;
    private Integer indCoparticipacaoAssociado;
    private Integer indCoparticipacaoAgregado;
    private Integer indCoparticipacaoDependente;
    
    private EnumTipoPagamento enumTipoPagamento;
    private EnumTipoParticipacao enumTipoParticipacao;
	
    
    //GETTERS E SETTERS
    
    public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Integer getQtdDiasAssociacao() {
		return qtdDiasAssociacao;
	}
	public void setQtdDiasAssociacao(Integer qtdDiasAssociacao) {
		this.qtdDiasAssociacao = qtdDiasAssociacao;
	}
	public Integer getQtdDiasAdesao() {
		return qtdDiasAdesao;
	}
	public void setQtdDiasAdesao(Integer qtdDiasAdesao) {
		this.qtdDiasAdesao = qtdDiasAdesao;
	}
	public Integer getIndParticipacaoTaxaAssociado() {
		return indParticipacaoTaxaAssociado;
	}
	public void setIndParticipacaoTaxaAssociado(Integer indParticipacaoTaxaAssociado) {
		this.indParticipacaoTaxaAssociado = indParticipacaoTaxaAssociado;
	}
	public Integer getIndContribuicaoAssociado() {
		return indContribuicaoAssociado;
	}
	public void setIndContribuicaoAssociado(Integer indContribuicaoAssociado) {
		this.indContribuicaoAssociado = indContribuicaoAssociado;
	}
	public Integer getIndContribuicaoAgregado() {
		return indContribuicaoAgregado;
	}
	public void setIndContribuicaoAgregado(Integer indContribuicaoAgregado) {
		this.indContribuicaoAgregado = indContribuicaoAgregado;
	}
	public Integer getIndContribDependente() {
		return indContribDependente;
	}
	public void setIndContribDependente(Integer indContribDependente) {
		this.indContribDependente = indContribDependente;
	}
	public Integer getIndCoparticipacaoAssociado() {
		return indCoparticipacaoAssociado;
	}
	public void setIndCoparticipacaoAssociado(Integer indCoparticipacaoAssociado) {
		this.indCoparticipacaoAssociado = indCoparticipacaoAssociado;
	}
	public Integer getIndCoparticipacaoAgregado() {
		return indCoparticipacaoAgregado;
	}
	public void setIndCoparticipacaoAgregado(Integer indCoparticipacaoAgregado) {
		this.indCoparticipacaoAgregado = indCoparticipacaoAgregado;
	}
	public Integer getIndCoparticipacaoDependente() {
		return indCoparticipacaoDependente;
	}
	public void setIndCoparticipacaoDependente(Integer indCoparticipacaoDependente) {
		this.indCoparticipacaoDependente = indCoparticipacaoDependente;
	}
	public EnumTipoPagamento getEnumTipoPagamento() {
		return enumTipoPagamento;
	}
	public void setEnumTipoPagamento(EnumTipoPagamento enumTipoPagamento) {
		this.enumTipoPagamento = enumTipoPagamento;
	}
	public EnumTipoParticipacao getEnumTipoParticipacao() {
		return enumTipoParticipacao;
	}
	public void setEnumTipoParticipacao(EnumTipoParticipacao enumTipoParticipacao) {
		this.enumTipoParticipacao = enumTipoParticipacao;
	}
    
    
    
    
    

}
