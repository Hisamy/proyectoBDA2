package org.itson.proyectoBDA.agencia_fiscal.NEGOCIO;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.ENTIDADES.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.dto.NuevoClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.EXCEPCIONES.PersistenciaException;

public class Registro_ClientesBO implements IRegistro_ClientesBO {

    private IClientesDAO cliente;
    static final Logger logger = Logger.getLogger(Registro_ClientesBO.class.getName());

    public Registro_ClientesBO() {
    }

    public Registro_ClientesBO(IClientesDAO cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean validarClienteDTO(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        if (nuevoCliente.getNombre().isBlank()
                && nuevoCliente.getApellido_paterno().isBlank()
                && nuevoCliente.getApellido_materno().isBlank()
                && nuevoCliente.getFecha_nacimiento().toString().isBlank()
                && nuevoCliente.getCURP().isBlank()
                && nuevoCliente.getRFC().isBlank()
                && nuevoCliente.getTelefono().isBlank()) {
            return false;
        }
        return true;
    }

    /**
     * Registra un cliente. Convierte el NuevoClienteDTO a cliente para poder mandar los datos del cliente a la capa de persistencia.
     *
     * @param nuevoCliente nuevo cliente que se está registrando
     * @return una variable de tipo Cliente
     * @throws PersistenciaException Por si no se puedo guardar correctamente el cliente.
     */
    @Override
    public Cliente registrarClienteDTO(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        try {
            validarClienteDTO(nuevoCliente);
            Cliente clienteNuevo = cliente.agregarCliente(
                    new Cliente(
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
            logger.warning("No se puedo registrar correctamente el cliente");
            throw e;
        }
    }
}
