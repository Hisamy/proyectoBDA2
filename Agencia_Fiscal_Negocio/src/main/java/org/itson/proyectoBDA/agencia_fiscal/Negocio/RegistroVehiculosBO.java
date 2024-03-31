package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.VehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import static org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroClientesBO.logger;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class RegistroVehiculosBO implements IRegistroVehiculosBO {

    private final VehiculosDAO vehiculoDAO;
    private final IClientesDAO clienteDAO;

    public RegistroVehiculosBO() {
        IConexion conexion = new Conexion();
        this.vehiculoDAO = new VehiculosDAO(conexion);
        this.clienteDAO = new ClientesDAO(conexion);
    }

    /**
     * Registra un nuevo vehículo en el sistema utilizando los datos proporcionados en un objeto VehiculoDTO.
     *
     * @param nuevoVehiculo El objeto VehiculoDTO que contiene los datos del nuevo vehículo a registrar.
     * @return El objeto Vehiculo recién registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    @Override
    public Vehiculo registrarVehiculo(VehiculoDTO nuevoVehiculo) throws PersistenciaException {
        try {
            Vehiculo vehiculo = new Vehiculo(
                    nuevoVehiculo.getNumero_serie(),
                    nuevoVehiculo.getTipo(),
                    nuevoVehiculo.getModelo(),
                    nuevoVehiculo.getColor(),
                    nuevoVehiculo.getMarca(),
                    nuevoVehiculo.getLinea(),
                    true,
                    clienteDAO.consultarClienteRFC(nuevoVehiculo.getClienteDTO().getRFC()));
            vehiculo = vehiculoDAO.agregarVehiculo(vehiculo);
            return vehiculo;
        } catch (PersistenciaException e) {
            logger.warning("No se puedo registrar correctamente el cliente");
            throw e;
        }
    }

    /**
     * Transporta los datos de un nuevo vehículo y registra el vehículo en el sistema.
     *
     * @param nuevoVehiculo El objeto VehiculoDTO que contiene los datos del nuevo vehículo a registrar.
     * @return El objeto VehiculoDTO transportado, que contiene los mismos datos que el vehículo registrado.
     *
     */
    @Override
    public VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenceException {
        try {
            registrarVehiculo(nuevoVehiculo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroVehiculosBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoVehiculo;
    }

    @Override
    public Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException {
        return new Cliente(
                clienteDTO.getCURP(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido_paterno(),
                clienteDTO.getApellido_materno(),
                clienteDTO.isDiscapacidad(),
                clienteDTO.getRFC(),
                clienteDTO.getTelefono(),
                clienteDTO.getFecha_nacimiento());
    }
}
