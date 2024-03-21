package org.itson.proyectoBDA.agencia_fiscal.ENTIDADES;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos_nuevos")
public class Vehiculo_Nuevo extends Vehiculo implements Serializable {

    public Vehiculo_Nuevo() {
    }

    public Vehiculo_Nuevo(Long id, String modelo, String color, String marca, String linea, boolean licencia_vigente, String CURP, String numero_alfanumerico) {
        super(id, modelo, color, marca, linea, licencia_vigente, CURP, numero_alfanumerico);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo_Nuevo{");
        sb.append('}');
        return sb.toString();
    }

}
