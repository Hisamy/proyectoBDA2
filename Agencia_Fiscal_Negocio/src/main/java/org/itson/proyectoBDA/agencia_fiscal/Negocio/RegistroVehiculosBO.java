package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.VehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class RegistroVehiculosBO implements IRegistroVehiculosBO {

    IConexion conexion = new Conexion();
    VehiculosDAO vehiculoDAO = new VehiculosDAO(conexion);

    /**
     * Registra un nuevo vehículo en el sistema utilizando los datos
     * proporcionados en un objeto VehiculoDTO.
     *
     * @param nuevoVehiculo El objeto VehiculoDTO que contiene los datos del
     * nuevo vehículo a registrar.
     * @return El objeto Vehiculo recién registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * persistencia.
     */
    @Override
    public Vehiculo registrarVehiculo(VehiculoDTO nuevoVehiculo) throws PersistenciaException {
        Vehiculo vehiculo = new Vehiculo(
                nuevoVehiculo.getNumero_serie(),
                nuevoVehiculo.getModelo(),
                nuevoVehiculo.getColor(),
                nuevoVehiculo.getMarca(),
                nuevoVehiculo.getLinea(),
                true);
        vehiculoDAO.agregarVehiculo(vehiculo);
        return vehiculo;
    }

    /**
     * Transporta los datos de un nuevo vehículo y registra el vehículo en el
     * sistema.
     *
     * @param nuevoVehiculo El objeto VehiculoDTO que contiene los datos del
     * nuevo vehículo a registrar.
     * @return El objeto VehiculoDTO transportado, que contiene los mismos datos
     * que el vehículo registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * persistencia.
     */
    @Override
    public VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenciaException {
        VehiculoDTO vehiculoDTO = new VehiculoDTO(
                nuevoVehiculo.getNumero_serie(),
                nuevoVehiculo.getModelo(),
                nuevoVehiculo.getColor(),
                nuevoVehiculo.getMarca(),
                nuevoVehiculo.getLinea(),
                true);
        registrarVehiculo(vehiculoDTO);
        return vehiculoDTO;
    }

}
