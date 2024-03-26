/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroPlacasBO {

    Placa registrarPlaca(PlacaDTO nuevoLicencia, String RFC) throws PersistenciaException;

    PlacaDTO transporteDatos(PlacaDTO nuevaPlaca, String RFC) throws PersistenciaException;
}
