package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumIndAtivo;
import org.pasa.sispasa.core.enumeration.EnumTipoTelefone;
import org.pasa.sispasa.core.util.Utils;
import org.pasa.sispasa.core.vo.TelefoneVO;

/**
 *
 * @author Hudson Schumaker
 * @author Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "TELEFONE")
@Audited
@AuditTable(value = "HIST_TELEFONE")
public class Telefone extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TELEFONE", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DDD", columnDefinition = ConstantesBanco.CHAR_2)
    private String ddd;

    @Column(name = "NUMERO", length = 18, nullable = false)
    private String numeroTelefone;

    @Column(name = "RAMAL", length = 5)
    private String ramal;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo = EnumIndAtivo.ATIVO.getIndice();

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @OneToOne
    @NotAudited
    private TipoTelefone tipoTelefone;
    
    public Telefone() {
    }

    public Telefone(Long id) {
        this.id = id;
    }

    public static Telefone getEntity(TelefoneVO vo) {
        String temp = Utils.desformataTelefone(vo.getNumeroTelefoneComDDD());
        Telefone telefone = new Telefone();
        telefone.setId(vo.getId());
        telefone.setRamal(vo.getRamal());
        telefone.setDataUltimaAtualizacao(new Date());
        telefone.setDdd(Utils.retornaDDDTelefone(temp));
        telefone.setNumeroTelefone(Utils.retornaNumeroTelefone(temp));
        telefone.setTipoTelefone(new TipoTelefone(vo.getEnumTipoTelefone().getId()));
        telefone.setIdUsuario(1L);
        return telefone;
    }

    public TelefoneVO getEntityVO() {
        return new TelefoneVO(id, ddd + numeroTelefone, ramal, tipoTelefone.getAsEnum());
    }

    public boolean isTipoTelfoneComercial() {
        return null != tipoTelefone && EnumTipoTelefone.COMERCIAL.getId().equals(tipoTelefone.getId());
    }

    public boolean isTipoTelfoneCelular() {
        return null != tipoTelefone && EnumTipoTelefone.CELULAR.getId().equals(tipoTelefone.getId());
    }

    public boolean isTipoTelfoneResidencial() {
        return null != tipoTelefone && EnumTipoTelefone.RESIDENCIAL.getId().equals(tipoTelefone.getId());
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Integer getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Integer indAtivo) {
        this.indAtivo = indAtivo;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
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
}
