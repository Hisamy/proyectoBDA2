package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
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

/**
 * @author Eduardo Talavera, Hisamy Cinco
 */
public class RegistroVehiculosBO implements IRegistroVehiculosBO {

    private final VehiculosDAO vehiculoDAO;
    private final IClientesDAO clienteDAO;

    /**
     *
     */
    public RegistroVehiculosBO() {
        IConexion conexion = new Conexion();
        this.vehiculoDAO = new VehiculosDAO(conexion);
        this.clienteDAO = new ClientesDAO(conexion);
    }

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
     * Transporta los datos de un nuevo vehículo y registra el vehículo en el
     * sistema.
     *
     * @param nuevoVehiculo El objeto VehiculoDTO que contiene los datos del
     * nuevo vehículo a registrar.
     * @return El objeto VehiculoDTO transportado, que contiene los mismos datos
     * que el vehículo registrado.
     *
     */
    @Override
    public VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenceException, PersistenciaException {
        try {
            if (validarVehiculo(nuevoVehiculo.getNumero_serie())) {
                registrarVehiculo(nuevoVehiculo);
            } else {
                JOptionPane.showMessageDialog(null, "El número de serie ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                // Realiza alguna acción alternativa en lugar de lanzar la excepción nuevamente
                // Por ejemplo, puedes devolver null para indicar que no se pudo registrar el vehículo
            }
        } catch (PersistenciaException ex) {
            // Maneja la excepción si ocurre un error durante el registro
            Logger.getLogger(RegistroVehiculosBO.class.getName()).log(Level.SEVERE, null, ex);
            // Realiza alguna acción alternativa en lugar de lanzar la excepción nuevamente
            // Por ejemplo, puedes devolver null para indicar que no se pudo registrar el vehículo
            throw new PersistenciaException("No se pudo registrar el vehículo", ex);
        }

        // Devuelve el objeto VehiculoDTO solo si se registró correctamente
        return nuevoVehiculo;
    }

    /**
     * Convierte un objeto ClienteDTO en un objeto Cliente.
     *
     * @param clienteDTO El objeto ClienteDTO a convertir.
     * @return El objeto Cliente resultante de la conversión.
     * @throws PersistenciaException Si ocurre un error durante la conversión.
     */
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

    @Override
    public boolean validarVehiculo(String numero_serie) throws PersistenciaException {
        try {
            vehiculoDAO.validarVehiculo(numero_serie);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, "El número de serie ya existe: " + numero_serie);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            return false;
        }

    }

}
