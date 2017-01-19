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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumTipoEnvioCobranca;
import org.pasa.sispasa.core.enumeration.EnumTipoPagamento;

/**
 *
 * @author Allan Garcia
 *
 */
@Entity
@Table(name = "CONFIGURACAO_PAGAMENTO")
@Audited
@AuditTable(value = "HIST_CONFIGURACAO_PAGAMENTO")
public class ConfiguracaoPagamento extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONFIGURACAO_PAGAMENTO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_INCLUSAO_SISTEMA")
    private Date dataInclusaoSistema;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ULT_ATULZ")
    private Date dataUltimaAlteracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_ENVIO_COBRANCA")
    private EnumTipoEnvioCobranca enumTipoEnvioCobranca = EnumTipoEnvioCobranca.E;

    @ManyToOne
    @JoinColumn(name = "ID_CONVENIO")
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    @NotAudited
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_PARTICIPANTE")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "ID_TP_PLANO")
    @NotAudited
    private TipoPlano tipoPlano;

    public EnumTipoPagamento getTipoPagamentoAsEnum() {

        return null == tipoPagamento ? null : EnumTipoPagamento.getTipoPagamentoByIndice(tipoPagamento.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public EnumTipoEnvioCobranca getEnumTipoEnvioCobranca() {
        return enumTipoEnvioCobranca;
    }

    public void setEnumTipoEnvioCobranca(EnumTipoEnvioCobranca enumTipoEnvioCobranca) {
        this.enumTipoEnvioCobranca = enumTipoEnvioCobranca;
    }

}
