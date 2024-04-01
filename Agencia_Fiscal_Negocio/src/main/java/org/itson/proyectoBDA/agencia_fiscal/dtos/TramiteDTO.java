package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

/**
 *
 * @author Ramosz
 */
public class TramiteDTO {

    private Calendar fecha_expedicion;
    private Float costo;
    private ClienteDTO clienteDTO;
    private Boolean estado;
    private String tipo;
    private Calendar fecha_emision;

    /**
     *
     * @param fecha_expedicion
     * @param costo
     * @param clienteDTO
     * @param estado
     * @param tipo
     * @param fecha_emision
     */
    public TramiteDTO(
            Calendar fecha_expedicion,
            Float costo,
            ClienteDTO clienteDTO,
            Boolean estado,
            String tipo,
            Calendar fecha_emision) {
        this.fecha_expedicion = fecha_expedicion;
        this.costo = costo;
        this.clienteDTO = clienteDTO;
        this.estado = estado;
        this.tipo = tipo;
        this.fecha_emision = fecha_emision;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_expedicion() {
        return fecha_expedicion;
    }

    /**
     *
     * @return
     */
    public Float getCosto() {
        return costo;
    }

    /**
     *
     * @return
     */
    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    /**
     *
     * @return
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_emision() {
        return fecha_emision;
    }

}
