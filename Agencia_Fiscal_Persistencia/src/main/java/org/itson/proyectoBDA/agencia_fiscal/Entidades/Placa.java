package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(String numero_alfanumerico, Calendar fecha_recepcion, boolean activacion, Vehiculo vehiculo, Calendar fecha_expedicion, Float costo, Cliente cliente) {
        super(fecha_expedicion, costo, cliente);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.activacion = activacion;
        this.vehiculo = vehiculo;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
