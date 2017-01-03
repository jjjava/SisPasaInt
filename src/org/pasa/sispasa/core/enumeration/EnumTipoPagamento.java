package org.pasa.sispasa.core.enumeration;

/**
*
* @author Andre Gomes
*/

public enum EnumTipoPagamento {

	DESCONTO_EM_FOLHA(1L,"Desconto em Folha"),
	NOTA_DE_DEBITO(2L,"Nota de Débito"),
	BOLETO(3L, "Boleto"),
	DEBITO_AUTOMATICO(4L, "Debito Automático"),
	CARTAO_DE_CREDITO(5L, "Cartão de Crédito");
	
	private Long indice;
	private String descricao;
	
	EnumTipoPagamento(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
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


	//GETTERS E SETTERS

	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}