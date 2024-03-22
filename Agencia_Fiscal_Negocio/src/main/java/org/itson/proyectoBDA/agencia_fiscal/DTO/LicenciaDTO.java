
package org.itson.proyectoBDA.agencia_fiscal.DTO;

import java.util.Calendar;


public class LicenciaDTO extends TramiteDTO{
    
    private Integer vigencia;

    public LicenciaDTO(Integer vigencia, Calendar fecha_expedicion, Float costo) {
        super(fecha_expedicion, costo);
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }
     
    
    
}
