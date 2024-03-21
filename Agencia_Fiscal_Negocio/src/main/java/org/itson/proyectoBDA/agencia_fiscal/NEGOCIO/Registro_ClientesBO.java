
package org.itson.proyectoBDA.agencia_fiscal.NEGOCIO;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.dto.NuevoClienteDTO;


public class Registro_ClientesBO implements IRegistro_ClientesBO{
    private IClientesDAO cliente;

    public Registro_ClientesBO(IClientesDAO cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean validarClienteDTO(NuevoClienteDTO nuevoCliente) {
      return true;
    }

    @Override
    public Cliente registrarClienteDTO(NuevoClienteDTO nuevoCliente) {
        Cliente clienteNuevo;
        if (validarClienteDTO(nuevoCliente)){
           clienteNuevo = cliente.agregarCliente(
                   new Cliente (
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
        }
        
        else{
           
        }
   
}
    
}
