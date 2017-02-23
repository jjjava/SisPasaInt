
package org.pasa.sispasa.core.vo;

import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;

public class MovimentarAssociadoVO {

	private List<String> listEnumTipoAposentadoria;
	private EmpresaVO empresaVO;


	private EnumTipoAssociado enumTipoAssociado;
	private String situacaoFuncionario;
	private String matrValiaPart;
	private String matrOrigem;
	private String matrPASA;
	private String nome;
	private Long id;
	
	private EmpresaVO empresaModalVO;
	private String matrOrigemModal;
	private String situacaoModal;
	private String nomeModal;
	private Long idFuncModal;

	private boolean exibirTipoPensionista;
	private boolean exibirMatrValia;
	private boolean exibirNomeFuncModal;

	public void limparModal() {
		setEmpresaModalVO(new EmpresaVO());
		setMatrOrigemModal(null);
		limparModalMenosFiltro();
	}
	
	public void limparModalMenosFiltro() {		
		setExibirNomeFuncModal(false);		
		setSituacaoModal(null);
		setIdFuncModal(null);
		setNomeModal(null);
	}

	public boolean isTipoAssociadoExEmpreAposentado() {
		return null != enumTipoAssociado && EnumTipoAssociado.E.equals(enumTipoAssociado);
	}

	public boolean isTipoAssociadoAtivo() {
		return null != enumTipoAssociado && EnumTipoAssociado.A.equals(enumTipoAssociado);
	}

	public List<String> getListEnumTipoAposentadoria() {
		return listEnumTipoAposentadoria;
	}

	public void setListEnumTipoAposentadoria(List<String> listEnumTipoAposentadoria) {
		this.listEnumTipoAposentadoria = listEnumTipoAposentadoria;
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

	public boolean isExibirTipoPensionista() {
		return exibirTipoPensionista;
	}

	public void setExibirTipoPensionista(boolean exibirTipoPensionista) {
		this.exibirTipoPensionista = exibirTipoPensionista;
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

}