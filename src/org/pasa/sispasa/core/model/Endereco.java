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
import org.pasa.sispasa.core.util.Utils;
import org.pasa.sispasa.core.vo.EnderecoVO;
import org.pasa.sispasa.core.vo.EstadoVO;
import org.pasa.sispasa.core.vo.MunicipioVO;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "ENDERECO")
@Audited
@AuditTable(value = "HIST_ENDERECO")
public class Endereco extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ENDERECO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGRADOURO", nullable = false, length = 60)
    private String logradouro;

    @Column(name = "NUMERO", length = 20)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 45)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false, length = 45)
    private String bairro;

    @Column(name = "CEP", nullable = false, columnDefinition = ConstantesBanco.CHAR_8)
    private String cep;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @ManyToOne()
    @JoinColumn(name = "ID_MUNICIPIO")
    @NotAudited
    private Municipio municipio;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO")
    @NotAudited
    private Estado estado;

    public static Endereco getEntity(EnderecoVO enderecoVO) {
        Endereco endereco = new Endereco();
        endereco.setMunicipio(new Municipio(enderecoVO.getMunicipio().getId()));
        endereco.setEstado(new Estado(enderecoVO.getEstado().getIdEstado()));
        endereco.setIndAtivo(enderecoVO.getEnumIndAtivo().getIndice());
        endereco.setCep(Utils.desformataCep(enderecoVO.getCep()));
        endereco.setComplemento(enderecoVO.getComplemento());
        endereco.setLogradouro(enderecoVO.getLogradouro());
        endereco.setIdUsuario(enderecoVO.getIdUsuario());
        endereco.setIdUsuario(enderecoVO.getIdUsuario());
        endereco.setDataUltimaAtualizacao(new Date());
        endereco.setBairro(enderecoVO.getBairro());
        endereco.setNumero(enderecoVO.getNumero());
        endereco.setId(enderecoVO.getId());
        return endereco;
    }

    public EnderecoVO getEntityVO() {
        EnderecoVO enderecoVO = new EnderecoVO();
        enderecoVO.setMunicipio(new MunicipioVO(municipio.getId(), municipio.getNome()));
        enderecoVO.setEstado(new EstadoVO(estado.getId(), estado.getNome()));
        enderecoVO.setComplemento(getComplemento());
        enderecoVO.setLogradouro(getLogradouro());
        enderecoVO.setIdUsuario(getIdUsuario());
        enderecoVO.setBairro(getBairro());
        enderecoVO.setNumero(getNumero());
        enderecoVO.setCep(getCep());
        enderecoVO.setId(getId());
        return enderecoVO;
    }

    // GETTERS E SETTERS
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
    
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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
}
