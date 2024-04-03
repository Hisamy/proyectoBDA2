package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IRegistroPlacasBO {

    /**
     * Registra una nueva placa en la base de datos, asociada a un vehículo.
     *
     * @param nuevaPlaca El objeto PlacaDTO que representa la nueva placa a
     * registrar.
     * @param vehiculo El vehículo al que se asociará la placa.
     * @return La placa registrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    Placa registrarPlaca(PlacaDTO nuevaPlaca, Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Transporta los datos de una placa.
     *
     * @param nuevaPlaca El objeto PlacaDTO que contiene los datos de la placa a
     * transportar.
     * @return El objeto PlacaDTO transportado.
     * @throws PersistenciaException Si ocurre un error durante el transporte de
     * datos.
     */
    PlacaDTO transporteDatos(PlacaDTO nuevaPlaca) throws PersistenciaException;

    /**
     * Convierte un objeto PlacaDTO a un objeto VehiculoDTO.
     *
     * @param nuevaPlaca El objeto PlacaDTO que se va a convertir.
     * @return El objeto VehiculoDTO convertido.
     * @throws PersistenciaException Si ocurre un error durante la conversión.
     */
    VehiculoDTO conversorVehiculoDTO(PlacaDTO nuevaPlaca) throws PersistenciaException;

    /**
     * Obtiene la fecha de recepción actual.
     *
     * @return La fecha de recepción actual.
     * @throws PersistenciaException Si ocurre un error al obtener la fecha de
     * recepción.
     */
    Calendar getFechaRecepcion() throws PersistenciaException;

}
