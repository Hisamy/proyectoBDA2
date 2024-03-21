
package org.itson.proyectoBDA.agencia_fiscal.NEGOCIO;

import org.itson.proyectoBDA.agencia_fiscal.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.dto.NuevoClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.exception.PersistenciaException;


public interface IRegistro_ClientesBO {
    public boolean validarClienteDTO (NuevoClienteDTO nuevoCliente) throws PersistenciaException;
    public Cliente registrarClienteDTO (NuevoClienteDTO nuevoCliente) throws PersistenciaException;
}
