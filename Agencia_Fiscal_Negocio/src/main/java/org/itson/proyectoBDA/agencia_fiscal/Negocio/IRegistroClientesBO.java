package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.NuevoClienteDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroClientesBO {

    /**
     *
     * @param nuevoCliente
     * @return
     * @throws PersistenciaException
     */
    public boolean validarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;

    /**
     *
     * @param nuevoCliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;
    
    /**
     *
     * @param nuevoCliente
     * @return
     */
    public NuevoClienteDTO transporteDatos (NuevoClienteDTO nuevoCliente);
}
