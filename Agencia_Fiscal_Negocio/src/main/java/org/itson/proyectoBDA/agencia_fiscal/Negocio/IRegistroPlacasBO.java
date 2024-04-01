package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroPlacasBO {

    /**
     *
     * @param nuevaPlaca
     * @param vehiculo
     * @return
     * @throws PersistenciaException
     */
    Placa registrarPlaca(PlacaDTO nuevaPlaca, Vehiculo vehiculo) throws PersistenciaException;

    /**
     *
     * @param nuevaPlaca
     * @return
     * @throws PersistenciaException
     */
    PlacaDTO transporteDatos(PlacaDTO nuevaPlaca) throws PersistenciaException;

    /**
     *
     * @param nuevaPlaca
     * @return
     * @throws PersistenciaException
     */
    VehiculoDTO conversorVehiculoDTO(PlacaDTO nuevaPlaca) throws PersistenciaException;

    /**
     *
     * @return
     * @throws PersistenciaException
     */
    Calendar getFechaRecepcion() throws PersistenciaException;
}
