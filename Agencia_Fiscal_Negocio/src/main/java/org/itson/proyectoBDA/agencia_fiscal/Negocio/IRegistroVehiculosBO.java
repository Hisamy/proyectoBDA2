package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroVehiculosBO {

    /**
     *
     * @param nuevoVehiculo
     * @return
     * @throws PersistenciaException
     */
    Vehiculo registrarVehiculo(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    /**
     *
     * @param nuevoVehiculo
     * @return
     * @throws PersistenciaException
     */
    VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    /**
     *
     * @param clienteDTO
     * @return
     * @throws PersistenciaException
     */
    Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException;
}
