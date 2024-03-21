package org.itson.proyectoBDA.agencia_fiscal.ENTIDADES;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_serie")
    private Long id;

    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;

    @Column(name = "color", nullable = false, length = 20)
    private String color;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "linea", nullable = false, length = 100)
    private String linea;

    @Column(name = "licencia_vigente", nullable = false)
    private boolean licencia_vigente;

    @Column(name = "CURP", nullable = false, length = 20)
    private String CURP;

    @Column(name = "numero_alfanumerico", nullable = false, length = 10)
    private String numero_alfanumerico;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String modelo, String color, String marca, String linea, boolean licencia_vigente, String CURP, String numero_alfanumerico) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
        this.CURP = CURP;
        this.numero_alfanumerico = numero_alfanumerico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public boolean isLicencia_vigente() {
        return licencia_vigente;
    }

    public void setLicencia_vigente(boolean licencia_vigente) {
        this.licencia_vigente = licencia_vigente;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.itson.proyectoBDA.agencia_fiscal.Vehiculo[ id=" + id + " ]";
    }

}
