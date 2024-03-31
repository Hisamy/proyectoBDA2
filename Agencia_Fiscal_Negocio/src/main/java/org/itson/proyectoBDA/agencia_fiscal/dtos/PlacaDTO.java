package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class PlacaDTO extends TramiteDTO {

    private String numero_alfanumerico;
    private Calendar fecha_recepcion;
    private VehiculoDTO vehiculo;

    public PlacaDTO(
            Calendar fecha_expedicion, 
            Float costo, 
            ClienteDTO clienteDTO,
            Boolean estado,
            String tipo,
            Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
    }

    public PlacaDTO(String numero_alfanumerico, Calendar fecha_recepcion, VehiculoDTO vehiculo, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo, Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }

    public PlacaDTO(VehiculoDTO vehiculo, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo, Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.vehiculo = vehiculo;
    }



    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

}
