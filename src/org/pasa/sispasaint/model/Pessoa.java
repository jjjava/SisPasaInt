package org.pasa.sispasaint.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasaint.model.enun.NivelEscolaridade;
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

    @OneToOne
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;
    
    @OneToOne
    @JoinColumn(name = "ID_DADOS_BANCARIOS")
    private DadosBancarios dadosBancarios;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DOCUMENTO_PESSOA", joinColumns = {
        @JoinColumn(name = "ID_PESSOA")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_DOCUMENTO")})
    private List<Documento> listaDocumentos;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TELEFONE_PESSOA", joinColumns = {
        @JoinColumn(name = "ID_PESSOA")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_TELEFONE")})
    private List<Telefone> listaTelefone;

    @Column(name = "NV_ESCOLARIDADE")
    @Enumerated(EnumType.ORDINAL)
    private NivelEscolaridade nivelEscolaridade;

    @Column(name = "BL_INDICADOR_CONCLUSAO")
    private Integer indicadorConclusao;

    public Pessoa() {
        listaDocumentos = new ArrayList<>();
        listaTelefone = new ArrayList<>();
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

    public void addDocumento(Documento doc) {
        listaDocumentos.add(doc);
    }
    
    public void addTelefone(Telefone tel){
        listaTelefone.add(tel);
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

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public NivelEscolaridade getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setNivelEscolaridade(NivelEscolaridade nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public Integer getIndicadorConclusao() {
        return indicadorConclusao;
    }

    public void setIndicadorConclusao(Integer indicadorConclusao) {
        this.indicadorConclusao = indicadorConclusao;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    } 
}
