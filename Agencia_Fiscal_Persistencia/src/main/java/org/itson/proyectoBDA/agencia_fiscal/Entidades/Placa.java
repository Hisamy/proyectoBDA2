package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "placas")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero_alfanumerico")
    private String numero_alfanumerico;

    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_recepcion;

    @Column(name = "activacion", nullable = false)
    private boolean activacion;

    @Column(name = "numero_serie", nullable = false, length = 7)
    private String numero_serie;

    public Placa() {
    }

    public Placa(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public Placa(String numero_alfanumerico, Calendar fecha_recepcion, boolean activacion, String numero_serie) {
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.activacion = activacion;
        this.numero_serie = numero_serie;
    }

    public Placa(Long id, Calendar fecha_expedicion, Float costo, Cliente cliente) {
        super(id, fecha_expedicion, costo, cliente);
    }

    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.numero_alfanumerico);
        hash = 23 * hash + Objects.hashCode(this.fecha_recepcion);
        hash = 23 * hash + (this.activacion ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.numero_serie);
        return hash;
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
        final Placa other = (Placa) obj;
        if (this.activacion != other.activacion) {
            return false;
        }
        if (!Objects.equals(this.numero_alfanumerico, other.numero_alfanumerico)) {
            return false;
        }
        if (!Objects.equals(this.numero_serie, other.numero_serie)) {
            return false;
        }
        return Objects.equals(this.fecha_recepcion, other.fecha_recepcion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa{");
        sb.append("numero_alfanumerico=").append(numero_alfanumerico);
        sb.append(", fecha_recepcion=").append(fecha_recepcion);
        sb.append(", activacion=").append(activacion);
        sb.append(", numero_serie=").append(numero_serie);
        sb.append('}');
        return sb.toString();
    }

}
