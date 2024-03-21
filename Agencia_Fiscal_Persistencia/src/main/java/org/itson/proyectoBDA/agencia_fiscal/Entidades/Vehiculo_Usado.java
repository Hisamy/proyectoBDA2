package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos_usados")
public class Vehiculo_Usado extends Vehiculo implements Serializable {

    @Column(name = "num_Placas_antiguas", nullable = false)
    private int num_Placas_antiguas;

    public Vehiculo_Usado() {
    }

    public Vehiculo_Usado(int num_Placas_antiguas) {
        this.num_Placas_antiguas = num_Placas_antiguas;
    }

    public Vehiculo_Usado(Long id, String modelo, String color, String marca, String linea, boolean licencia_vigente, String CURP, String numero_alfanumerico) {
        super(id, modelo, color, marca, linea, licencia_vigente, CURP, numero_alfanumerico);
    }

    public int getNum_Placas_antiguas() {
        return num_Placas_antiguas;
    }

    public void setNum_Placas_antiguas(int num_Placas_antiguas) {
        this.num_Placas_antiguas = num_Placas_antiguas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.num_Placas_antiguas;
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
        final Vehiculo_Usado other = (Vehiculo_Usado) obj;
        return this.num_Placas_antiguas == other.num_Placas_antiguas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo_Usado{");
        sb.append("num_Placas_antiguas=").append(num_Placas_antiguas);
        sb.append('}');
        return sb.toString();
    }

}
