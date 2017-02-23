package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;
import org.pasa.sispasa.core.enumeration.EnumTipoParticipacao;

/**
 * 
 * @author Andre Gomes
 * @author Hudson Schumaker
 *
 */
public class ConvenioVO extends AtributosComunsVO {

	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private Integer diaVencimento;
	
	private Integer qtdDiasAssociacao;
	private Integer qtdDiasAdesao;

	private EnumTipoParticipacao enumTipoParticipacao;
	private EnumTipoPagamento enumTipoPagamento;

	private ContratoVO contrato;
	private EmpresaVO empresa;

	private boolean indConvenioPrincipal;
	private boolean indParticipacaoTaxaAssociado;

	private boolean indContribuicaoAssociado;
	private boolean indContribuicaoAgregado;
	private boolean indContribuicaoDependente;

	private boolean indCoparticipacaoAssociado;
	private boolean indCoparticipacaoAgregado;
	private boolean indCoparticipacaoDependente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConvenioVO other = (ConvenioVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isEnumTipoParticipacaoSemParticipacao() {
		return EnumTipoParticipacao.SEM_PARTICIPACAO.equals(enumTipoParticipacao);
	}

	public boolean isEnumTipoParticipacaoPatrocinioTemp() {
		return EnumTipoParticipacao.PATROCINIO_TEMPORARIO.equals(enumTipoParticipacao);
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

	public boolean isIndConvenioPrincipal() {
		return indConvenioPrincipal;
	}

	public void setIndConvenioPrincipal(boolean indConvenioPrincipal) {
		this.indConvenioPrincipal = indConvenioPrincipal;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

}
