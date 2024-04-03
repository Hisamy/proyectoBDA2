/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IVehiculosDAO {

    /**
     * Agrega un nuevo vehículo.
     * 
     * @param nuevoVehiculo el vehículo a agregar
     * @return el vehículo agregado
     * @throws PersistenciaException si ocurre un error durante la persistencia
     */
    public Vehiculo agregarVehiculo(Vehiculo nuevoVehiculo) throws PersistenciaException;

    /**
     * Consulta un vehículo por su número de serie.
     * 
     * @param numero_serie el número de serie del vehículo a consultar
     * @return el vehículo encontrado
     * @throws PersistenciaException si ocurre un error durante la consulta
     */
    public Vehiculo consultarVehiculoPorNumSerie(String numero_serie) throws PersistenciaException;

    /**
     * Consulta si un vehículo existe en la base de datos.
     * 
     * @param numero_serie numero de serie del vehiculo
     * @return true si el vehículo existe, false si no existe
     */
    public boolean validarVehiculo (String numero_serie) throws PersistenciaException;
}
