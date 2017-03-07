package org.pasa.sispasa.core.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "NUCLEO_MUNICIPIO")
@Audited
@AuditTable(value = "HIST_NUCLEO_MUNICIPIO")
public class NucleoMunicipio implements Serializable {

    private static final long serialVersionUID = -2793490234034205366L;

    @EmbeddedId
    private NucleoMunicipioPk pk;

    public NucleoMunicipioPk getPk() {
        return pk;
    }

    public void setPk(NucleoMunicipioPk pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
        NucleoMunicipio other = (NucleoMunicipio) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }
        return true;
    }
}
