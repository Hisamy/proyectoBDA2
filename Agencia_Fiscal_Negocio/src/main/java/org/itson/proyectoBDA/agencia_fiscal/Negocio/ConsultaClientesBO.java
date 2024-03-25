package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

public class ConsultaClientesBO implements IConsultaClientesBO {

    private IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());

    public ConsultaClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

    /**
     * Metodo el cual regresa los datos del cliente con el RFC encontrado a la capa de presentación mediante la DTO.
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    @Override
    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException {
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
     * Recibe el RFC que se envió desde la presentación mediante la DTO y luego se conecta mediante clienteDAO para consultar al cliente en la base de datos, el cliente con el RFC encontrado se manda al metodo consultarClienteDTOPorRFC de tipo DTO.
     *
     * @param RFC
     * @return
     * @throws FindException
     */
    @Override
    public Cliente consultarClientePorRFC(String RFC) throws FindException {
        Cliente cliente = clienteDAO.consultarCliente(RFC);
        if (cliente != null) {

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
        }
        return null;
    }

    /**
     * Se hizo un metodo transporteDatos() para mandar el RFC al metodo consultarClientePorRFC()
     *
     * @param RFC
     * @return
     * @throws FindException
     */
    @Override
    public ClienteDTO transporteDatos(String RFC) throws FindException {
        Cliente cliente = consultarClientePorRFC(RFC);
        if (cliente != null) {
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
        return null;
    }
}
