package org.pasa.sispasa.core.vo;

import java.util.Date;
import org.pasa.sispasa.core.enumeration.EnumTipoBeneficiario;

/**
 *
 * @author Andre Gomes
 */
public class BeneficiarioVO extends PessoaVO {

    private String codBeneficiario;
    private String matriculaAMS;
    private String carteirinha;
    private String direitoAmsCredenciar;
    private String direitoAMSReenbolso;
    private String codCR;
    private String orgaoPessoal;
    private String faixaNivel;
    private String nucleoAMS;
    private String matriculaParticipante;
    private String matriculaRepresentanteLegal;
    private String planoReciprocidadeCassi;
    private String cns;
    private String declNascidoVivo;
    private Date dataValidadeCredenciado;
    private Date dataValidadeReembolso;
    private Date dataFimPlanoCassi;
    private PlanoVO plano;
    private FuncionarioVO funcionario;
    private EnumTipoBeneficiario enumTipoBeneficiario;
    
    //GETTERS E SETTERS
    
    public String getCodBeneficiario() {
        return codBeneficiario;
    }

    public void setCodBeneficiario(String codBeneficiario) {
        this.codBeneficiario = codBeneficiario;
    }

    public String getMatriculaAMS() {
        return matriculaAMS;
    }

    public void setMatriculaAMS(String matriculaAMS) {
        this.matriculaAMS = matriculaAMS;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }

    public String getDireitoAmsCredenciar() {
        return direitoAmsCredenciar;
    }

    public void setDireitoAmsCredenciar(String direitoAmsCredenciar) {
        this.direitoAmsCredenciar = direitoAmsCredenciar;
    }

    public Date getDataValidadeCredenciado() {
        return dataValidadeCredenciado;
    }

    public void setDataValidadeCredenciado(Date dataValidadeCredenciado) {
        this.dataValidadeCredenciado = dataValidadeCredenciado;
    }

    public String getDireitoAMSReenbolso() {
        return direitoAMSReenbolso;
    }

    public void setDireitoAMSReenbolso(String direitoAMSReenbolso) {
        this.direitoAMSReenbolso = direitoAMSReenbolso;
    }

    public Date getDataValidadeReembolso() {
        return dataValidadeReembolso;
    }

    public void setDataValidadeReembolso(Date dataValidadeReembolso) {
        this.dataValidadeReembolso = dataValidadeReembolso;
    }

    public String getCodCR() {
        return codCR;
    }

    public void setCodCR(String codCR) {
        this.codCR = codCR;
    }

    public String getOrgaoPessoal() {
        return orgaoPessoal;
    }

    public void setOrgaoPessoal(String orgaoPessoal) {
        this.orgaoPessoal = orgaoPessoal;
    }

    public String getFaixaNivel() {
        return faixaNivel;
    }

    public void setFaixaNivel(String faixaNivel) {
        this.faixaNivel = faixaNivel;
    }

    public String getNucleoAMS() {
        return nucleoAMS;
    }

    public void setNucleoAMS(String nucleoAMS) {
        this.nucleoAMS = nucleoAMS;
    }

    public String getMatriculaParticipante() {
        return matriculaParticipante;
    }

    public void setMatriculaParticipante(String matriculaParticipante) {
        this.matriculaParticipante = matriculaParticipante;
    }

    public String getMatriculaRepresentanteLegal() {
        return matriculaRepresentanteLegal;
    }

    public void setMatriculaRepresentanteLegal(String matriculaRepresentanteLegal) {
        this.matriculaRepresentanteLegal = matriculaRepresentanteLegal;
    }

    public String getPlanoReciprocidadeCassi() {
        return planoReciprocidadeCassi;
    }

    public void setPlanoReciprocidadeCassi(String planoReciprocidadeCassi) {
        this.planoReciprocidadeCassi = planoReciprocidadeCassi;
    }

    public Date getDataFimPlanoCassi() {
        return dataFimPlanoCassi;
    }

    public void setDataFimPlanoCassi(Date dataFimPlanoCassi) {
        this.dataFimPlanoCassi = dataFimPlanoCassi;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getDeclNascidoVivo() {
        return declNascidoVivo;
    }

    public void setDeclNascidoVivo(String declNascidoVivo) {
        this.declNascidoVivo = declNascidoVivo;
    }


	/**
	 * @return the enumTipoBeneficiario
	 */
	public EnumTipoBeneficiario getEnumTipoBeneficiario() {
		return enumTipoBeneficiario;
	}

	/**
	 * @param enumTipoBeneficiario the enumTipoBeneficiario to set
	 */
	public void setEnumTipoBeneficiario(EnumTipoBeneficiario enumTipoBeneficiario) {
		this.enumTipoBeneficiario = enumTipoBeneficiario;
	}

	/**
	 * @return the plano
	 */
	public PlanoVO getPlano() {
		return plano;
	}

	/**
	 * @param plano the plano to set
	 */
	public void setPlano(PlanoVO plano) {
		this.plano = plano;
	}

	/**
	 * @return the funcionario
	 */
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(FuncionarioVO funcionario) {
		this.funcionario = funcionario;
	}

}
