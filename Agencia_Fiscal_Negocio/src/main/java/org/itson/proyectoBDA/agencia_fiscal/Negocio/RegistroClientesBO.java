package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.NuevoClienteDTO;

public class RegistroClientesBO implements IRegistroClientesBO {

    private final IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());

    public RegistroClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

    @Override
    public boolean validarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        return true;
    }

    /**
     * Registra un cliente. Convierte el NuevoClienteDTO a cliente para poder
     * mandar los datos del cliente a la capa de persistencia.
     *
     * @param nuevoCliente nuevo cliente que se está registrando
     * @return una variable de tipo id_cliente
     * @throws PersistenciaException Por si no se puedo guardar correctamente el
     * cliente.
     */
    @Override
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        try {
            validarCliente(nuevoCliente);
            Cliente clienteNuevo = clienteDAO.agregarCliente(new Cliente(
                    nuevoCliente.getCURP(),
                    nuevoCliente.getNombre(),
                    nuevoCliente.getApellido_paterno(),
                    nuevoCliente.getApellido_materno(),
                    nuevoCliente.isDiscapacidad(),
                    nuevoCliente.getRFC(),
                    nuevoCliente.getTelefono(),
                    nuevoCliente.getFecha_nacimiento()
            ));
            return clienteNuevo;
        } catch (PersistenciaException e) {
            logger.warning("No se puedo registrar correctamente el vehiculo");
            throw e;
        }
    }

    /**
     * Transporta los datos de un nuevo cliente y los registra en el sistema.
     *
     * @param nuevoCliente El objeto NuevoClienteDTO que contiene los datos del
     * nuevo cliente.
     * @return El objeto NuevoClienteDTO transportado.
     */
    @Override
    public NuevoClienteDTO transporteDatos(NuevoClienteDTO nuevoCliente) {
        try {
            registrarCliente(nuevoCliente);
        } catch (PersistenciaException e) {
            logger.warning("Error al transportar los datos");
        }
        return nuevoCliente;
    }
}
