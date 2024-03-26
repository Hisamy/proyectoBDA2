/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;

/**
 *
 * @author Ramosz
 */
public interface IPlacasDAO {

    public Placa agregarLicencia(Placa nuevaPlaca);

    public Placa consultarDatosPlaca();
}
