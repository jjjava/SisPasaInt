
package org.pasa.sispasa.core.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumGrauParentesco;
import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.enumeration.EnumSituacaoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.model.MotivoDesligamento;
import org.pasa.sispasa.core.util.Utils;

public class CadastroAssociadoVO extends FuncionarioVO {

	private List<UsuarioAssociadoVO> listUsuariosAssociadoVO;
	private List<String> listEnumTipoAposentadoria;

	private EnumMotivoDesligamento enumMotivoDesligamentoAssociado;
	private EnumSituacaoAssociado enumSituacaoAssociado;
	private EnumGrauParentesco enumGrauParentesco;
	private EnumSimNao enumConclusaoEscolaridade;
	private EnumTipoAssociado enumTipoAssociado;
	private EnumSimNao enumSimNao;

	private DadosBancariosVO dadosBancariosReembolso;
	private ConfigPagamentoVO configPagamentoVO;

	private Date dataAssociacao;
	private Date dataReadmissao;
	private Date dataDesligamentoAssociado;
	private Date dataAposentadoria;
	private Date dtCriacaoPreCadastro;
	private Date dtAnalisePreCadastro;

	private String matriculaParticipante;
	private String matriculaRepresentante;
	private String nomeAssAtalhoPesquisa;
	private String nomeTitularPensionista;
	private String cpfTitularPensionista;
	private String cpfPensionista;

	private Long idFuncionario;
	private Long idParticipante;
	private Long idAssociado;
	private Long idUsuarioLogado;

	private Long idAssocUltimaAlt;
	private String nomeAssocUltimAlt;

	private boolean exibirTabInfoGerais = false;
	private boolean dadosPreCarregados = true;
	private boolean bloquearAbas = true;
	private boolean isTelaDetalhe;

	public CadastroAssociadoVO() {
	}

	public CadastroAssociadoVO(Long idFuncionario, String nomeTitularPensionista, String cpfPensionista) {
		this.idFuncionario = idFuncionario;
		this.nomeTitularPensionista = nomeTitularPensionista;
		this.cpfPensionista = cpfPensionista;
	}

	public String getCpfPensionistaSemMascara() {
		return Utils.desformataCpfCnpj(cpfPensionista);
	}

	public MotivoDesligamento getMotivoDesligamentoAssociado() {
		return null == enumMotivoDesligamentoAssociado ? null
				: new MotivoDesligamento(getEnumMotivoDesligamentoAssociado().getIndice());
	}

	public boolean exibirConvenio() {
		return isTipoAssociadoAtivo() || isTipoAssociadoExEmpreAposentado();
	}

	public boolean isTipoAssociadoExEmpreAposentado() {
		return null != enumTipoAssociado && EnumTipoAssociado.E.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoPensionista() {
		return null != enumTipoAssociado && EnumTipoAssociado.P.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoAtivo() {
		return null != enumTipoAssociado && EnumTipoAssociado.A.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoPrePASA() {
		return null != enumTipoAssociado && EnumTipoAssociado.R.equals(enumTipoAssociado);
	}

	public boolean isSituacaoAssociadoPreCadastro() {
		// return null != enumSituacaoAssociado &&
		// EnumSituacaoAssociado.PRE_CADASTRO.equals(enumSituacaoAssociado);
		return false;
	}

	public String getCpfDeAcordoComTipoAss() {
		return isTipoAssociadoPensionista() ? getCpfPensionista() : getPessoa().getCpfSemFormatado();
	}

	public Long getEnumNivelEscolaridadeIndice() {
		return getPessoa().getEnumNivelEscolaridade().getIndice();
	}

	public Integer getEnumConclusaoEscolaridadeIndice() {
		return getEnumConclusaoEscolaridade().getIndice();
	}

	public Long getIdUsuarioUltAltDocumento() {
		if (null != getCtps().getIdUsuario()) {
			return getCtps().getIdUsuario();
		}
		return null == getPisPasep().getIdUsuario() ? null : getPisPasep().getIdUsuario();
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

	public boolean isTelaDetalhe() {
		return isTelaDetalhe;
	}

	public void setTelaDetalhe(boolean isTelaDetalhe) {
		this.isTelaDetalhe = isTelaDetalhe;
	}

	public Long getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	public void setIdUsuarioLogado(Long idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	public Long getIdAssocUltimaAlt() {
		return idAssocUltimaAlt;
	}

	public void setIdAssocUltimaAlt(Long idAssocUltimaAlt) {
		this.idAssocUltimaAlt = idAssocUltimaAlt;
	}

	public String getNomeAssocUltimAlt() {
		return nomeAssocUltimAlt;
	}

	public void setNomeAssocUltimAlt(String nomeAssocUltimAlt) {
		this.nomeAssocUltimAlt = nomeAssocUltimAlt;
	}

	public ConfigPagamentoVO getConfigPagamentoVO() {
		if (null == configPagamentoVO) {
			configPagamentoVO = new ConfigPagamentoVO();
		}
		return configPagamentoVO;
	}

	public void setConfigPagamentoVO(ConfigPagamentoVO configPagamentoVO) {
		this.configPagamentoVO = configPagamentoVO;
	}

	public String getNomeAssAtalhoPesquisa() {
		return nomeAssAtalhoPesquisa;
	}

	public void setNomeAssAtalhoPesquisa(String nomeAssAtalhoPesquisa) {
		this.nomeAssAtalhoPesquisa = nomeAssAtalhoPesquisa;
	}

	public String getNomeTitularPensionista() {
		return nomeTitularPensionista;
	}

	public void setNomeTitularPensionista(String nomeTitularPensionista) {
		this.nomeTitularPensionista = nomeTitularPensionista;
	}

	public EnumMotivoDesligamento getEnumMotivoDesligamentoAssociado() {
		return enumMotivoDesligamentoAssociado;
	}

	public void setEnumMotivoDesligamentoAssociado(EnumMotivoDesligamento enumMotivoDesligamentoAssociado) {
		this.enumMotivoDesligamentoAssociado = enumMotivoDesligamentoAssociado;
	}

	public Date getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociacao(Date dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}

	public Date getDataReadmissao() {
		return dataReadmissao;
	}

	public void setDataReadmissao(Date dataReadmissao) {
		this.dataReadmissao = dataReadmissao;
	}

	public Date getDataDesligamentoAssociado() {
		return dataDesligamentoAssociado;
	}

	public void setDataDesligamentoAssociado(Date dataDesligamentoAssociado) {
		this.dataDesligamentoAssociado = dataDesligamentoAssociado;
	}

	public boolean isDadosPreCarregados() {
		return dadosPreCarregados;
	}

	public void setDadosPreCarregados(boolean dadosPreCarregados) {
		this.dadosPreCarregados = dadosPreCarregados;
	}

	public String getCpfPensionista() {
		return cpfPensionista;
	}

	public void setCpfPensionista(String cpfPensionista) {
		this.cpfPensionista = cpfPensionista;
	}

	public EnumGrauParentesco getEnumGrauParentesco() {
		return enumGrauParentesco;
	}

	public void setEnumGrauParentesco(EnumGrauParentesco enumGrauParentesco) {
		this.enumGrauParentesco = enumGrauParentesco;
	}

	public String getCpfTitularPensionista() {
		return cpfTitularPensionista;
	}

	public void setCpfTitularPensionista(String cpfTitularPensionista) {
		this.cpfTitularPensionista = cpfTitularPensionista;
	}

}
