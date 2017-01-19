package org.pasa.sispasa.core.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Andre Gomes
* @author Hudson Schumaker
* @version 1.0.0
*/

public enum EnumTipoPagamento {

	DESCONTO_EM_FOLHA(1L,"Desconto em Folha","E"),
	NOTA_DE_DEBITO(2L,"Nota de Débito","E"),
	BOLETO(3L, "Boleto","A"),
	DEBITO_AUTOMATICO(4L, "Debito Automático","E"),
	CARTAO_DE_CREDITO(5L, "Cartão de Crédito","A");
	
	private Long indice;
	private String descricao;
	private String tpPagador;
	
	EnumTipoPagamento(Long indice, String descricao, String tpPagador) {
		this.indice = indice;
		this.descricao = descricao;
		this.tpPagador = tpPagador;
	}
	
	public static List<EnumTipoPagamento> getListaPorTipoPagador(String tpPagador){
		
		List<EnumTipoPagamento> lista = new ArrayList<>();
		for (EnumTipoPagamento e : EnumTipoPagamento.values()) {
		    if(tpPagador.equalsIgnoreCase(e.tpPagador)){
		    	lista.add(e);
		    }
		}
		return lista;
	}
	
	public static EnumTipoPagamento getTipoPagamentoByIndice(Long indice){
		
		switch (indice.intValue()) {
			case 1:
				return EnumTipoPagamento.DESCONTO_EM_FOLHA;
			case 2:
				return EnumTipoPagamento.NOTA_DE_DEBITO;
			case 3:
				return EnumTipoPagamento.BOLETO;
			case 4:
				return EnumTipoPagamento.DEBITO_AUTOMATICO;
			case 5:
				return EnumTipoPagamento.CARTAO_DE_CREDITO;
			default:
				break;
		}
		return null;
	}


	//GETTERS
	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getTpPagador(){
		return tpPagador;
	}
}