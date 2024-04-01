package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

/**
 *
 * @author Ramosz
 */
public interface IConsultaClientesBO {

    /**
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException;

    /**
     *
     * @param RFC
     * @return
     * @throws FindException
     */
    public Cliente consultarClientePorRFC(String RFC) throws FindException;

    /**
     *
     * @param RFC
     * @return
     * @throws FindException
     */
    public ClienteDTO transporteDatos(String RFC) throws FindException;

    /**
     *
     * @param cliente
     * @throws FindException
     */
    public void validarEdad(Cliente cliente) throws FindException;

    /**
     *
     * @param cliente
     * @return
     */
    public Integer calcularEdad(Cliente cliente);

    /**
     *
     * @return
     * @throws FindException
     */
    public List<ClienteDTO> historialCliente() throws FindException;

    /**
     *
     * @param nombre_apellido
     * @return
     * @throws FindException
     */
    public List<ClienteDTO> consultarClientePorNombre(String nombre_apellido) throws FindException;

    /**
     *
     * @param anio
     * @return
     * @throws FindException
     */
    public List<ClienteDTO> consultarClientePorFechaNacimiento(int anio) throws FindException;

}
