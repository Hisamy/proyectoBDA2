package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class LicenciaDTO extends TramiteDTO {

    private Integer vigencia;

    public LicenciaDTO(Integer vigencia, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO) {
        super(fecha_expedicion, costo, clienteDTO);
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }
}
