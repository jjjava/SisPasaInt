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

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "DADOS_BANCARIOS")
public class DadosBancarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DADOS_BANC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_BANCO", length = 5)
    private String codBanco;

    @Column(name = "AGENCIA", length = 5, nullable = false)
    private String agencia;
    
    @Column(name = "CONTA", length = 10, nullable = false)
    private String conta;
    
    @Column(name = "TP_CONTA", length = 1, nullable =  false)
    private String tipoConta;
    
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAtulizacao;

    public DadosBancarios() {
    }

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

    public Date getDataAtulizacao() {
        return dataAtulizacao;
    }

    public void setDataAtulizacao(Date dataAtulizacao) {
        this.dataAtulizacao = dataAtulizacao;
    }
}
