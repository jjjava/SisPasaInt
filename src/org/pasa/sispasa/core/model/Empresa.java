package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_EMPRESA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RZ_SOCIAL", length = 60)
    private String razaoSocial;

    @Column(name = "NM_FANTASIA", length = 60)
    private String nomeFantasia;

    @Column(name = "CNPJ", length = 14)
    private String cnpj;

    @Column(name = "DT_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "DT_FIM")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(name = "CD_CNAE", length = 7)
    private String codCNAE;

    @Column(name = "EMAIL", length = 60)
    private String email;

    @Column(name = "CD_EMPRESA_VALE", length = 30, nullable = false)
    private String codEmpresaVale;

    @Column(name = "IND_ATIVO", nullable = false)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAtulizacao;

    @ManyToOne
    @JoinColumn(name = "ID_TP_EMPRESA")
    private TipoEmpresa tipoEmpresa;

    @ManyToMany
    @JoinTable(name = "ENDERECO_EMPRESA",
            joinColumns = @JoinColumn(name = "ID_EMPRESA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private List<Endereco> enderecos;

    @ManyToMany
    @JoinTable(name = "CONTATO_EMPRESA",
            joinColumns = @JoinColumn(name = "ID_EMPRESA"),
            inverseJoinColumns = @JoinColumn(name = "ID_CONTATO"))
    private List<Contato> contatos;

    public Empresa() {
        enderecos = new ArrayList<>();
        contatos = new ArrayList<>();
    }

    public void addEndereco(Endereco e) {
        enderecos.add(e);
    }

    public void addContato(Contato c) {
        contatos.add(c);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getCodCNAE() {
        return codCNAE;
    }

    public void setCodCNAE(String codCNAE) {
        this.codCNAE = codCNAE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodEmpresaVale() {
        return codEmpresaVale;
    }

    public void setCodEmpresaVale(String codEmpresaVale) {
        this.codEmpresaVale = codEmpresaVale;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Date getDataAtulizacao() {
        return dataAtulizacao;
    }

    public void setDataAtulizacao(Date dataAtulizacao) {
        this.dataAtulizacao = dataAtulizacao;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
