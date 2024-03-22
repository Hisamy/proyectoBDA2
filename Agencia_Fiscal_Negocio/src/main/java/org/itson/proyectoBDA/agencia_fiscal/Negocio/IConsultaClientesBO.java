
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;


public interface IConsultaClientesBO {
    public ClienteDTO consultarClienteDTOPorRFC (Cliente cliente) throws FindException;
    public void consultarClientePorRFC (String RFC) throws FindException;
    
}
