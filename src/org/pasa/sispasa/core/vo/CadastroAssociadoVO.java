package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumGrauParentesco;
import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.enumeration.EnumSituacaoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoEnvioCobranca;
import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;
import org.pasa.sispasa.core.enumeration.EnumTipoResponsavel;
import org.pasa.sispasa.core.model.MotivoDesligamento;
import org.pasa.sispasa.core.model.TipoPagamento;

public class CadastroAssociadoVO extends FuncionarioVO {

	private List<String> listEnumTipoAposentadoria;
	private List<UsuarioAssociadoVO> listUsuariosAssociadoVO;
	private List<ConvenioVO> listConvenioVO;

	private EnumTipoEnvioCobranca enumTipoEnvioCobranca = EnumTipoEnvioCobranca.E;
	private EnumMotivoDesligamento enumMotivoDesligamentoAssociado;
	private EnumSituacaoAssociado enumSituacaoAssociado;
	private EnumTipoResponsavel enumTipoResponsavel;
	private EnumGrauParentesco enumGrauParentesco;
	private EnumSimNao enumConclusaoEscolaridade;
	private EnumTipoAssociado enumTipoAssociado;
	private EnumTipoPagamento enumTipoPagamento;
	private EnumSimNao enumSimNao;

	private DadosBancariosVO dadosBancariosReembolso;
	private ConvenioVO convenioVO;

	private Date dataAposentadoria;
	private Date dtCriacaoPreCadastro;
	private Date dtAnalisePreCadastro;
	private Date dtReadmissao;
	private Date dtInicioVinculo;
	private Date dtDesligamentoAssociado;
	private String matriculaParticipante;
	private String matriculaRepresentante;
	private Long idTaxaAssociado;

	private Long idFuncionario;
	private Long idParticipante;
	private Long idAssociado;

	private boolean exibirTabInfoGerais = false;
	private boolean bloquearAbas = true;
	private boolean isTelaDetalhe;

	public boolean isEnumTipoPagamentoBoleto() {
		return EnumTipoPagamento.BOLETO.equals(enumTipoPagamento);
	}

	public boolean isTipoAssociadoPensionista() {
		return null != enumTipoAssociado && EnumTipoAssociado.P.equals(enumTipoAssociado);
	}

	public boolean isSituacaoAssociadoPreCadastro() {
		return null != enumSituacaoAssociado && EnumSituacaoAssociado.PRE_CADASTRO.equals(enumSituacaoAssociado);
	}

	public Long getEnumNivelEscolaridadeIndice() {
		return getEnumNivelEscolaridade().getIndice();
	}

	public Integer getEnumConclusaoEscolaridadeIndice() {
		return getEnumConclusaoEscolaridade().getIndice();
	}

	public TipoPagamento getTipoPagamento() {
		return new TipoPagamento(enumTipoPagamento.getIndice());
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

	public MotivoDesligamento getMotivoDesligamento() {
		return null == getEnumMotivoDesligamento() ? null
				: new MotivoDesligamento(getEnumMotivoDesligamento().getIndice());
	}

	public MotivoDesligamento getMotivoDesligamentoAssociado() {
		return null == enumMotivoDesligamentoAssociado ? null
				: new MotivoDesligamento(getEnumMotivoDesligamentoAssociado().getIndice());
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

	public List<String> getListEnumTipoAposentadoria() {
		if (null == listEnumTipoAposentadoria) {
			listEnumTipoAposentadoria = new ArrayList<>();
		}
		return listEnumTipoAposentadoria;
	}

	public void setListEnumTipoAposentadoria(List<String> listEnumTipoAposentadoria) {
		this.listEnumTipoAposentadoria = listEnumTipoAposentadoria;
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

	public EnumMotivoDesligamento getEnumMotivoDesligamentoAssociado() {
		return enumMotivoDesligamentoAssociado;
	}

	public void setEnumMotivoDesligamentoAssociado(EnumMotivoDesligamento enumMotivoDesligamentoAssociado) {
		this.enumMotivoDesligamentoAssociado = enumMotivoDesligamentoAssociado;
	}

	public ConvenioVO getConvenioVO() {
		return convenioVO;
	}

	public void setConvenioVO(ConvenioVO convenioVO) {
		this.convenioVO = convenioVO;
	}

	public boolean isTelaDetalhe() {
		return isTelaDetalhe;
	}

	public void setTelaDetalhe(boolean isTelaDetalhe) {
		this.isTelaDetalhe = isTelaDetalhe;
	}

}
