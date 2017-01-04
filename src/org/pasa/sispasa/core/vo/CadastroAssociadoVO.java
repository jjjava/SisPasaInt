package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumGrauParentesco;
import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.enumeration.EnumSituacaoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoAposentadoria;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoCobranca;
import org.pasa.sispasa.core.enumeration.EnumTipoResponsavel;

public class CadastroAssociadoVO extends FuncionarioVO {

	private List<EnumTipoAposentadoria> listEnumTipoAposentadoria;
	private List<UsuarioAssociadoVO> listUsuariosAssociadoVO;
	private List<ConvenioVO> listConvenioVO;

	private EnumMotivoDesligamento enumMotivoDesligamento;
	private EnumSituacaoAssociado enumSituacaoAssociado;
	private EnumTipoResponsavel enumTipoResponsavel;
	private EnumSimNao enumSimNao;
	private EnumTipoCobranca enumTipoCobranca;
	private EnumGrauParentesco enumGrauParentesco;
	private EnumSimNao enumConclusaoEscolaridade;
	private EnumTipoAssociado enumTipoAssociado;

	private DadosBancariosVO dadosBancariosReembolso;

	private Date dataAposentadoria;
	private Date dtCriacaoPreCadastro;
	private Date dtAnalisePreCadastro;
	private Date dtReadmissao;
	private Date dtInicioVinculo;
	private Date dtDesligamentoAssociado;
	private String matriculaParticipante;
	private String matriculaRepresentante;
	private Long idTaxaAssociado;
	private Long idConvenio;
	private Long idFuncionario;
	private Long idParticipante;
	private Long idAssociado;

	private boolean exibirTabInfoGerais = false;
	private boolean bloquearAbas = true;

	public boolean isSituacaoAssociadoPreCadastro() {
		return null != enumSituacaoAssociado && EnumSituacaoAssociado.PRE_CADASTRO.equals(enumSituacaoAssociado);
	}

	public Long getEnumNivelEscolaridadeIndice() {
		return getEnumNivelEscolaridade().getIndice();
	}

	public Integer getEnumConclusaoEscolaridadeIndice() {
		return getEnumConclusaoEscolaridade().getIndice();
	}

	@Override
	public DadosBancariosVO getDadosBancarios() {
		if (null == super.getDadosBancarios()) {
			setDadosBancarios(new DadosBancariosVO());
		}
		return super.getDadosBancarios();
	}

	public boolean isExibirTabInfoGerais() {
		return exibirTabInfoGerais;
	}

	public void setExibirTabInfoGerais(boolean exibirTabInfoGerais) {
		this.exibirTabInfoGerais = exibirTabInfoGerais;
	}

	public Date getDataAposentadoria() {
		return dataAposentadoria;
	}

	public void setDataAposentadoria(Date dataAposentadoria) {
		this.dataAposentadoria = dataAposentadoria;
	}

	public List<EnumTipoAposentadoria> getListEnumTipoAposentadoria() {
		if (null == listEnumTipoAposentadoria) {
			listEnumTipoAposentadoria = new ArrayList<EnumTipoAposentadoria>();
		}
		return listEnumTipoAposentadoria;
	}

	public void setListEnumTipoAposentadoria(List<EnumTipoAposentadoria> listEnumTipoAposentadoria) {
		this.listEnumTipoAposentadoria = listEnumTipoAposentadoria;
	}

	public DadosBancariosVO getDadosBancariosReembolso() {
		if (null == dadosBancariosReembolso) {
			dadosBancariosReembolso = new DadosBancariosVO();
		}
		return dadosBancariosReembolso;
	}

	public void setDadosBancariosReembolso(DadosBancariosVO dadosBancariosReembolso) {
		this.dadosBancariosReembolso = dadosBancariosReembolso;
	}

	public String getMatriculaParticipante() {
		return matriculaParticipante;
	}

	public void setMatriculaParticipante(String matriculaParticipante) {
		this.matriculaParticipante = matriculaParticipante;
	}

	public String getMatriculaRepresentante() {
		return matriculaRepresentante;
	}

	public void setMatriculaRepresentante(String matriculaRepresentante) {
		this.matriculaRepresentante = matriculaRepresentante;
	}

	public EnumSimNao getEnumSimNao() {
		return enumSimNao;
	}

