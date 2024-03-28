/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

public interface IVehiculosDAO {

    public Vehiculo agregarVehiculo(Vehiculo nuevoVehiculo) throws PersistenciaException;

    public Vehiculo consultarVehiculo(String numero_serie) throws PersistenciaException;
}
