package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumBanco;
import org.pasa.sispasa.core.enumeration.EnumIndAtivo;
import org.pasa.sispasa.core.enumeration.EnumTipoConta;
import org.pasa.sispasa.core.vo.DadosBancariosVO;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "DADOS_BANCARIOS")
@Audited
@AuditTable(value = "HIST_DADOS_BANCARIOS")
public class DadosBancarios extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DADOS_BANC", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_BANCO", length = 5)
    private String codBanco;

    @Column(name = "AGENCIA", nullable = false, length = 5)
    private String agencia;

    @Column(name = "CONTA", nullable = false, length = 10)
    private String conta;

    @Column(name = "TP_CONTA", nullable = false, columnDefinition = ConstantesBanco.CHAR_1)
    private String tipoConta;

    @Column(name = "ID_USUARIO", columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ULT_ATULZ", nullable = false, columnDefinition = ConstantesBanco.DATE)
    private Date dataUltimaAtualizacao;

    public DadosBancarios() {
    }

    public DadosBancariosVO getEntityVO() {
        DadosBancariosVO vo = new DadosBancariosVO();
        vo.setId(getId());
        vo.setIdUsuario(getIdUsuario());
        vo.setEnumIndAtivo(EnumIndAtivo.getIndAtivoByIndice(getIndAtivo()));
        vo.setDataUltimaAtualizacao(getDataUltimaAtualizacao());
        vo.setAgencia(getAgencia());
        vo.setConta(getConta());
        vo.setEnumBanco(EnumBanco.getBancoByIndice(getCodBanco()));
        vo.setEnumTipoConta(EnumTipoConta.getTipoContaByIndice(getTipoConta()));
        return vo;
    }

    public static DadosBancarios getEntity(DadosBancariosVO vo) {
        return getEntity(new DadosBancarios(), vo);
    }

    public static DadosBancarios getEntity(DadosBancarios dadosBancarios, DadosBancariosVO vo) {
        dadosBancarios.setId(vo.getId());
        dadosBancarios.setIndAtivo(vo.getEnumIndAtivo().getIndice());
        dadosBancarios.setDataUltimaAtualizacao(new Date());
        dadosBancarios.setCodBanco(vo.getEnumBanco().getIndice());
        dadosBancarios.setTipoConta(vo.getEnumTipoConta().getIndice());
        dadosBancarios.setAgencia(vo.getAgencia());
        dadosBancarios.setConta(vo.getConta());
        return dadosBancarios;
    }

    // GETTERS E SETTERS
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
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

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

}
