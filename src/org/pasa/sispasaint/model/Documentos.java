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
public class Documentos extends EntidadeBase {

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
   
    @Override
    protected Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
