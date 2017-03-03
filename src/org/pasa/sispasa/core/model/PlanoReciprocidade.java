package org.pasa.sispasa.core.model;

import java.io.Serializable;
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

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "PLANO_RECIPROCIDADE")
@Audited
@AuditTable(value = "HIST_PLANO_RECIPROCIDADE")
public class PlanoReciprocidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PLANO_RCP", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", length = 60, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 30, nullable = false)
    private String descricao;

    @Column(name = "CD_PLANO", length = 10, nullable = false)
    private String codPlano;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    //RELACIONAMENTOS
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OPERADORA_RCP")
    @NotAudited
    private OperadoraReciprocidade OperadoraReciprocidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TP_PLANO")
    @NotAudited
    private TipoPlano tipoPlano;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CONVENIO_PLANO_RECIPROCIDADE",
            joinColumns = @JoinColumn(name = "ID_PLANO_RCP"),
            inverseJoinColumns = @JoinColumn(name = "ID_CONVENIO"))
    @NotAudited
    private List<Contato> contatos;

    public PlanoReciprocidade() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodPlano() {
        return codPlano;
    }

    public void setCodPlano(String codPlano) {
        this.codPlano = codPlano;
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

    public OperadoraReciprocidade getOperadoraReciprocidade() {
        return OperadoraReciprocidade;
    }

    public void setOperadoraReciprocidade(OperadoraReciprocidade operadoraReciprocidade) {
        OperadoraReciprocidade = operadoraReciprocidade;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
