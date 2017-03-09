package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class NucleoMunicipioPk implements Serializable {

    private static final long serialVersionUID = 8930464237217543002L;

    @ManyToOne
    @JoinColumn(name = "COD_NUCLEO")
    private Nucleo nucleo;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO")
    private Municipio municipio;

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
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
        result = prime * result + ((nucleo == null) ? 0 : nucleo.hashCode());
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
        NucleoMunicipioPk other = (NucleoMunicipioPk) obj;
        if (municipio == null) {
            if (other.municipio != null) {
                return false;
            }
        } else if (!municipio.equals(other.municipio)) {
            return false;
        }
        if (nucleo == null) {
            if (other.nucleo != null) {
                return false;
            }
        } else if (!nucleo.equals(other.nucleo)) {
            return false;
        }
        return true;
    }
}
