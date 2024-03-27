package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public interface IConsultaVehiculosBO {

    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException;

    public VehiculoDTO transporteDatos(String numero_serie) throws FindException;

    public VehiculoDTO consultarVehiculoDTONumSerie(Vehiculo vehiculo) throws FindException;
}