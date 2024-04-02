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
 * @author Ramosz
 */
public interface IConsultaTramitesBO {

    /**
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    public Licencia consultarLicencia(Cliente cliente) throws FindException;

    /**
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    public Placa consultarPlaca(Cliente cliente) throws FindException;

    /**
     *
     * @param clienteDTO
     * @return
     * @throws FindException
     */
    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException;

    /**
     *
     * @param cienteDTO
     * @return
     */
    public Boolean transporteDatos(ClienteDTO cienteDTO);

    /**
     *
     * @return @throws FindException
     */
    public List<TramiteDTO> historialTramite() throws FindException;

    public boolean validarLicencia(ClienteDTO clienteDTO) throws FindException;

}
