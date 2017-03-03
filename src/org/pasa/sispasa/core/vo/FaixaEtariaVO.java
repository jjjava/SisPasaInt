package org.pasa.sispasa.core.vo;

import java.math.BigDecimal;

import org.pasa.sispasa.core.model.FaixaEtariaPlano;

public class FaixaEtariaVO {

	private FaixaEtariaPlano faixaEtaria;
	
	
	private BigDecimal percentualFaixaVenda;

	public FaixaEtariaPlano getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtariaPlano faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}


	public BigDecimal getPercentualFaixaVenda() {
		return percentualFaixaVenda;
	}

	public void setPercentualFaixaVenda(BigDecimal percentualFaixaVenda) {
		this.percentualFaixaVenda = percentualFaixaVenda;
	}
	
	
}
