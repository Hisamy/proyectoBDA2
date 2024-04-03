package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IConsultaVehiculosBO {

    /**
     * Consulta un vehículo por su número de serie.
     *
     * @param numero_serie El número de serie del vehículo a consultar.
     * @return El vehículo consultado.
     * @throws FindException Si hay algún error al intentar encontrar el
     * vehículo en la base de datos.
     */
    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException;

    /**
     * Convierte un objeto Vehiculo a un objeto VehiculoDTO.
     *
     * @param vehiculo El objeto Vehiculo que se va a convertir.
     * @return El objeto VehiculoDTO que representa al vehículo convertido.
     * @throws FindException Si hay algún error durante el proceso de
     * conversión.
     */
    public VehiculoDTO regresaVehiculoConsultado(Vehiculo vehiculo) throws FindException;

    /**
     * Transporta los datos de un vehículo por su número de serie.
     *
     * @param numero_serie El número de serie del vehículo cuyos datos se desean
     * transportar.
     * @return Los datos del vehículo transportados.
     * @throws FindException Si hay algún error durante el transporte de datos.
     */
    public VehiculoDTO transporteDatos(String numero_serie) throws FindException;

}
