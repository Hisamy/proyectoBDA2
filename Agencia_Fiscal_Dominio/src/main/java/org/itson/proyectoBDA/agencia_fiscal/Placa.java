package org.itson.proyectoBDA.agencia_fiscal;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Placa implements Serializable {

    @Id
    private String numero_alfanumerico;
    
    private Calendar fecha_emision;
    private Calendar fecha_recepcion;
    private Float costo;

    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero_alfanumerico != null ? numero_alfanumerico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.numero_alfanumerico == null && other.numero_alfanumerico != null) || (this.numero_alfanumerico != null && !this.numero_alfanumerico.equals(other.numero_alfanumerico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itson.proyectoBDA.agencia_fiscal.Placa[ id=" + numero_alfanumerico + " ]";
    }
    
}
