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

    public Vehiculo_Usado(
            int num_Placas_antiguas, 
            String numero_serie, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea, 
            boolean licencia_vigente) {
        super(numero_serie, modelo, color, marca, linea, licencia_vigente);
        this.num_Placas_antiguas = num_Placas_antiguas;
    }

   

    public int getNum_Placas_antiguas() {
        return num_Placas_antiguas;
    }

    public void setNum_Placas_antiguas(int num_Placas_antiguas) {
        this.num_Placas_antiguas = num_Placas_antiguas;
    }

  

}
