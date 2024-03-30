package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

public class PlacaDTO extends TramiteDTO {

    private String numero_alfanumerico;
    private Calendar fecha_recepcion;
    private boolean activacion;
    private VehiculoDTO vehiculo;

    public PlacaDTO(
            Calendar fecha_expedicion, 
            Float costo, 
            ClienteDTO clienteDTO) {
        super(fecha_expedicion, costo, clienteDTO);
    }

    public PlacaDTO(
            VehiculoDTO vehiculo, 
            Calendar fecha_expedicion, 
            Float costo, 
            ClienteDTO clienteDTO) {
        super(fecha_expedicion, costo, clienteDTO);
        this.vehiculo = vehiculo;
    }

    public PlacaDTO(
            String numero_alfanumerico, 
            Calendar fecha_recepcion, 
            boolean activacion, 
            VehiculoDTO vehiculo, 
            Calendar fecha_expedicion,
            Float costo,
            ClienteDTO clienteDTO) {
        super(fecha_expedicion, costo, clienteDTO);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.activacion = activacion;
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

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

}
