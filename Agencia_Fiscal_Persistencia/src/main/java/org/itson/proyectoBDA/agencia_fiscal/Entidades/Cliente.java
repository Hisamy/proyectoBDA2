package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ramosz
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(name = "CURP", nullable = false, length = 50)
    private String CURP;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellido_materno;

    @Column(name = "discapacidad", nullable = true)
    private boolean discapacidad;

    @Column(name = "RFC", nullable = false, length = 20)
    private String RFC;

    @Column(name = "telefono", nullable = false, length = 255)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "cliente")
    private List<Tramite> tramites;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "cliente")
    private List<Vehiculo> vehiculos;

    /**
     *
     */
    public Cliente() {
    }

    /**
     *
     * @param CURP
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param discapacidad
     * @param RFC
     * @param telefono
     * @param fecha_nacimiento
     */
    public Cliente(
            String CURP,
            String nombre,
            String apellido_paterno,
            String apellido_materno,
            boolean discapacidad,
            String RFC,
            String telefono,
            Calendar fecha_nacimiento) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacidad = discapacidad;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @param id_cliente
     * @param CURP
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param discapacidad
     * @param RFC
     * @param telefono
     * @param fecha_nacimiento
     */
    public Cliente(
            Long id_cliente,
            String CURP,
            String nombre,
            String apellido_paterno,
            String apellido_materno,
            boolean discapacidad,
            String RFC,
            String telefono,
            Calendar fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacidad = discapacidad;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @param CURP
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param discapacidad
     * @param RFC
     * @param telefono
     * @param fecha_nacimiento
     * @param tramites
     * @param vehiculos
     */
    public Cliente(
            String CURP,
            String nombre,
            String apellido_paterno,
            String apellido_materno,
            boolean discapacidad,
            String RFC,
            String telefono,
            Calendar fecha_nacimiento,
            List<Tramite> tramites,
            List<Vehiculo> vehiculos) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacidad = discapacidad;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tramites = tramites;
        this.vehiculos = vehiculos;
    }

    /**
     *
     * @return
     */
    public Long getId_cliente() {
        return id_cliente;
    }

    /**
     *
     * @param id_cliente
     */
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public String getCURP() {
        return CURP;
    }

    /**
     *
     * @param CURP
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     *
     * @param apellido_paterno
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     *
     * @return
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     *
     * @param apellido_materno
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     *
     * @return
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     *
     * @param discapacidad
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     *
     * @return
     */
    public String getRFC() {
        return RFC;
    }

    /**
     *
     * @param RFC
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     *
     * @param fecha_nacimiento
     */
    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @return
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     *
     * @param tramites
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     *
     * @return
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     *
     * @param vehiculos
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cliente != null ? id_cliente.hashCode() : 0);
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id_cliente == null && other.id_cliente != null) || (this.id_cliente != null && !this.id_cliente.equals(other.id_cliente))) {
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
        return "org.itson.proyectoBDA.agencia_fiscal.Persona[ id=" + id_cliente + " ]";
    }

}
