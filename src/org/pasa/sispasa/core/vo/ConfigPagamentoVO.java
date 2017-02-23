package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoEnvioCobranca;
import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;
import org.pasa.sispasa.core.model.TipoPagamento;

public class ConfigPagamentoVO extends AtributosComunsVO {
	
	private List<ConvenioVO> listConvenioVO;
	
	private EnumTipoEnvioCobranca enumTipoEnvioCobranca;
	private EnumTipoPagamento enumTipoPagamento;
	
	private ConvenioVO convenioVO;

	private Integer periodoPatrocinioTemp;
	private Long idTaxaAssociado;

	public boolean isEnumTipoPagamentoBoleto() {
		return EnumTipoPagamento.BOLETO.equals(enumTipoPagamento);
	}

	public TipoPagamento getTipoPagamento() {
		return new TipoPagamento(enumTipoPagamento.getIndice());
	}

	public ConvenioVO getConvenioVO() {
		return convenioVO;
	}

	public void setConvenioVO(ConvenioVO convenioVO) {
		this.convenioVO = convenioVO;
	}

	public Long getIdTaxaAssociado() {
		return idTaxaAssociado;
	}

	public void setIdTaxaAssociado(Long idTaxaAssociado) {
		this.idTaxaAssociado = idTaxaAssociado;
	}

	public List<ConvenioVO> getListConvenioVO() {
		if (null == listConvenioVO) {
			listConvenioVO = new ArrayList<ConvenioVO>();
		}
		return listConvenioVO;
	}

	public void setListConvenioVO(List<ConvenioVO> listConvenioVO) {
		this.listConvenioVO = listConvenioVO;
	}

	public EnumTipoPagamento getEnumTipoPagamento() {
		return enumTipoPagamento;
	}

	public void setEnumTipoPagamento(EnumTipoPagamento enumTipoPagamento) {
		this.enumTipoPagamento = enumTipoPagamento;
	}

	public EnumTipoEnvioCobranca getEnumTipoEnvioCobranca() {
		return enumTipoEnvioCobranca;
	}

	public void setEnumTipoEnvioCobranca(EnumTipoEnvioCobranca enumTipoEnvioCobranca) {
		this.enumTipoEnvioCobranca = enumTipoEnvioCobranca;
	}

	public Integer getPeriodoPatrocinioTemp() {
		return periodoPatrocinioTemp;
	}

	public void setPeriodoPatrocinioTemp(Integer periodoPatrocinioTemp) {
		this.periodoPatrocinioTemp = periodoPatrocinioTemp;
	}

}
