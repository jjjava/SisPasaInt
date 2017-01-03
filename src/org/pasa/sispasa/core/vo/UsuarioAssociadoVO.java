package org.pasa.sispasa.core.vo;

public class UsuarioAssociadoVO {

	private String empresa;
	private String carteirinha;
	private String matriculaPASA;
	private String nome;
	private String tipo;
	private String plano;
	private String status;

	public static UsuarioAssociadoVO getMock() {

		UsuarioAssociadoVO usuarioAssociadoVO = new UsuarioAssociadoVO();
		usuarioAssociadoVO.setEmpresa("VALE");
		usuarioAssociadoVO.setCarteirinha("1478574985");
		usuarioAssociadoVO.setMatriculaPASA("88796541124");
		usuarioAssociadoVO.setNome("João da Silva Souza Junior");
		usuarioAssociadoVO.setTipo("Agregado");
		usuarioAssociadoVO.setPlano("PASA Empresa Plus");
		usuarioAssociadoVO.setStatus("Ativo");

		return usuarioAssociadoVO;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCarteirinha() {
		return carteirinha;
	}

	public void setCarteirinha(String carteirinha) {
		this.carteirinha = carteirinha;
	}

	public String getMatriculaPASA() {
		return matriculaPASA;
	}

	public void setMatriculaPASA(String matriculaPASA) {
		this.matriculaPASA = matriculaPASA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
