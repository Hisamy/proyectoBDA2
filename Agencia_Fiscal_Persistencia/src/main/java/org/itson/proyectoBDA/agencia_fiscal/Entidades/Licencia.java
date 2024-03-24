package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licencias")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licencia")
    private Long id;

    @Column(name = "vigencia", nullable = false, length = 5)
    private Integer vigencia;

    public Licencia() {
    }

    public Licencia(Calendar fecha_expedicion, Float costo, Long id_cliente) {
        super(fecha_expedicion, costo, id_cliente);
    }

    public Licencia(Long id, Calendar fecha_expedicion, Float costo, Long id_cliente) {
        super(id, fecha_expedicion, costo, id_cliente);
    }

    public Licencia(Long id, Integer vigencia) {
        this.id = id;
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itson.proyectoBDA.agencia_fiscal.Licencia[ id=" + id + " ]";
    }

}
