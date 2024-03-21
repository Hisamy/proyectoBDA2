
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.DTO.NuevoClienteDTO;


public interface IClientesDAO {
    public Cliente agregarCliente(NuevoClienteDTO nuevoCliente);
    public Cliente consultarCliente(NuevoClienteDTO nuevoCliente);
}
