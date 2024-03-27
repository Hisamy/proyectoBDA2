/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.LicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;

/**
 *
 * @author Ramosz
 */
public class ConsultaTramitesBO implements IConsultaTramitesBO {

    private final ILicenciasDAO licenciaDAO;

    public ConsultaTramitesBO() {
        Conexion conexion = new Conexion();
        this.licenciaDAO = new LicenciasDAO(conexion);
    }

    @Override
    public Licencia consultarLicencia(Cliente cliente) throws FindException {
        Licencia licencia = licenciaDAO.consultarDatosLicencia(cliente);
        Licencia getLicencia = new Licencia(
                licencia.getVigencia(),
                licencia.getFecha_expedicion(),
                licencia.getCosto(),
                cliente);
        return getLicencia;
    }

    @Override
    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException {
        Cliente cliente = new Cliente(
                clienteDTO.getCURP(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido_paterno(),
                clienteDTO.getApellido_materno(),
                clienteDTO.isDiscapacidad(),
                clienteDTO.getRFC(),
                clienteDTO.getTelefono(),
                clienteDTO.getFecha_nacimiento());
        consultarLicencia(cliente);
        return cliente;
    }

    @Override
    public Boolean transporteDatos(ClienteDTO cienteDTO) {
        try {
            transporteDatosConsultarCliente(cienteDTO);
        } catch (FindException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
