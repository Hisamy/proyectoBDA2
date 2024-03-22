
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.List;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;


public class ConsultaClientesBO implements IConsultaClientesBO{
    private IClientesDAO clienteDAO;
    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());
    
    public ConsultaClientesBO() {
         IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
    }

    @Override
    public ClienteDTO consultarCliente(String RFC,  List<Cliente> listaClientes) {
        
    }
    
    
    
}
