package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class TramiteDTO {

    private Calendar fecha_expedicion;
    private Float costo;
    private ClienteDTO clienteDTO;
    private Boolean estado;
    private String tipo;
    private Calendar fecha_emision;

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

    public Calendar getFecha_expedicion() {
        return fecha_expedicion;
    }

    public Float getCosto() {
        return costo;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public Calendar getFecha_emision() {
        return fecha_emision;
    }

}
