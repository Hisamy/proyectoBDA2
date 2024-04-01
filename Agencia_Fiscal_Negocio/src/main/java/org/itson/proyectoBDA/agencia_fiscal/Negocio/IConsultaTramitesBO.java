package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

public interface IConsultaTramitesBO {

    public Licencia consultarLicencia(Cliente cliente) throws FindException;

    public Placa consultarPlaca(Cliente cliente) throws FindException;

    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException;

    public Boolean transporteDatos(ClienteDTO cienteDTO);

    public List<TramiteDTO> historialTramite() throws FindException;

}
