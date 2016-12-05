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
 * @author Hudson Schumaker
 */

@Entity
@Table(name = "CARG_LISTA_DESTINATARIO")
public class ListaDestinatarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ID_LISTA", columnDefinition = ConstantesBanco.BIGINT)
    private Long idLista;
    
    @Column(name = "ID_DESTINATARIO")
    private Long idDestinatario;
    
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    
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

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
