package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IRegistroVehiculosBO {

    /**
     * Registra un nuevo vehículo.
     *
     * @param nuevoVehiculo El objeto DTO que representa el nuevo vehículo.
     * @return El vehículo registrado.
     * @throws PersistenciaException si ocurre un error durante la persistencia.
     */
    public Vehiculo registrarVehiculo(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    /**
     * Transporta los datos de un vehículo.
     *
     * @param nuevoVehiculo El objeto DTO que representa los datos del vehículo.
     * @return Los datos del vehículo transportados.
     * @throws PersistenciaException si ocurre un error durante el transporte de
     * datos.
     */
    public VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    /**
     * Convierte un objeto DTO de cliente en un objeto cliente.
     *
     * @param clienteDTO El objeto DTO de cliente.
     * @return El objeto cliente convertido.
     * @throws PersistenciaException si ocurre un error durante la conversión.
     */
    Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException;

    /**
     * Valida un vehículo.
     *
     * @param numero_serie
     * @return 
     * @throws PersistenciaException si ocurre un error durante la validación.
     */
    public boolean validarVehiculo(String numero_serie) throws PersistenciaException;

}
