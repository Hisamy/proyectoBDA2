package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;

public class ConsultaClientesBO implements IConsultaClientesBO {

    private IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());
    private List<Cliente> listaClientes;
    

    public ConsultaClientesBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

 


    @Override
    public Cliente consultarClientePorRFC(String RFC) {
          Cliente cliente = clienteDAO.consultarCliente(RFC);
              
            
        }

    @Override
    public ClienteDTO consultarClienteDTOPorRFC(ClienteDTO clienteDTO) {
         String RFC = clienteDTO.getRFC();
        for (Cliente cliente : listaClientes) {
            if (cliente.getRFC().equals(RFC)) {
                return cliente;
            }
        }
        return null; 
    }
    }
        
     
}

   
    
    
    
    

