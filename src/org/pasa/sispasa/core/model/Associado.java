package org.pasa.sispasa.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.enumeration.EnumSimNao;
import org.pasa.sispasa.core.enumeration.EnumTipoAposentadoria;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;

/**
 *
 * @author Allan Garcia
 * @version 1.0.0
 */
@Entity
@Table(name = "ASSOCIADO")
@Audited
@AuditTable(value = "HIST_ASSOCIADO")
public class Associado extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PARTICIPANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATR_PASA")
    private String matriculaPasa;

    @Column(name = "MATR_VALIA_REPRESENTANTE")
    private String matriculaValiaRepresentante;

    @Column(name = "MATR_VALIA_PARTICIPANTE")
    private String matriculaValiaParticipante;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "IND_CURATELADO")
    private EnumSimNao indCuratelado;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "IND_TUTELADO")
    private EnumSimNao indTutelado;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_APOSENTADORIA")
    private EnumTipoAposentadoria tipoAposentadoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_ASSOCIADO")
    private EnumTipoAssociado tipoAssociado;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ASSOCIACAO")
    private Date dataAssociacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DESLIGAMENTO")
    private Date dataDesligamento;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_APOSENTADORIA")
    private Date dataAposentadoria;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ADMISSAO_GRUPO")
    private Date dataAdmissaoGrupo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DESLIGAMENTO_GRUPO")
    private Date dataDesligamentoGrupo;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INCLUSAO_SISTEMA")
    private Date dataInclusaoSistema;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ULT_ATULZ")
    private Date dataUltimaAlteracao;

    @OneToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Participante participante;

    @OneToOne
    @JoinColumn(name = "ID_ASSOCIADO_ORIGEM", referencedColumnName = "ID_PARTICIPANTE")
    private Associado associadoOrigem;

    @ManyToOne()
    @JoinColumn(name = "ID_TAXA_ASSOCIADO")
    private TaxaAssociado taxaAssociado;

    @ManyToOne()
    @JoinColumn(name = "ID_SITUACAO_ASSOCIADO")
    @NotAudited
    private SituacaoAssociado situacaoAssociado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaPasa() {
        return matriculaPasa;
    }

    public void setMatriculaPasa(String matriculaPasa) {
        this.matriculaPasa = matriculaPasa;
    }

    public String getMatriculaValiaRepresentante() {
        return matriculaValiaRepresentante;
    }

    public void setMatriculaValiaRepresentante(String matriculaValiaRepresentante) {
        this.matriculaValiaRepresentante = matriculaValiaRepresentante;
    }

    public String getMatriculaValiaParticipante() {
        return matriculaValiaParticipante;
    }

    public void setMatriculaValiaParticipante(String matriculaValiaParticipante) {
        this.matriculaValiaParticipante = matriculaValiaParticipante;
    }

    public EnumSimNao getIndCuratelado() {
        return indCuratelado;
    }

    public void setIndCuratelado(EnumSimNao indCuratelado) {
        this.indCuratelado = indCuratelado;
    }

    public EnumSimNao getIndTutelado() {
        return indTutelado;
    }

    public void setIndTutelado(EnumSimNao indTutelado) {
        this.indTutelado = indTutelado;
    }

    public EnumTipoAposentadoria getTipoAposentadoria() {
        return tipoAposentadoria;
    }

    public void setTipoAposentadoria(EnumTipoAposentadoria tipoAposentadoria) {
        this.tipoAposentadoria = tipoAposentadoria;
    }

    public EnumTipoAssociado getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(EnumTipoAssociado tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public Date getDataAposentadoria() {
        return dataAposentadoria;
    }

    public void setDataAposentadoria(Date dataAposentadoria) {
        this.dataAposentadoria = dataAposentadoria;
    }

    public Date getDataAdmissaoGrupo() {
        return dataAdmissaoGrupo;
    }

    public void setDataAdmissaoGrupo(Date dataAdmissaoGrupo) {
        this.dataAdmissaoGrupo = dataAdmissaoGrupo;
    }

    public Date getDataDesligamentoGrupo() {
        return dataDesligamentoGrupo;
    }

    public void setDataDesligamentoGrupo(Date dataDesligamentoGrupo) {
        this.dataDesligamentoGrupo = dataDesligamentoGrupo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Associado getAssociadoOrigem() {
        return associadoOrigem;
    }

    public void setAssociadoOrigem(Associado associadoOrigem) {
        this.associadoOrigem = associadoOrigem;
    }

    public TaxaAssociado getTaxaAssociado() {
        return taxaAssociado;
    }

    public void setTaxaAssociado(TaxaAssociado taxaAssociado) {
        this.taxaAssociado = taxaAssociado;
    }

    public Date getDataInclusaoSistema() {
        return dataInclusaoSistema;
    }

    public void setDataInclusaoSistema(Date dataInclusaoSistema) {
        this.dataInclusaoSistema = dataInclusaoSistema;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public SituacaoAssociado getSituacaoAssociado() {
        return situacaoAssociado;
    }

    public void setSituacaoAssociado(SituacaoAssociado situacaoAssociado) {
        this.situacaoAssociado = situacaoAssociado;
    }

}
