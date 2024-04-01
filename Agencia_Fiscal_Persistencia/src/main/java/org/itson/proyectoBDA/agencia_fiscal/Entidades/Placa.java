package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ramosz
 */
@Entity
@Table(name = "placas")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero_alfanumerico")
    private String numero_alfanumerico;

    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_recepcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private Vehiculo vehiculo;

    /**
     *
     */
    public Placa() {
    }

    /**
     *
     * @param id
     * @param fecha_expedicion
     * @param tipo_tramite
     * @param costo
     * @param cliente
     * @param estado
     * @param fecha_emision
     */
    public Placa(
            Long id, 
            Calendar fecha_expedicion, 
            String tipo_tramite, 
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        super(id, fecha_expedicion, tipo_tramite, costo, cliente, estado, fecha_emision);
    }
    
    /**
     *
     * @param numero_alfanumerico
     * @param fecha_recepcion
     * @param vehiculo
     * @param fecha_expedicion
     * @param tipo_tramite
     * @param costo
     * @param cliente
     * @param estado
     * @param fecha_emision
     */
    public Placa(
            String numero_alfanumerico, 
            Calendar fecha_recepcion, 
            Vehiculo vehiculo, 
            Calendar fecha_expedicion, 
            String tipo_tramite, 
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        super(fecha_expedicion, tipo_tramite, costo, cliente, estado, fecha_emision);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }
    
    /**
     *
     * @param numero_alfanumerico
     * @param fecha_recepcion
     * @param vehiculo
     */
    public Placa(String numero_alfanumerico, Calendar fecha_recepcion, Vehiculo vehiculo) {
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }
    
    /**
     *
     * @param numero_alfanumerico
     * @param fecha_recepcion
     * @param vehiculo
     * @param fecha_expedicion
     * @param costo
     * @param cliente
     * @param estado
     * @param fecha_emision
     */
    public Placa(
            String numero_alfanumerico, 
            Calendar fecha_recepcion, 
            Vehiculo vehiculo, 
            Calendar fecha_expedicion, 
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        super(fecha_expedicion, costo, cliente, estado, fecha_emision);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * @param fecha_expedicion
     * @param tipo_tramite
     * @param costo
     * @param cliente
     * @param estado
     * @param fecha_emision
     */
    public Placa(Calendar fecha_expedicion, String tipo_tramite, Float costo, Cliente cliente, Boolean estado, Calendar fecha_emision) {
        super(fecha_expedicion, tipo_tramite, costo, cliente, estado, fecha_emision);
    }
    
    /**
     *
     * @return
     */
    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    /**
     *
     * @param numero_alfanumerico
     */
    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     *
     * @param fecha_recepcion
     */
    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     *
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     *
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
