package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

/**
 *
 * @author Ramosz
 */
public class LicenciaDTO extends TramiteDTO {

    private Integer vigencia;

    /**
     *
     * @param vigencia
     * @param fecha_expedicion
     * @param costo
     * @param clienteDTO
     * @param estado
     * @param tipo
     * @param fecha_emision
     */
    public LicenciaDTO(Integer vigencia, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo ,Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.vigencia = vigencia;
    }

    /**
     *
     * @return
     */
    public Integer getVigencia() {
        return vigencia;
    }
}
