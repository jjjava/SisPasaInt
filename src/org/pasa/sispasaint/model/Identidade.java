package org.pasa.sispasaint.model;

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
@Table(name = "IDENTIDADE")
public class Identidade extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_IDENTIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ENTIDADE")
    private Long idEntidade;

    @Column(name = "NR_IDENTIDADE")
    private String numeroIdentidade;

    @Column(name = "NM_ORGAO_EMISSOR")
    private String orgaoEmissor;

    @Column(name = "DT_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    public Identidade() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Long idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getNumeroIdentidade() {
        return numeroIdentidade;
    }

    public void setNumeroIdentidade(String numeroIdentidade) {
        this.numeroIdentidade = numeroIdentidade;
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
}
