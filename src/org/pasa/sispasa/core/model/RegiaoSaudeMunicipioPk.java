package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RegiaoSaudeMunicipioPk implements Serializable {

    private static final long serialVersionUID = -3442804092146521838L;

    @ManyToOne
    @JoinColumn(name = "ID_REGIAO_SAUDE")
    private RegiaoSaude regiaoSaude;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO")
    private Municipio municipio;

    public RegiaoSaude getRegiaoSaude() {
        return regiaoSaude;
    }

    public void setRegiaoSaude(RegiaoSaude regiaoSaude) {
        this.regiaoSaude = regiaoSaude;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
        result = prime * result + ((regiaoSaude == null) ? 0 : regiaoSaude.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RegiaoSaudeMunicipioPk other = (RegiaoSaudeMunicipioPk) obj;
        if (municipio == null) {
            if (other.municipio != null) {
                return false;
            }
        } else if (!municipio.equals(other.municipio)) {
            return false;
        }
        if (regiaoSaude == null) {
            if (other.regiaoSaude != null) {
                return false;
            }
        } else if (!regiaoSaude.equals(other.regiaoSaude)) {
            return false;
        }
        return true;
    }

}
