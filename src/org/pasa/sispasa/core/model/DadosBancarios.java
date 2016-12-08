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
import javax.persistence.Transient;

import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasa.core.enumeration.EnumBanco;
import org.pasa.sispasa.core.enumeration.EnumTipoConta;

/**
 *
 * @author Hudson Schumaker / Andre Gomes
 * @version 1.0.0
 */
@Entity
@Table(name = "DADOS_BANCARIOS")
public class DadosBancarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DADOS_BANC", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_BANCO", length=5)
    private String codBanco;
    
    @Transient
    private EnumBanco enumBanco;

    @Column(name = "AGENCIA", nullable = false,length=5)
    private String agencia;
    
    @Column(name = "CONTA", nullable = false, length=10)
    private String conta;
    
    @Column(name = "TP_CONTA", nullable =  false, columnDefinition = ConstantesBanco.CHAR_1)
    private String tipoConta;
    
    @Transient
    private EnumTipoConta enumTipoConta;
    
    @Column(name = "ID_USUARIO", columnDefinition = ConstantesBanco.BIGINT)
    private Long idUsuario;

    @Column(name = "IND_ATIVO", nullable = false, columnDefinition = ConstantesBanco.SMALLINT)
    private Integer indAtivo;

    @Column(name = "DT_ULT_ATULZ", nullable = false, columnDefinition = ConstantesBanco.DATE)
    @Temporal(TemporalType.DATE)
    private Date dataUltimaAtualizacao;


    
    //GETTERS E SETTERS
    
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
        return dataUltimaAtualizacao;
    }

    public void setDataAtulizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

	/**
	 * @return the enumBanco
	 */
	public EnumBanco getEnumBanco() {
		return enumBanco;
	}

	/**
	 * @param enumBanco the enumBanco to set
	 */
	public void setEnumBanco(EnumBanco enumBanco) {
		this.enumBanco = enumBanco;
	}

	/**
	 * @return the dataUltimaAtualizacao
	 */
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	/**
	 * @param dataUltimaAtualizacao the dataUltimaAtualizacao to set
	 */
	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	/**
	 * @return the enumTipoConta
	 */
	public EnumTipoConta getEnumTipoConta() {
		return enumTipoConta;
	}

	/**
	 * @param enumTipoConta the enumTipoConta to set
	 */
	public void setEnumTipoConta(EnumTipoConta enumTipoConta) {
		this.enumTipoConta = enumTipoConta;
	}
}
