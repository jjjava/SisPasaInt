package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_PESSOA", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CPF", columnDefinition = ConstantesBanco.CHAR_11)
    private String cpf;
    
    @Column(name = "NOME", length = 60, nullable = false)
    private String nome;

    @Column(name = "NM_ABREVIADO", length = 60)
    private String nomeAbreviado;

    @Column(name = "DT_NASCIMENTO", nullable = false, columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "DT_OBITO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataObito;

    @Column(name = "DT_INCLUSAO_SISTEMA", columnDefinition = ConstantesBanco.DATE, nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dataInclusaoSistema;

    @Column(name = "DT_INATIVACAO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataIn;

    @Column(name = "SEXO", columnDefinition = ConstantesBanco.CHAR_1)
    private String sexo;
	
    @Column(name = "NM_MAE", length = 60, nullable = false)
    private String nomeMae;

    @Column(name = "NM_PAI", length = 60)
    private String nomePai;

    @Column(name = "EMAIL", length = 60)
    private String email;

    @Column(name = "ID_CONCL_ESCOL", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indConclusaoEscolaridade;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA",  columnDefinition = ConstantesBanco.BIGINT),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO",  columnDefinition = ConstantesBanco.BIGINT))
    private List<Endereco> enderecos;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "PESSOA_TELEFONE",
            joinColumns = @JoinColumn(name = "ID_PESSOA",  columnDefinition = ConstantesBanco.BIGINT),
            inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE",  columnDefinition = ConstantesBanco.BIGINT))
    private List<Telefone> telefones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DOCUMENTO_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PESSOA",  columnDefinition = ConstantesBanco.BIGINT),
            inverseJoinColumns = @JoinColumn(name = "ID_DOCUMENTO",  columnDefinition = ConstantesBanco.BIGINT))
    private List<Documento> documentos;
    
    @ManyToOne()
    @JoinColumn(name = "ID_PAIS")
    private Pais nacionalidade;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO")
    private Estado naturalidade;

    @ManyToOne()
    @JoinColumn(name = "ID_MUNICIPIO")
    private Municipio cidadeOrigem;

    @ManyToOne()
    @JoinColumn(name = "ID_NIVEL_ESCOL")
    private NivelEscolaridade nivelEscolaridade;
    

    @ManyToOne()
    @JoinColumn(name = "ID_ORIGEM_INFO", nullable = false)
    private OrigemInformacoes origemInformacoes;
    
    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO_CIVIL")
    private EstadoCivil estadoCivil;
    
    public Pessoa() {
        telefones = new ArrayList<>();
        enderecos = new ArrayList<>();
        documentos = new ArrayList<>();
    }

    
    //GETTERS E SETTERS
    
    public void addTelefone(Telefone t){
        telefones.add(t);
    }
    
    public void addEndereco(Endereco e){
        enderecos.add(e);
    }
    
    public void addDocumento(Documento d){
        documentos.add(d);
    }
    
    @Override
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

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
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

    public Date getDataInclusaoSistema() {
        return dataInclusaoSistema;
    }

    public void setDataInclusaoSistema(Date dataInclusaoSistema) {
        this.dataInclusaoSistema = dataInclusaoSistema;
    }

    public Date getDataIn() {
        return dataIn;
    }

    public void setDataIn(Date dataIn) {
        this.dataIn = dataIn;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public Integer getIndConclusaoEscolaridade() {
        return indConclusaoEscolaridade;
    }

    public void setIndConclusaoEscolaridade(Integer indConclusaoEscolaridade) {
        this.indConclusaoEscolaridade = indConclusaoEscolaridade;
    }

    public NivelEscolaridade getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setNivelEscolaridade(NivelEscolaridade nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public OrigemInformacoes getOrigemInformacoes() {
        return origemInformacoes;
    }

    public void setOrigemInformacoes(OrigemInformacoes origemInformacoes) {
        this.origemInformacoes = origemInformacoes;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


	/**
	 * @return the nacionalidade
	 */
	public Pais getNacionalidade() {
		return nacionalidade;
	}


	/**
	 * @param nacionalidade the nacionalidade to set
	 */
	public void setNacionalidade(Pais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	/**
	 * @return the naturalidade
	 */
	public Estado getNaturalidade() {
		return naturalidade;
	}


	/**
	 * @param naturalidade the naturalidade to set
	 */
	public void setNaturalidade(Estado naturalidade) {
		this.naturalidade = naturalidade;
	}


	/**
	 * @return the cidadeOrigem
	 */
	public Municipio getCidadeOrigem() {
		return cidadeOrigem;
	}


	/**
	 * @param cidadeOrigem the cidadeOrigem to set
	 */
	public void setCidadeOrigem(Municipio cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}


	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}


	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones() {
		return telefones;
	}


	/**
	 * @return the documentos
	 */
	public List<Documento> getDocumentos() {
		return documentos;
	}
}
