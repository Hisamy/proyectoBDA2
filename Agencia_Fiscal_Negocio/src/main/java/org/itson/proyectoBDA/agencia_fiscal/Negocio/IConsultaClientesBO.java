package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IConsultaClientesBO {

    /**
     * Consulta un objeto ClienteDTO por su RFC.
     *
     * @param cliente El objeto Cliente.
     * @return El ClienteDTO asociado al RFC.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException;

    /**
     * Consulta un cliente por su RFC.
     *
     * @param RFC El RFC del cliente a consultar.
     * @return El cliente consultado.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public Cliente consultarClientePorRFC(String RFC) throws FindException;

    /**
     * Transporta datos de un cliente por su RFC.
     *
     * @param RFC El RFC del cliente cuyos datos se desean transportar.
     * @return Los datos del cliente transportados.
     * @throws FindException si ocurre un error durante el transporte de datos.
     */
    public ClienteDTO transporteDatos(String RFC) throws FindException;

    /**
     * Valida la edad de un cliente.
     *
     * @param cliente El objeto Cliente a validar.
     * @throws FindException si ocurre un error durante la validación.
     */
    public void validarEdad(Cliente cliente) throws FindException;

    /**
     * Calcula la edad de un cliente.
     *
     * @param cliente El objeto Cliente.
     * @return La edad del cliente.
     */
    public Integer calcularEdad(Cliente cliente);

    /**
     * Obtiene el historial de clientes.
     *
     * @return El historial de clientes.
     * @throws FindException si ocurre un error durante la consulta del
     * historial.
     */
    public List<ClienteDTO> historialCliente() throws FindException;

    /**
     * Consulta clientes por nombre o apellido.
     *
     * @param nombre_apellido El nombre o apellido del cliente a consultar.
     * @return La lista de clientes encontrados.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public List<ClienteDTO> consultarClientePorNombre(String nombre_apellido) throws FindException;

    /**
     * Consulta clientes por año de fecha de nacimiento.
     *
     * @param anio El año de nacimiento de los clientes a consultar.
     * @return La lista de clientes encontrados.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public List<ClienteDTO> consultarClientePorFechaNacimiento(int anio) throws FindException;

}
