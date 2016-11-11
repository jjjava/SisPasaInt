package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGRADOURO", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "NUMERO", length = 20, nullable = false)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 45)
    private String complemento;

    @Column(name = "BAIRRO", length = 45, nullable = false)
    private String bairro;

    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "IND_ATIVO", nullable = false)
    private int indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtulizacao;

    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @ManyToMany(mappedBy = "enderecos")
    private List<Empresa> empresa;

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(int indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Date getDataAtulizacao() {
        return dataAtulizacao;
    }

    public void setDataAtulizacao(Date dataAtulizacao) {
        this.dataAtulizacao = dataAtulizacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }
}
