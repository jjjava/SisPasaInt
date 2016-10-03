package org.pasa.sispasaint.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasaint.model.enun.Sexo;

/**
 *
 * @author Hudson Schumaker
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "NM_PESSOA_ABREVIADO")
    private String nomeAbreviado;

    @Column(name = "TP_SEXO")
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    @Column(name = "DT_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "DT_OBITO")
    @Temporal(TemporalType.DATE)
    private Date dataObito;

    @Column(name = "NM_MAE")
    private String nomeMae;

    @Column(name = "NM_PAI")
    private String nomePai;

    @Column(name = "EM_PESSOA")
    private String email;

    @OneToOne
    @JoinColumn(name = "ID_ENDERECO")
    Endereco endereco;

    @OneToOne
    @JoinColumn(name = "ID_DOCUMENTOS")
    Documento documentos;

    public Pessoa() {
    }

    @Override
    protected Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Documento getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documento documentos) {
        this.documentos = documentos;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
