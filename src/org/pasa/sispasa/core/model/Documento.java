package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pasa.sispasa.core.constants.ConstantesBanco;

@Entity
@Table(name = "DOCUMENTO")
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DOCUMENTO",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO", length = 20, nullable = false)
    private String numero;

    @Column(name = "ORGAO_EMISSOR", length = 30)
    private String orgaoEmissor;

    @Column(name = "DATA_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "DATA_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUltimaAtulizacao;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "ID_TP_DOCUMENTO")
    private TipoDocumento tipoDocumento;

    public Documento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataUltimaAtulizacao() {
        return dataUltimaAtulizacao;
    }

    public void setDataUltimaAtulizacao(Date dataUltimaAtulizacao) {
        this.dataUltimaAtulizacao = dataUltimaAtulizacao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
