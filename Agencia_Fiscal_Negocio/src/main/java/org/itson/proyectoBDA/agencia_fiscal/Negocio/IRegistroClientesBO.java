package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.NuevoClienteDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IRegistroClientesBO {

    /**
     * Valida un nuevo cliente.
     *
     * @param nuevoCliente El objeto DTO que representa al nuevo cliente.
     * @return {@code true} si el cliente es válido, {@code false} en caso
     * contrario.
     * @throws PersistenciaException si ocurre un error durante la validación.
     */
    public boolean validarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;

    /**
     * Registra un nuevo cliente.
     *
     * @param nuevoCliente El objeto DTO que representa al nuevo cliente.
     * @return El cliente registrado.
     * @throws PersistenciaException si ocurre un error durante el registro.
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;

    /**
     * Transporta los datos de un nuevo cliente.
     *
     * @param nuevoCliente El objeto DTO que representa los datos del cliente.
     * @return Los datos del cliente transportados.
     */
    public NuevoClienteDTO transporteDatos(NuevoClienteDTO nuevoCliente);
}
