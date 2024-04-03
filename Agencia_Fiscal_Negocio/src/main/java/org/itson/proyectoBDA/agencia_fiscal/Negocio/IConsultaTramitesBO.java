package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IConsultaTramitesBO {

    /**
     * Consulta la licencia de un cliente.
     *
     * @param cliente El cliente para el cual se consulta la licencia.
     * @return La licencia del cliente.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public Licencia consultarLicencia(Cliente cliente) throws FindException;

    /**
     * Consulta la placa de un cliente.
     *
     * @param cliente El cliente para el cual se consulta la placa.
     * @return La placa del cliente.
     * @throws FindException si ocurre un error durante la consulta.
     */
    public Placa consultarPlaca(Cliente cliente) throws FindException;

    /**
     * Transporta los datos para consultar un cliente.
     *
     * @param clienteDTO El DTO del cliente a consultar.
     * @return El cliente consultado.
     * @throws FindException si ocurre un error durante el transporte de datos.
     */
    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException;

    /**
     * Transporta datos de un cliente.
     *
     * @param clienteDTO El DTO del cliente.
     * @return {@code true} si el transporte de datos fue exitoso, {@code false}
     * en caso contrario.
     */
    public Boolean transporteDatos(ClienteDTO clienteDTO);

    /**
     * Obtiene el historial de trámites.
     *
     * @return El historial de trámites.
     * @throws FindException si ocurre un error durante la consulta del
     * historial.
     */
    public List<TramiteDTO> historialTramite() throws FindException;

    /**
     * Valida la licencia de un cliente.
     *
     * @param clienteDTO El DTO del cliente cuya licencia se valida.
     * @return {@code true} si la licencia es válida, {@code false} en caso
     * contrario.
     * @throws FindException si ocurre un error durante la validación.
     */
    public boolean validarLicencia(ClienteDTO clienteDTO) throws FindException;

}
