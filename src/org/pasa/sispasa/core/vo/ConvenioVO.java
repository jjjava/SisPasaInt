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


    private Date dataInicioVigencia;
    private Date dataFimVigencia;
    private Integer qtdDiasAssociacao;
    private Integer qtdDiasAdesao;
    
    private EnumTipoPagamento enumTipoPagamento;
    private EnumTipoParticipacao enumTipoParticipacao;
	
    private ContratoVO contrato;
    private EmpresaVO empresa;
    
    private boolean indParticipacaoTaxaAssociado;
    
    private boolean indContribuicaoAssociado;
    private boolean indContribuicaoAgregado;
    private boolean indContribuicaoDependente;
    
    private boolean indCoparticipacaoAssociado;
    private boolean indCoparticipacaoAgregado;
    private boolean indCoparticipacaoDependente;
    
    
    //GETTERS E SETTERS
    
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
	public ContratoVO getContrato() {
		return contrato;
	}
	public void setContrato(ContratoVO contrato) {
		this.contrato = contrato;
	}
	public boolean isIndContribuicaoAssociado() {
		return indContribuicaoAssociado;
	}
	public void setIndContribuicaoAssociado(boolean indContribuicaoAssociado) {
		this.indContribuicaoAssociado = indContribuicaoAssociado;
	}
	public boolean isIndContribuicaoAgregado() {
		return indContribuicaoAgregado;
	}
	public void setIndContribuicaoAgregado(boolean indContribuicaoAgregado) {
		this.indContribuicaoAgregado = indContribuicaoAgregado;
	}
	public boolean isIndContribuicaoDependente() {
		return indContribuicaoDependente;
	}
	public void setIndContribuicaoDependente(boolean indContribuicaoDependente) {
		this.indContribuicaoDependente = indContribuicaoDependente;
	}
	public boolean isIndCoparticipacaoAssociado() {
		return indCoparticipacaoAssociado;
	}
	public void setIndCoparticipacaoAssociado(boolean indCoparticipacaoAssociado) {
		this.indCoparticipacaoAssociado = indCoparticipacaoAssociado;
	}
	public boolean isIndCoparticipacaoAgregado() {
		return indCoparticipacaoAgregado;
	}
	public void setIndCoparticipacaoAgregado(boolean indCoparticipacaoAgregado) {
		this.indCoparticipacaoAgregado = indCoparticipacaoAgregado;
	}
	public boolean isIndCoparticipacaoDependente() {
		return indCoparticipacaoDependente;
	}
	public void setIndCoparticipacaoDependente(boolean indCoparticipacaoDependente) {
		this.indCoparticipacaoDependente = indCoparticipacaoDependente;
	}
	public void setIndParticipacaoTaxaAssociado(boolean indParticipacaoTaxaAssociado) {
		this.indParticipacaoTaxaAssociado = indParticipacaoTaxaAssociado;
	}
	public boolean isIndParticipacaoTaxaAssociado() {
		return indParticipacaoTaxaAssociado;
	}
	public EmpresaVO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaVO empresa) {
		this.empresa = empresa;
	}
}
