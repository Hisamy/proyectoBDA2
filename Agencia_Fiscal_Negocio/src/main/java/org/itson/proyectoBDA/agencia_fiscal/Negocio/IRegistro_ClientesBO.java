package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dto.NuevoClienteDTO;

public interface IRegistro_ClientesBO {

    public boolean validarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;

    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;
    
    public NuevoClienteDTO transporteDatos (NuevoClienteDTO nuevoCliente);
}
