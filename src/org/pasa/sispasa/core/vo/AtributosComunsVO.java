package org.pasa.sispasa.core.vo;

import java.util.Date;

import org.pasa.sispasa.core.enumeration.EnumIndAtivo;

/**
 * @author Andre Gomes
 */
public class AtributosComunsVO {

    protected Long id;
    protected EnumIndAtivo enumIndAtivo = EnumIndAtivo.ATIVO;
    protected Date dataUltimaAtualizacao;
    protected Long idUsuario;
    protected String nomeUsuario;

    //GETTERS AND SETTERS
    public EnumIndAtivo getEnumIndAtivo() {
        return enumIndAtivo;
    }

    public void setEnumIndAtivo(EnumIndAtivo enumIndAtivo) {
        this.enumIndAtivo = enumIndAtivo;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
