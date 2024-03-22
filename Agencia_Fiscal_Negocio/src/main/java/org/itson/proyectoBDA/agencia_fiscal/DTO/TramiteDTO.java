
package org.itson.proyectoBDA.agencia_fiscal.DTO;

import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;


public class TramiteDTO {
    
    private Calendar fecha_expedicion;
    private Float costo;

    public TramiteDTO(Calendar fecha_expedicion, Float costo) {
        this.fecha_expedicion = fecha_expedicion;
        this.costo = costo;
    }


    public Calendar getFecha_expedicion() {
        return fecha_expedicion;
    }

    public Float getCosto() {
        return costo;
    }

   

    
}
