package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoEnvioCobranca;
import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;
import org.pasa.sispasa.core.enumeration.EnumTipoRespPagamento;
import org.pasa.sispasa.core.model.TipoPagamento;

public class ConfigPagamentoVO extends AtributosComunsVO {

	private List<ConvenioVO> listConvenioVO;

	private EnumTipoEnvioCobranca enumTipoEnvioCobranca;
	private EnumTipoRespPagamento enumTipoResponsavel;
	private EnumTipoPagamento enumTipoPagamento;

	private ResponsavelLegalVO rpLegalVO;
	private ConvenioVO convenioVO;

	private Integer periodoPatrocinioTemp;
	private String nomeResponsavelPag;
	private Integer periodoPatrocinio;
	private Long idTaxaAssociado;

	public ConfigPagamentoVO() {
	}

	public ConfigPagamentoVO(ConvenioVO convenioVO, EnumTipoEnvioCobranca enumTipoEnvioCobranca) {
		this.enumTipoEnvioCobranca = enumTipoEnvioCobranca;
		this.convenioVO = convenioVO;
	}

	public boolean isEnumTipoResponsavelTitular() {
		return null != enumTipoResponsavel && EnumTipoRespPagamento.T == enumTipoResponsavel;
	}

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

	public Integer getPeriodoPatrocinio() {
		return periodoPatrocinio;
	}

	public void setPeriodoPatrocinio(Integer periodoPatrocinio) {
		this.periodoPatrocinio = periodoPatrocinio;
	}

	public EnumTipoRespPagamento getEnumTipoResponsavel() {
		return enumTipoResponsavel;
	}

	public void setEnumTipoResponsavel(EnumTipoRespPagamento enumTipoResponsavel) {
		this.enumTipoResponsavel = enumTipoResponsavel;
	}

	public String getNomeResponsavelPag() {
		return nomeResponsavelPag;
	}

	public void setNomeResponsavelPag(String nomeResponsavelPag) {
		this.nomeResponsavelPag = nomeResponsavelPag;
	}

	public ResponsavelLegalVO getRpLegalVO() {
		if (null == rpLegalVO) {
			rpLegalVO = new ResponsavelLegalVO();
		}
		return rpLegalVO;
	}

	public void setRpLegalVO(ResponsavelLegalVO rpLegalVO) {
		this.rpLegalVO = rpLegalVO;
	}

}
