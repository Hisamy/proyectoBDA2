
package org.itson.proyectoBDA.agencia_fiscal.NEGOCIO;

import org.itson.proyectoBDA.agencia_fiscal.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.dto.NuevoClienteDTO;


public interface IRegistro_ClientesBO {
    public boolean validarClienteDTO (NuevoClienteDTO nuevoCliente);
    public Cliente registrarClienteDTO (NuevoClienteDTO nuevoCliente);
}
