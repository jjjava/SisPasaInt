package org.pasa.sispasa.core.vo;

import java.util.Date;

/**
 * @author Allan Garcia
 */
public class AssociadoVO {

	private Long id;
	private String empresa;
	private String matriculaPASA;
	private String matriculaOrigem;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String plano;
	private String situacao;
	private String tipoAssociado;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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

	public String getTipoAssociado() {
		return tipoAssociado;
	}

	public void setTipoAssociado(String tipoAssociado) {
		this.tipoAssociado = tipoAssociado;
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

}