/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;

/**
 *
 * @author Ramosz
 */
public interface IConsultaTramitesBO {

    public Licencia consultarLicencia(Cliente cliente) throws FindException;

    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException;

    public Boolean transporteDatos(ClienteDTO cienteDTO);
}
