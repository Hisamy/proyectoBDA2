package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class LicenciaDTO extends TramiteDTO {

    private Integer vigencia;

    public LicenciaDTO(Integer vigencia, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo ,Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }
}
