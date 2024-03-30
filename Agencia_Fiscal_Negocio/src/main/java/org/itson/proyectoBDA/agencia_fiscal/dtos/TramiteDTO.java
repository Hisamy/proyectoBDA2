package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class TramiteDTO {

    private Calendar fecha_expedicion;
    private Float costo;
    private ClienteDTO clienteDTO;

    
    public TramiteDTO(Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO) {
        this.fecha_expedicion = fecha_expedicion;
        this.costo = costo;
        this.clienteDTO = clienteDTO;
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
    


}
