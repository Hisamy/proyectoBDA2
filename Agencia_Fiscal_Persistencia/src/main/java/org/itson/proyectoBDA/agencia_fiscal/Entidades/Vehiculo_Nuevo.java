package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos_nuevos")
public class Vehiculo_Nuevo extends Vehiculo implements Serializable {

    public Vehiculo_Nuevo() {
    }

    public Vehiculo_Nuevo(String numero_serie, Integer modelo, String color, String marca, String linea, boolean licencia_vigente) {
        super(numero_serie, modelo, color, marca, linea, licencia_vigente);
    }

    

 
}
