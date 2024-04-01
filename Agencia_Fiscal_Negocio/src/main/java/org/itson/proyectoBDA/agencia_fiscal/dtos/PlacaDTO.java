package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

/**
 *
 * @author Ramosz
 */
public class PlacaDTO extends TramiteDTO {

    private String numero_alfanumerico;
    private Calendar fecha_recepcion;
    private VehiculoDTO vehiculo;

    /**
     *
     * @param fecha_expedicion
     * @param costo
     * @param clienteDTO
     * @param estado
     * @param tipo
     * @param fecha_emision
     */
    public PlacaDTO(
            Calendar fecha_expedicion, 
            Float costo, 
            ClienteDTO clienteDTO,
            Boolean estado,
            String tipo,
            Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
    }

    /**
     *
     * @param numero_alfanumerico
     * @param fecha_recepcion
     * @param vehiculo
     * @param fecha_expedicion
     * @param costo
     * @param clienteDTO
     * @param estado
     * @param tipo
     * @param fecha_emision
     */
    public PlacaDTO(String numero_alfanumerico, Calendar fecha_recepcion, VehiculoDTO vehiculo, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo, Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.numero_alfanumerico = numero_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * @param vehiculo
     * @param fecha_expedicion
     * @param costo
     * @param clienteDTO
     * @param estado
     * @param tipo
     * @param fecha_emision
     */
    public PlacaDTO(VehiculoDTO vehiculo, Calendar fecha_expedicion, Float costo, ClienteDTO clienteDTO, Boolean estado, String tipo, Calendar fecha_emision) {
        super(fecha_expedicion, costo, clienteDTO, estado, tipo, fecha_emision);
        this.vehiculo = vehiculo;
    }

    /**
     *
     * @return
     */
    public String getNumero_alfanumerico() {
        return numero_alfanumerico;
    }

    /**
     *
     * @param numero_alfanumerico
     */
    public void setNumero_alfanumerico(String numero_alfanumerico) {
        this.numero_alfanumerico = numero_alfanumerico;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     *
     * @param fecha_recepcion
     */
    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     *
     * @return
     */
    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     *
     * @param vehiculo
     */
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

}
