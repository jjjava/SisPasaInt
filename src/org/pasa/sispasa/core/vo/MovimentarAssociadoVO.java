
package org.pasa.sispasa.core.vo;

import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.util.Utils;

public class MovimentarAssociadoVO {

	private List<String> listEnumTipoAposentadoria;
	private ConfigPagamentoVO configPagamentoVO;
	private EmpresaVO empresaVO;

	private EnumTipoAssociado enumTipoAssociado;
	private String situacaoFuncionario;
	private String matrValiaPart;
	private String matrOrigem;
	private String matrPASA;
	private String nome;
	private String cpf;
	private Long idFuncionario;
	private Long id;

	private EmpresaVO empresaModalVO;
	private String matrOrigemModal;
	private String situacaoModal;
	private String nomeModal;
	private Long idFuncModal;

	private EmpresaVO empresaNovoFuncVO;
	private String matrOrigemNovoFunc;
	private String situacaoNovoFunc;
	private String nomeNovoFunc;

	private boolean exibirNovoFuncionario;
	private boolean exibirNomeFuncModal;
	private boolean exibirMatrValia;

	public void limparModal() {
		setEmpresaModalVO(new EmpresaVO());
		setMatrOrigemModal(null);
		limparModalMenosFiltro();
	}

	public void limparModalMenosFiltro() {
		setExibirNomeFuncModal(false);
		setSituacaoModal(null);
		setIdFuncionario(null);
		setIdFuncModal(null);
		setNomeModal(null);
	}

	public boolean matriculaOrigemFoiAlterada() {
		return null != getIdFuncModal();
	}

	public boolean isTipoAssociadoExEmpreAposentado() {
		return null != enumTipoAssociado && EnumTipoAssociado.E.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoAtivo() {
		return null != enumTipoAssociado && EnumTipoAssociado.A.equals(enumTipoAssociado);
	}

	public String getCpfSemMascara() {
		return Utils.desformataCpfCnpj(cpf);
	}

	public EmpresaVO getEmpresaVO() {
		return empresaVO;
	}

	public void setEmpresaVO(EmpresaVO empresaVO) {
		this.empresaVO = empresaVO;
	}

	public EnumTipoAssociado getEnumTipoAssociado() {
		return enumTipoAssociado;
	}

	public void setEnumTipoAssociado(EnumTipoAssociado enumTipoAssociado) {
		this.enumTipoAssociado = enumTipoAssociado;
	}

	public String getSituacaoFuncionario() {
		return situacaoFuncionario;
	}

	public void setSituacaoFuncionario(String situacaoFuncionario) {
		this.situacaoFuncionario = situacaoFuncionario;
	}

	public String getMatrValiaPart() {
		return matrValiaPart;
	}

	public void setMatrValiaPart(String matrValiaPart) {
		this.matrValiaPart = matrValiaPart;
	}

	public String getMatrPASA() {
		return matrPASA;
	}

	public void setMatrPASA(String matrPASA) {
		this.matrPASA = matrPASA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatrOrigem() {
		return matrOrigem;
	}

	public void setMatrOrigem(String matrOrigem) {
		this.matrOrigem = matrOrigem;
	}

	public boolean isExibirMatrValia() {
		return exibirMatrValia;
	}

	public void setExibirMatrValia(boolean exibirMatrValia) {
		this.exibirMatrValia = exibirMatrValia;
	}

	public EmpresaVO getEmpresaModalVO() {
		return empresaModalVO;
	}

	public void setEmpresaModalVO(EmpresaVO empresaModalVO) {
		this.empresaModalVO = empresaModalVO;
	}

	public String getMatrOrigemModal() {
		return matrOrigemModal;
	}

	public void setMatrOrigemModal(String matrOrigemModal) {
		this.matrOrigemModal = matrOrigemModal;
	}

	public String getSituacaoModal() {
		return situacaoModal;
	}

	public void setSituacaoModal(String situacaoModal) {
		this.situacaoModal = situacaoModal;
	}

	public boolean isExibirNomeFuncModal() {
		return exibirNomeFuncModal;
	}

	public void setExibirNomeFuncModal(boolean exibirNomeFuncModal) {
		this.exibirNomeFuncModal = exibirNomeFuncModal;
	}

	public String getNomeModal() {
		return nomeModal;
	}

	public void setNomeModal(String nomeModal) {
		this.nomeModal = nomeModal;
	}

	public Long getIdFuncModal() {
		return idFuncModal;
	}

	public void setIdFuncModal(Long idFuncModal) {
		this.idFuncModal = idFuncModal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isExibirNovoFuncionario() {
		return exibirNovoFuncionario;
	}

	public void setExibirNovoFuncionario(boolean exibirNovoFuncionario) {
		this.exibirNovoFuncionario = exibirNovoFuncionario;
	}

	public EmpresaVO getEmpresaNovoFuncVO() {
		return empresaNovoFuncVO;
	}

	public void setEmpresaNovoFuncVO(EmpresaVO empresaNovoFuncVO) {
		this.empresaNovoFuncVO = empresaNovoFuncVO;
	}

	public String getMatrOrigemNovoFunc() {
		return matrOrigemNovoFunc;
	}

	public void setMatrOrigemNovoFunc(String matrOrigemNovoFunc) {
		this.matrOrigemNovoFunc = matrOrigemNovoFunc;
	}

	public String getSituacaoNovoFunc() {
		return situacaoNovoFunc;
	}

	public void setSituacaoNovoFunc(String situacaoNovoFunc) {
		this.situacaoNovoFunc = situacaoNovoFunc;
	}

	public String getNomeNovoFunc() {
		return nomeNovoFunc;
	}

	public void setNomeNovoFunc(String nomeNovoFunc) {
		this.nomeNovoFunc = nomeNovoFunc;
	}

	public List<String> getListEnumTipoAposentadoria() {
		return listEnumTipoAposentadoria;
	}

	public void setListEnumTipoAposentadoria(List<String> listEnumTipoAposentadoria) {
		this.listEnumTipoAposentadoria = listEnumTipoAposentadoria;
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

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}