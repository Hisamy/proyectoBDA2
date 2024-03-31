package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

public class ConsultaClientesBO implements IConsultaClientesBO {

    private final IClientesDAO clienteDAO;

    public ConsultaClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

    /**
     * Consulta los datos de un cliente por su RFC y los retorna en formato DTO.
     *
     * @param cliente El cliente a consultar.
     * @return ClienteDTO con los datos del cliente.
     * @throws FindException Si ocurre un error durante la consulta.
     */
    @Override
    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException {
        validarEdad(cliente);
        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getCURP(),
                cliente.getNombre(),
                cliente.getApellido_paterno(),
                cliente.getApellido_materno(),
                cliente.isDiscapacidad(),
                cliente.getRFC(),
                cliente.getTelefono(),
                cliente.getFecha_nacimiento());
        return clienteDTO;
    }

    /**
     * Consulta un cliente por su RFC.
     *
     * @param RFC El RFC del cliente a consultar.
     * @return Cliente con los datos del cliente.
     * @throws FindException Si ocurre un error durante la consulta.
     */
    @Override
    public Cliente consultarClientePorRFC(String RFC) throws FindException {
        try {
            Cliente cliente = clienteDAO.consultarCliente(RFC);
            consultarClienteDTOPorRFC(cliente);
            Cliente getCliente = new Cliente(
                    cliente.getCURP(),
                    cliente.getNombre(),
                    cliente.getApellido_paterno(),
                    cliente.getApellido_materno(),
                    cliente.isDiscapacidad(),
                    cliente.getRFC(),
                    cliente.getTelefono(),
                    cliente.getFecha_nacimiento());
            return getCliente;
        } catch (PersistenciaException e) {
            throw new FindException(e.getMessage());
        }
    }

    /**
     * Realiza el transporte de datos de un cliente a través del RFC.
     *
     * @param RFC El RFC del cliente a consultar.
     * @return ClienteDTO con los datos del cliente.
     * @throws FindException Si ocurre un error durante la consulta.
     */
    @Override
    public ClienteDTO transporteDatos(String RFC) throws FindException {
        Cliente cliente = consultarClientePorRFC(RFC);
        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getCURP(),
                cliente.getNombre(),
                cliente.getApellido_paterno(),
                cliente.getApellido_materno(),
                cliente.isDiscapacidad(),
                cliente.getRFC(),
                cliente.getTelefono(),
                cliente.getFecha_nacimiento());
        return clienteDTO;
    }

    /**
     * Valida la edad del cliente.
     *
     * @param cliente El cliente a validar.
     * @throws FindException Si el cliente es menor de edad.
     */
    @Override
    public void validarEdad(Cliente cliente) throws FindException {
        if (calcularEdad(cliente) < 18) {
            throw new FindException("El cliente es menor de edad.");
        }
    }

    /**
     * Calcula la edad de un cliente en base a su fecha de nacimiento.
     *
     * @param cliente El cliente del cual se calcula la edad.
     * @return La edad del cliente.
     */
    @Override
    public Integer calcularEdad(Cliente cliente) {
        Calendar fechaNacimiento = cliente.getFecha_nacimiento();
        Calendar fechaActual = new GregorianCalendar();
        Integer edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

        if (fechaNacimiento.get(Calendar.MONTH) > fechaActual.get(Calendar.MONTH)
                || (fechaNacimiento.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH)
                && fechaNacimiento.get(Calendar.DAY_OF_MONTH) > fechaActual.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad;
    }

    @Override
    public List<ClienteDTO> historialCliente() throws FindException {
        try {
            List<Cliente> clientes = clienteDAO.historialClientes();
            List<ClienteDTO> clientesDTO = new ArrayList<>();
            for (Cliente cliente : clientes) {
                ClienteDTO clienteDTO = new ClienteDTO(
                        cliente.getCURP(),
                        cliente.getNombre(),
                        cliente.getApellido_paterno(),
                        cliente.getApellido_materno(),
                        cliente.isDiscapacidad(),
                        cliente.getRFC(),
                        cliente.getTelefono(),
                        cliente.getFecha_nacimiento());
                clientesDTO.add(clienteDTO);
            }
            return clientesDTO;
        } catch (FindException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new FindException(ex.getMessage());
        }

    }

}
