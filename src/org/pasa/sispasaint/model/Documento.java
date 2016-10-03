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
 * @author 90J00318
 */
@Entity
@Table(name = "DOCUMENTO")
public class Documento extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DOCUMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "NM_ORGAO_EMISSOR")
    private String orgaoEmissor;

    @Column(name = "DT_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    
    public Documento() {
    }

    @Override
    protected Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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
