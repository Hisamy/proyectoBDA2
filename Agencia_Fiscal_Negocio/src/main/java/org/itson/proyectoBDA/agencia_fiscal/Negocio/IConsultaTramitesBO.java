
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;

public interface IConsultaTramitesBO {

    public Licencia consultarLicencia(Cliente cliente) throws FindException;

    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException;

    public Boolean transporteDatos(ClienteDTO cienteDTO);
}
