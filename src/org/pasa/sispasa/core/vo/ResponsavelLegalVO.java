package org.pasa.sispasa.core.vo;

import org.pasa.sispasa.core.enumeration.EnumTipoTelefone;

/**
 * @author Allan Garcia
 *
 */
public class ResponsavelLegalVO extends AtributosComunsVO {

	private TelefoneVO telefoneResidencial;
	private TelefoneVO telefoneCelular;
	private PessoaVO participanteVO;

	public ResponsavelLegalVO() {
	}

	public ResponsavelLegalVO(String cpf) {
		getParticipanteVO().setCpfFormatado(cpf);
	}

	public TelefoneVO getTelefoneResidencial() {
		if (null == telefoneResidencial) {
			telefoneResidencial = new TelefoneVO(EnumTipoTelefone.RESIDENCIAL);
		}
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(TelefoneVO telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public TelefoneVO getTelefoneCelular() {
		if (null == telefoneCelular) {
			telefoneCelular = new TelefoneVO(EnumTipoTelefone.CELULAR);
		}
		return telefoneCelular;
	}

	public void setTelefoneCelular(TelefoneVO telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public PessoaVO getParticipanteVO() {
		if (null == participanteVO) {
			participanteVO = new PessoaVO();
		}
		return participanteVO;
	}

	public void setParticipanteVO(PessoaVO participanteVO) {
		this.participanteVO = participanteVO;
	}

}