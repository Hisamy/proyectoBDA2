package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "tramites")
@DiscriminatorColumn(name = "tipo_tramite")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    public Long id;

    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_expedicion;
    
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_emision;

    @Column(name = "tipo_tramite", nullable = false, length = 20)
    private String tipo_tramite;

    @Column(name = "costo", nullable = false, length = 50)
    private Float costo;
    
    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    /**
     *
     */
    public Tramite() {
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
    public Tramite(
            Long id, 
            Calendar fecha_expedicion, 
            String tipo_tramite,
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        this.id = id;
        this.fecha_expedicion = fecha_expedicion;
        this.tipo_tramite = tipo_tramite;
        this.costo = costo;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
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
    public Tramite(
            Calendar fecha_expedicion, 
            String tipo_tramite, 
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        this.fecha_expedicion = fecha_expedicion;
        this.tipo_tramite = tipo_tramite;
        this.costo = costo;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
    }

    /**
     *
     * @param fecha_expedicion
     * @param costo
     * @param cliente
     * @param estado
     * @param fecha_emision
     */
    public Tramite(
            Calendar fecha_expedicion, 
            Float costo, 
            Cliente cliente, 
            Boolean estado,
            Calendar fecha_emision) {
        this.fecha_expedicion = fecha_expedicion;
        this.costo = costo;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_expedicion() {
        return fecha_expedicion;
    }

    /**
     *
     * @param fecha_expedicion
     */
    public void setFecha_expedicion(Calendar fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    /**
     *
     * @return
     */
    public String getTipo_tramite() {
        return tipo_tramite;
    }

    /**
     *
     * @param tipo_tramite
     */
    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }

    /**
     *
     * @return
     */
    public Float getCosto() {
        return costo;
    }

    /**
     *
     * @param costo
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_emision() {
        return fecha_emision;
    }

    /**
     *
     * @param fecha_emision
     */
    public void setFecha_emision(Calendar fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "org.itson.proyectoBDA.agencia_fiscal.Tramite[ id=" + id + " ]";
    }

}
