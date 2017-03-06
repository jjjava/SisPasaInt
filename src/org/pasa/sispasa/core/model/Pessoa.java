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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumEstadoCivil;
import org.pasa.sispasa.core.enumeration.EnumNivelEscolaridade;
import org.pasa.sispasa.core.enumeration.EnumSexo;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.util.Utils;

/**
 *
 * @author Hudson Schumaker 
 * @author Andre Gomes
 * @version 2.0.0
 */
@Entity
@Table(name = "PESSOA")
@Audited
@AuditTable(value = "HIST_PESSOA")
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

    @Column(name = "DT_INCLUSAO_SISTEMA", columnDefinition = ConstantesBanco.DATE, nullable = false)
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

    //RELACIONAMENTOS
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"), 
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    @NotAudited
    private List<Endereco> enderecos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PESSOA_TELEFONE",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_TELEFONE"))
    @NotAudited
    private List<Telefone> telefones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DOCUMENTO_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_DOCUMENTO"))
    @NotAudited
    private List<Documento> documentos;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    @NotAudited
    private Pais nacionalidade;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    @NotAudited
    private Estado naturalidade;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO")
    @NotAudited
    private Municipio cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "ID_NIVEL_ESCOL")
    @NotAudited
    private NivelEscolaridade nivelEscolaridade;

    @ManyToOne
    @JoinColumn(name = "ID_ORIGEM_INFO", nullable = false)
    @NotAudited
    private OrigemInformacoes origemInformacoes;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO_CIVIL")
    @NotAudited
    private EstadoCivil estadoCivil;

    // CONSTRUTORES
    public Pessoa() {
        telefones = new ArrayList<>();
        enderecos = new ArrayList<>();
        documentos = new ArrayList<>();
    }

    // METODOS ADD
    public void addTelefone(Telefone t) {
        telefones.add(t);
    }

    public void addEndereco(Endereco e) {
        enderecos.add(e);
    }

    public void addDocumento(Documento d) {
        documentos.add(d);
    }

    public Documento getDocumentoRG() {
        for (Documento documento : documentos) {
            if (documento.isTipoDocumentoRG()) {
                return documento;
            }
        }
        return null;
    }

    public Documento getDocumentoCTPS() {
        for (Documento documento : documentos) {
            if (documento.isTipoDocumentoCTPS()) {
                return documento;
            }
        }
        return null;
    }

    public Documento getDocumentoPIS() {
        for (Documento documento : documentos) {
            if (documento.isTipoDocumentoPIS()) {
                return documento;
            }
        }
        return null;
    }

    public Telefone getTelefoneResidencial() {
        for (Telefone tel : telefones) {
            if (tel.isTipoTelfoneResidencial()) {
                return tel;
            }
        }
        return null;
    }

    public Telefone getTelefoneComercial() {
        for (Telefone tel : telefones) {
            if (tel.isTipoTelfoneComercial()) {
                return tel;
            }
        }
        return null;
    }

    public Telefone getTelefoneCelular() {
        for (Telefone tel : telefones) {
            if (tel.isTipoTelfoneCelular()) {
                return tel;
            }
        }
        return null;
    }

    public EnumNivelEscolaridade getNivelEscolaridadeAsEnum() {
        return EnumNivelEscolaridade.getNivelEscolaridadeByIndice(getNivelEscolaridade().getId());
	}

	public EnumSexo getSexoAsEnum() {
		return EnumSexo.getSexoByIndice(getSexo());
	}

	public EnumEstadoCivil getEstadoCivilAsEnum() {
		return EnumEstadoCivil.getEstadoCivilByIndice(estadoCivil.getId());
	}
	
	public String getCpfFormatado() {
        return Utils.formataCpf(cpf);
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

	public EnumSimNao getIndConclusaoEscolaridadeAsEnum() {
		return EnumSimNao.valueFromIndice(getIndConclusaoEscolaridade());
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

    public Pais getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Pais nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Estado getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Estado naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Municipio getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Municipio cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Documento> getDocumentos() {
        if (null == documentos) {
            documentos = new ArrayList<>();
        }
        return documentos;
    }
}
