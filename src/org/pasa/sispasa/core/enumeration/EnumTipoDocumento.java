package org.pasa.sispasa.core.enumeration;

import java.util.EnumSet;

/**
 * 
 * @author Andre Gomes
 *
 */
public enum EnumTipoDocumento {

	RG(1L,"Carteira de Identidade"),
	CTPS(2L,"Carteira de Trabalho"),
	PIS_PASEP(3L,"PIS/PASEP"),
	CNH(4L,"Carteira de Habilitação"),
	PASSAPORTE(5L,"Passaporte");
	
	private final Long indice;
	private final String descricao;
	
	EnumTipoDocumento(Long indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	/**
	 * 
	 * @param indice
	 * @return
	 */
	public static EnumTipoDocumento getTipoDocumentoByIndice(int indice){
		
		switch (indice) {
			
			case 1:
				return EnumTipoDocumento.RG;
				
			case 2:
				return EnumTipoDocumento.CTPS;
			
			case 3:
				return EnumTipoDocumento.PIS_PASEP;
				
			case 4:
				return EnumTipoDocumento.CNH;
				
			case 5:
				return EnumTipoDocumento.PASSAPORTE;	
				
			default:
				break;
		}
		
		return null;
	}
	
	public static EnumSet<EnumTipoDocumento> getAllTipoDocumento() {
        return EnumSet.of(RG, CTPS, PIS_PASEP, CNH, PASSAPORTE  );
    }
	
	//GETTERS E SETTERS 
	public Long getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}
}