package org.pasa.sispasaint.model.intg;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author 90J00318
 */
@Entity
@Table(name = "LISTA_DESTINATARIO")
public class ListaDestinatarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LISTA_DESTINATARIO", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ID_DESTINARATIO")
    private Long idDestinatario;
    
    public ListaDestinatarios(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
    }
}
