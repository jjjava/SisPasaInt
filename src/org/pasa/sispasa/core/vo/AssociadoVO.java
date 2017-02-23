
package org.pasa.sispasa.core.vo;

import java.util.Date;
import java.util.List;

import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;

/**
 * @author Allan Garcia
 */
public class AssociadoVO {

	private List<String> listEnumTipoAposentadoria;
	private EnumTipoAssociado tipoAssociado;

	private EmpresaVO empresaVO;

	private String situacaoFuncionario;
	private String matriculaOrigem;
	private String matrValiaPart;
	private String matriculaPASA;
	private String situacao;
	private String plano;
	private String nome;
	private String cpf;

	private Date dataNascimento;
	private Long id;

	public boolean isTipoAssociadoAtivo() {
		return EnumTipoAssociado.A == tipoAssociado;
	}

	public boolean isTipoAssociadoExEmpreAposentado() {
		return EnumTipoAssociado.E == tipoAssociado;
	}

	public boolean isTipoAssociadoPensionista() {
		return EnumTipoAssociado.P == tipoAssociado;
	}

	public String getMatriculaOrigem() {
		return matriculaOrigem;
	}

	public void setMatriculaOrigem(String matriculaOrigem) {
		this.matriculaOrigem = matriculaOrigem;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getMatriculaPASA() {
		return matriculaPASA;
	}

	public void setMatriculaPASA(String matriculaPASA) {
		this.matriculaPASA = matriculaPASA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumTipoAssociado getTipoAssociado() {
		return tipoAssociado;
	}

	public void setTipoAssociado(EnumTipoAssociado tipoAssociado) {
		this.tipoAssociado = tipoAssociado;
	}

	public List<String> getListEnumTipoAposentadoria() {
		return listEnumTipoAposentadoria;
	}

	public void setListEnumTipoAposentadoria(List<String> listEnumTipoAposentadoria) {
		this.listEnumTipoAposentadoria = listEnumTipoAposentadoria;
	}

	public String getMatrValiaPart() {
		return matrValiaPart;
	}

	public void setMatrValiaPart(String matrValiaPart) {
		this.matrValiaPart = matrValiaPart;
	}

	public EmpresaVO getEmpresaVO() {
		return empresaVO;
	}

	public void setEmpresaVO(EmpresaVO empresaVO) {
		this.empresaVO = empresaVO;
	}

	public String getSituacaoFuncionario() {
		return situacaoFuncionario;
	}

	public void setSituacaoFuncionario(String situacaoFuncionario) {
		this.situacaoFuncionario = situacaoFuncionario;
	}

}