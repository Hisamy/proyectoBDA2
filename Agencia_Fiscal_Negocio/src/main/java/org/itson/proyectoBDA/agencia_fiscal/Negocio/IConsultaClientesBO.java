
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;


public interface IConsultaClientesBO {
    public ClienteDTO consultarCliente (String RFC);
}