	public void setEnumSimNao(EnumSimNao enumSimNao) {
		this.enumSimNao = enumSimNao;
	}

	public Date getDtCriacaoPreCadastro() {
		return dtCriacaoPreCadastro;
	}

	public void setDtCriacaoPreCadastro(Date dtCriacaoPreCadastro) {
		this.dtCriacaoPreCadastro = dtCriacaoPreCadastro;
	}

	public Date getDtAnalisePreCadastro() {
		return dtAnalisePreCadastro;
	}

	public void setDtAnalisePreCadastro(Date dtAnalisePreCadastro) {
		this.dtAnalisePreCadastro = dtAnalisePreCadastro;
	}

	public EnumSituacaoAssociado getEnumSituacaoAssociado() {
		return enumSituacaoAssociado;
	}

	public void setEnumSituacaoAssociado(EnumSituacaoAssociado enumSituacaoAssociado) {
		this.enumSituacaoAssociado = enumSituacaoAssociado;
	}

	public Date getDtInicioVinculo() {
		return dtInicioVinculo;
	}

	public void setDtInicioVinculo(Date dtInicioVinculo) {
		this.dtInicioVinculo = dtInicioVinculo;
	}

	public Date getDtDesligamentoAssociado() {
		return dtDesligamentoAssociado;
	}

	public void setDtDesligamentoAssociado(Date dtDesligamentoAssociado) {
		this.dtDesligamentoAssociado = dtDesligamentoAssociado;
	}

	public Date getDtReadmissao() {
		return dtReadmissao;
	}

	public void setDtReadmissao(Date dtReadmissao) {
		this.dtReadmissao = dtReadmissao;
	}

	public Long getIdTaxaAssociado() {
		return idTaxaAssociado;
	}

	public void setIdTaxaAssociado(Long idTaxaAssociado) {
		this.idTaxaAssociado = idTaxaAssociado;
	}

	public EnumTipoCobranca getEnumTipoCobranca() {
		return enumTipoCobranca;
	}

	public void setEnumTipoCobranca(EnumTipoCobranca enumTipoCobranca) {
		this.enumTipoCobranca = enumTipoCobranca;
	}

	public EnumGrauParentesco getEnumGrauParentesco() {
		return enumGrauParentesco;
	}

	public void setEnumGrauParentesco(EnumGrauParentesco enumGrauParentesco) {
		this.enumGrauParentesco = enumGrauParentesco;
	}

	public EnumTipoResponsavel getEnumTipoResponsavel() {
		return enumTipoResponsavel;
	}

	public void setEnumTipoResponsavel(EnumTipoResponsavel enumTipoResponsavel) {
		this.enumTipoResponsavel = enumTipoResponsavel;
	}

	public List<UsuarioAssociadoVO> getListUsuariosAssociadoVO() {
		if (null == listUsuariosAssociadoVO) {
			listUsuariosAssociadoVO = new ArrayList<UsuarioAssociadoVO>();
		}
		return listUsuariosAssociadoVO;
	}

	public void setListUsuariosAssociadoVO(List<UsuarioAssociadoVO> listUsuariosAssociadoVO) {
		this.listUsuariosAssociadoVO = listUsuariosAssociadoVO;
	}

	public EnumSimNao getEnumConclusaoEscolaridade() {
		return enumConclusaoEscolaridade;
	}

	public void setEnumConclusaoEscolaridade(EnumSimNao enumConclusaoEscolaridade) {
		this.enumConclusaoEscolaridade = enumConclusaoEscolaridade;
	}

	public EnumMotivoDesligamento getEnumMotivoDesligamento() {
		return enumMotivoDesligamento;
	}

	public void setEnumMotivoDesligamento(EnumMotivoDesligamento enumMotivoDesligamento) {
		this.enumMotivoDesligamento = enumMotivoDesligamento;
	}

	public Long getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Long idConvenio) {
		this.idConvenio = idConvenio;
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

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public boolean isBloquearAbas() {
		return bloquearAbas;
	}

	public void setBloquearAbas(boolean bloquearAbas) {
		this.bloquearAbas = bloquearAbas;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public EnumTipoAssociado getEnumTipoAssociado() {
		return enumTipoAssociado;
	}

	public void setEnumTipoAssociado(EnumTipoAssociado enumTipoAssociado) {
		this.enumTipoAssociado = enumTipoAssociado;
	}

}
