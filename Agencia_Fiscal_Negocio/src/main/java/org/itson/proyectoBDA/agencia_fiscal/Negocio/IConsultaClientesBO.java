
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;


public interface IConsultaClientesBO {
    public Cliente consultarClientePorRFC (String RFC);
    public ClienteDTO consultarClienteDTOPorRFC (ClienteDTO clienteDTO);
    
}
