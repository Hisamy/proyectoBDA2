package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    private IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());

    public ConsultaClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

    /**
     * Metodo el cual regresa los datos del cliente con el RFC encontrado a la
     * capa de presentación mediante la DTO.
     *
     * @param cliente
     * @return
     * @throws FindException
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
     * Recibe el RFC que se envió desde la presentación mediante la DTO y luego
     * se conecta mediante clienteDAO para consultar al cliente en la base de
     * datos, el cliente con el RFC encontrado se manda al metodo
     * consultarClienteDTOPorRFC de tipo DTO.
     *
     * @param RFC
     * @return
     * @throws FindException
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
     * Se hizo un metodo transporteDatos() para mandar el RFC al metodo
     * consultarClientePorRFC()
     *
     * @param RFC
     * @return
     * @throws FindException
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

    @Override
    public void validarEdad(Cliente cliente) throws FindException {
        if (calcularEdad(cliente) < 18) {
            throw new FindException("El cliente es menor de edad.");

        }

    }

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

}
