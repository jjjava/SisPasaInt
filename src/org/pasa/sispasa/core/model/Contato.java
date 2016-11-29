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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "CONTATO")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONTATO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", length = 60, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 60)
    private String email;

    @Column(name = "SETOR", length = 30)
    private String setor;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUltAtulizacao;

    @ManyToMany(mappedBy = "contatos")
    private List<Empresa> empresa;

    @ManyToMany(mappedBy = "contatos")
    private List<OperadoraReciprocidade> operadoraReciprocidades;

    @ManyToMany
    @JoinTable(name = "CONTATO_TELEFONE",
            joinColumns = @JoinColumn(name = "ID_CONTATO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE"))
    private List<Telefone> telefones;

    public Contato() {
        telefones = new ArrayList<>();
    }
    
    public void addTelefone(Telefone t){
        telefones.add(t);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Date getDataUltAtulizacao() {
        return dataUltAtulizacao;
    }

    public void setDataUltAtulizacao(Date dataUltAtulizacao) {
        this.dataUltAtulizacao = dataUltAtulizacao;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }

    public List<OperadoraReciprocidade> getOperadoraReciprocidades() {
        return operadoraReciprocidades;
    }

    public void setOperadoraReciprocidades(List<OperadoraReciprocidade> operadoraReciprocidades) {
        this.operadoraReciprocidades = operadoraReciprocidades;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
