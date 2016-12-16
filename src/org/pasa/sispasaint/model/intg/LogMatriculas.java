package org.pasa.sispasaint.model.intg;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.pasa.sispasa.core.constants.ConstantesBanco;

/**
 *
 * @author 90J00318
 */
@Entity
@Table(name = "CARG_LOG_MATRICULAS")
public class LogMatriculas implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOG_MATRICULAS", columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Log log;
    
    public LogMatriculas(){
    }
    
    public LogMatriculas(String matricula){
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
