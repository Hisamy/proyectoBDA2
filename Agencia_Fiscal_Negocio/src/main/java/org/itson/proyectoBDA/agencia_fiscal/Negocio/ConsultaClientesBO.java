package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

public class ConsultaClientesBO implements IConsultaClientesBO {

    private IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());
    

    public ConsultaClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

 


    @Override
    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException{
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
    public void consultarClientePorRFC(String RFC) throws FindException{
        Cliente cliente = clienteDAO.consultarCliente(RFC);  
        consultarClienteDTOPorRFC(cliente);
    }
        
     
}

   
    
    
    
    

