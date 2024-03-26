package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

public interface IConsultaClientesBO {

    public ClienteDTO consultarClienteDTOPorRFC(Cliente cliente) throws FindException;

    public Cliente consultarClientePorRFC(String RFC) throws FindException;

    public ClienteDTO transporteDatos(String RFC) throws FindException;
    
    public void validarEdad(Cliente cliente) throws FindException;
    
    public Integer calcularEdad(Cliente cliente);

}
