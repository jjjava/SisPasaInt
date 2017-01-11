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
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumIndAtivo;
import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.core.vo.DocumentoVO;
import org.pasa.sispasa.core.vo.EstadoVO;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "DOCUMENTO")
@Audited
@AuditTable(value = "HIST_DOCUMENTO")
public class Documento extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DOCUMENTO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO", nullable = false, length = 20)
    private String numero;

    @Column(name = "ORGAO_EMISSOR", length = 30)
    private String orgaoEmissor;

    @Column(name = "SERIE", length = 10)
    private String serie;

    @Column(name = "DATA_EMISSAO", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "DATA_VALIDADE", columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo = EnumIndAtivo.ATIVO.getIndice();

    // RELACIONAMENTOS
    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO")
    @NotAudited
    private Estado estado;

    @ManyToOne()
    @JoinColumn(name = "ID_TP_DOCUMENTO")
    @NotAudited
    private TipoDocumento tipoDocumento;

    public DocumentoVO getEntityVO() {

        DocumentoVO documentoVO = new DocumentoVO();
        documentoVO.setId(getId());
        documentoVO.setIdUsuario(getIdUsuario());
        documentoVO.setEnumIndAtivo(EnumIndAtivo.getIndAtivoByIndice(getIndAtivo()));
        documentoVO.setDataUltimaAtualizacao(getDataUltimaAtualizacao());
        documentoVO.setNumero(getNumero());
        documentoVO.setDataEmissao(getDataEmissao());
        documentoVO.setDataValidade(getDataValidade());
        documentoVO.setSerie(getSerie());
        documentoVO.setOrgaoEmissor(getOrgaoEmissor());
        documentoVO.setEnumTipoDocumento(EnumTipoDocumento.getTipoDocumentoByIndice(getTipoDocumento().getId().intValue()));

        if (null != documentoVO.getEstadoEmissor()) {
            documentoVO.setEstadoEmissor(new EstadoVO(getEstado().getId(), getEstado().getNome()));
        }
        return documentoVO;
    }

    public static Documento getEntity(DocumentoVO documentoVO) {
        Documento documento = new Documento();
        documento.setId(documentoVO.getId());
        documento.setIdUsuario(null == documentoVO.getIdUsuario() ? 1L : documentoVO.getIdUsuario());
        documento.setIndAtivo(null == documentoVO.getEnumIndAtivo() ? EnumIndAtivo.ATIVO.getIndice(): documentoVO.getEnumIndAtivo().getIndice());
        documento.setDataUltimaAtualizacao(null == documentoVO.getDataUltimaAtualizacao() ? new Date() : documentoVO.getDataUltimaAtualizacao());
        documento.setNumero(documentoVO.getNumero());
        documento.setDataEmissao(documentoVO.getDataEmissao());
        documento.setSerie(documentoVO.getSerie());
        documento.setOrgaoEmissor(documentoVO.getOrgaoEmissor());
        documento.setTipoDocumento(new TipoDocumento(documentoVO.getEnumTipoDocumento().getIndice()));

        return documento;
    }

    public boolean isTipoDocumentoRG() {
        return EnumTipoDocumento.RG.getIndice().equals(tipoDocumento.getId());
    }

    public boolean isTipoDocumentoCTPS() {
        return EnumTipoDocumento.CTPS.getIndice().equals(tipoDocumento.getId());
    }

    public boolean isTipoDocumentoPIS() {
        return EnumTipoDocumento.PIS_PASEP.getIndice().equals(tipoDocumento.getId());
    }

    @Override
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }
}
