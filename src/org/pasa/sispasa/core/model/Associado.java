package org.pasa.sispasa.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
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
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumMotivoDesligamento;
import org.pasa.sispasa.core.enumeration.EnumSituacaoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoAposentadoria;
import org.pasa.sispasa.core.enumeration.EnumTipoAssociado;
import org.pasa.sispasa.core.enumeration.EnumTipoRespPagamento;

/**
 *
 * @author Allan Garcia
 * @author Hudson Schumaker
 *
 */
@Entity
@Table(name = "ASSOCIADO",
        indexes = {@Index(name = "MATR_PASA_IDX", columnList = "MATR_PASA", unique = false),
        @Index(name = "ID_FUNCIONARIO_ASSC_IDX", columnList = "ID_FUNCIONARIO", unique = false)})
@Audited
@AuditTable(value = "HIST_ASSOCIADO")
public class Associado extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PARTICIPANTE", columnDefinition = ConstantesBanco.BIGINT)
    private Long id;

    @Column(name = "MATR_PASA", length = 15)
    private String matriculaPasa;

    @Column(name = "MATR_VALIA_REPRESENTANTE", length = 15)
    private String matriculaValiaRepresentante;

    @Column(name = "MATR_VALIA_PARTICIPANTE", length = 15)
    private String matriculaValiaParticipante;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_RESPONSAVEL_PAGAMENTO", columnDefinition = ConstantesBanco.CHAR_1, nullable = false)
    private EnumTipoRespPagamento tipoRespPagamento;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TP_APOSENTADORIA", columnDefinition = ConstantesBanco.SMALLINT)
    private EnumTipoAposentadoria tipoAposentadoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_ASSOCIADO", nullable = false)
    private EnumTipoAssociado tipoAssociado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ASSOCIACAO")
    private Date dataAssociacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_APOSENTADORIA")
    private Date dataAposentadoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ADMISSAO_GRUPO")
    private Date dataAdmissaoGrupo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_DESLIGAMENTO_GRUPO")
    private Date dataDesligamentoGrupo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_DESLIGAMENTO_ASSOCIACAO")
    private Date dataDesligamentoAssociacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_READMISSAO")
    private Date dataReadmissao;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ULT_ATULZ", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "ID_MOTIVO_DESLIGAMENTO_GRUPO")
    @NotAudited
    private MotivoDesligamento motivoDesligamentoGrupo;

    @ManyToOne
    @JoinColumn(name = "ID_MOTIVO_DESLIGAMENTO_ASSOCIADO")
    @NotAudited
    private MotivoDesligamento motivoDesligamentoAssociado;

    @ManyToOne
    @JoinColumn(name = "ID_TAXA_ASSOCIADO")
    private TaxaAssociado taxaAssociado;

    @ManyToOne
    @JoinColumn(name = "ID_SITUACAO_ASSOCIADO")
    @NotAudited
    private SituacaoAssociado situacaoAssociado;

    @ManyToOne
    @JoinColumn(name = "ID_RESPONSAVEL_LEGAL")
    @NotAudited
    private ResponsavelLegal responsavelLegal;

    public boolean possuiResponsavelLegal() {
        return null != responsavelLegal;
    }

    public boolean isTipoRespPagamentoTitular() {
        return null != tipoRespPagamento && EnumTipoRespPagamento.T == tipoRespPagamento;
    }

    public boolean isSituacaoAssociadoInativo() {
        return EnumSituacaoAssociado.INATIVO == getSituacaoAssociadoAsEnum();
    }

    public boolean isMotivoDesligAssociadoFalecimento() {
        return null != motivoDesligamentoAssociado
                && EnumMotivoDesligamento.FALECIMENTO == getMotivoDesligamentoAssociadoAsEnum();
    }

    public boolean isTipoAssociadoAtivo() {
        return EnumTipoAssociado.A.equals(tipoAssociado);
    }

    public boolean isTipoAssociadoExEmpregadoAposentado() {
        return EnumTipoAssociado.E.equals(tipoAssociado);
    }

    public boolean isTipoAssociadoPensionista() {
        return EnumTipoAssociado.P.equals(tipoAssociado);
    }

    public EnumSituacaoAssociado getSituacaoAssociadoAsEnum() {
        return EnumSituacaoAssociado.getFromIndice(situacaoAssociado.getId());
    }

    public EnumMotivoDesligamento getMotivoDesligamentoGrupoAsEnum() {
        if (null == motivoDesligamentoGrupo) {
            return null;
        }
        return EnumMotivoDesligamento.getFromIndice(motivoDesligamentoGrupo.getId());
    }

    public EnumMotivoDesligamento getMotivoDesligamentoAssociadoAsEnum() {
        if (null == motivoDesligamentoAssociado) {
            return null;
        }
        return EnumMotivoDesligamento.getFromIndice(motivoDesligamentoAssociado.getId());
    }

    @Override
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

    public Date getDataDesligamentoAssociacao() {
        return dataDesligamentoAssociacao;
    }

    public void setDataDesligamentoAssociacao(Date dataDesligamentoAssociacao) {
        this.dataDesligamentoAssociacao = dataDesligamentoAssociacao;
    }

    public MotivoDesligamento getMotivoDesligamentoGrupo() {
        return motivoDesligamentoGrupo;
    }

    public void setMotivoDesligamentoGrupo(MotivoDesligamento motivoDesligamentoGrupo) {
        this.motivoDesligamentoGrupo = motivoDesligamentoGrupo;
    }

    public MotivoDesligamento getMotivoDesligamentoAssociado() {
        return motivoDesligamentoAssociado;
    }

    public void setMotivoDesligamentoAssociado(MotivoDesligamento motivoDesligamentoAssociado) {
        this.motivoDesligamentoAssociado = motivoDesligamentoAssociado;
    }

    public Date getDataReadmissao() {
        return dataReadmissao;
    }

    public void setDataReadmissao(Date dataReadmissao) {
        this.dataReadmissao = dataReadmissao;
    }

    public EnumTipoRespPagamento getTipoRespPagamento() {
        return tipoRespPagamento;
    }

    public void setTipoRespPagamento(EnumTipoRespPagamento tipoRespPagamento) {
        this.tipoRespPagamento = tipoRespPagamento;
    }

    public ResponsavelLegal getResponsavelLegalNotNull() {
        if (null == responsavelLegal) {
            responsavelLegal = new ResponsavelLegal();
        }
        return responsavelLegal;
    }

    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

}
