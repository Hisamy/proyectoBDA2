package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ramosz
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    @Column(name = "numero_serie", unique = true)
    private String numero_serie;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "modelo", nullable = false, length = 20)
    private Integer modelo;

    @Column(name = "color", nullable = false, length = 20)
    private String color;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "linea", nullable = false, length = 100)
    private String linea;
 

    @Column(name = "licencia_vigente", nullable = false)
    private boolean licencia_vigente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placa;

    /**
     *
     */
    public Vehiculo() {
    }

    /**
     *
     * @param id
     * @param numero_serie
     * @param tipo
     * @param modelo
     * @param color
     * @param marca
     * @param linea
     * @param licencia_vigente
     * @param cliente
     * @param placa
     */
    public Vehiculo(
            Long id,
            String numero_serie, 
            String tipo, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea, 
            boolean licencia_vigente, 
            Cliente cliente, 
            List<Placa> placa) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
        this.cliente = cliente;
        this.placa = placa;
    }

    /**
     *
     * @param numero_serie
     * @param tipo
     * @param modelo
     * @param color
     * @param marca
     * @param linea
     * @param licencia_vigente
     */
    public Vehiculo(
            String numero_serie, 
            String tipo, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea, 
            boolean licencia_vigente) {
        this.numero_serie = numero_serie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
    }

    /**
     *
     * @param numero_serie
     * @param tipo
     * @param modelo
     * @param color
     * @param marca
     * @param linea
     * @param licencia_vigente
     * @param cliente
     */
    public Vehiculo(
            String numero_serie, 
            String tipo, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea, 
            boolean licencia_vigente, 
            Cliente cliente) {
        this.numero_serie = numero_serie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
        this.cliente = cliente;
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
    public String getNumero_serie() {
        return numero_serie;
    }

    /**
     *
     * @param numero_serie
     */
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public Integer getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     *
     * @return
     */
    public boolean isLicencia_vigente() {
        return licencia_vigente;
    }

    /**
     *
     * @param licencia_vigente
     */
    public void setLicencia_vigente(boolean licencia_vigente) {
        this.licencia_vigente = licencia_vigente;
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
    public List<Placa> getPlaca() {
        return placa;
    }

    /**
     *
     * @param placa
     */
    public void setPlaca(List<Placa> placa) {
        this.placa = placa;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
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
        return "org.itson.proyectoBDA.agencia_fiscal.Vehiculo[ id=" + id + " ]";
    }

}
