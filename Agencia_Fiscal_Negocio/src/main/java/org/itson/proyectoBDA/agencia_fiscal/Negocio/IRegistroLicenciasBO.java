/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroLicenciasBO {

    Licencia registrarLicencia(LicenciaDTO nuevoLicencia,String RFC) throws PersistenciaException;

    LicenciaDTO transporteDatos(LicenciaDTO nuevaLicencia) throws PersistenciaException;
}
